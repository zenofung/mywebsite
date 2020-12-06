package com.website.company.ServletClass;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@WebListener
public class MyListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
        HttpSession session = request.getSession();//创建或获取session
        String url = request.getRequestURI();//获取访问新闻页面的url
        if (url.equals("/newsDetail")) {//如果访问新闻详情页面
            // System.out.println("---------------开启新闻页面监听器-------------------");
            int newsId = Integer.parseInt(request.getParameter("newsId"));//获取新闻id
            Map<Integer, Integer> newsIdVisit = (Map<Integer, Integer>) session.getAttribute("newsIdVisit");
            if (!newsIdVisit.containsKey(newsId)) {//如果没有访问过该条新闻，则记录一次访问数
                newsIdVisit.put(newsId, 1);
                session.setAttribute("newsIdVisit", newsIdVisit);
            }
        }
    }
}


