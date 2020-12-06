package com.website.company.ServletClass;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.SessionListenerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author pengyangyan
 */
public class ShiroSessionListener implements SessionListener {

    private final AtomicInteger sessionCount = new AtomicInteger(0);
    private static final Logger LOGGER = LoggerFactory.getLogger(ShiroSessionListener.class);

    @Override
    public void onStart(Session session) {
        sessionCount.incrementAndGet();
        LOGGER.info("在线人数：",sessionCount);

    }

    @Override
    public void onStop(Session session) {
        sessionCount.decrementAndGet();
        LOGGER.info("在线人数：",sessionCount);

    }

    @Override
    public void onExpiration(Session session) {
        sessionCount.decrementAndGet();
        LOGGER.info("在线人数：",sessionCount);
    }
}
