package com.website.company.ServletClass;

import com.website.company.service.NewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;

@WebListener
public class MyContextListener implements ServletContextListener {

    private static Logger logger = LoggerFactory.getLogger(MyContextListener.class);

    public ArrayList<String> sessionList = new ArrayList<String>();

    @Autowired
    NewsService newsService;

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        logger.info("-------服务器停止-------");
        ArrayList<String> sessionList = (ArrayList<String>) arg0.getServletContext().getAttribute("sessionList");
        sessionList.clear();//会话清空
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        logger.info("-------服务器启动-------");
        arg0.getServletContext().setAttribute("sessionList", sessionList);
    }
}
