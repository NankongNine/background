package com.threewater.template.background.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class TestRequestListener implements ServletRequestListener {
    private static final Logger log = LoggerFactory.getLogger(TestRequestListener.class);

    @Override
    public void requestDestroyed(ServletRequestEvent sre){
        log.info("requestDestroyed Listener");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        log.info("requestInitialized Listener");
    }
}
