package com.threewater.template.background.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class TestContextListener implements ServletContextListener {
    private static final Logger log = LoggerFactory.getLogger(TestRequestListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("======contextInitialized Listener========");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("======contextDestroyed Listener========");
    }
}
