package com.website.company.ServletClass;


import com.website.company.service.NewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebListener
public class MySessionListener implements HttpSessionListener {

    private static Logger logger = LoggerFactory.getLogger(MySessionListener.class);

    @Autowired
    NewsService newsService;

    @Override
    public void sessionCreated(HttpSessionEvent arg0) {
//        System.out.println("---------------开启Session监听器-------------------");
        HttpSession session = arg0.getSession();
        session.setMaxInactiveInterval(3 * 60);
        ServletContext context = session.getServletContext();
        ArrayList<String> sessionList = (ArrayList<String>) context.getAttribute("sessionList");
        sessionList.add(session.getId());//将会话id加入context上下文
//        System.out.println("获取对象： "+sessionList);
        context.setAttribute("sessionList", sessionList);
        Map<Integer, Integer> newsIdVisit = new HashMap<Integer, Integer>();
        session.setAttribute("newsIdVisit", newsIdVisit);//每个会话的新闻访问情况

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent arg0) {
        logger.info("---------------关闭Session监听器-------------------");
        HttpSession session = arg0.getSession();
        ServletContext context = session.getServletContext();
        ArrayList<String> sessionList = (ArrayList<String>) context.getAttribute("sessionList");
        if (sessionList.contains(session.getId())) {
            sessionList.remove(session.getId());
        }
        System.out.println("销毁后的SessionId： " + session.getId());
        context.setAttribute("sessionList", sessionList);
        //获取该会话的新闻访问信息
        Map<Integer, Integer> newsIdVisit = (Map<Integer, Integer>) session.getAttribute("newsIdVisit");
        newsService.updateVisitNum(newsIdVisit);
        logger.info("保存浏览次数完毕");
    }
}
