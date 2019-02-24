package com.threewater.template.background.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/test")
    public String hello(){
        log.debug("test debug level");
        log.info("test info level");
        log.warn("test warn level");
        log.error("test error level");
        return "hello";
    }

    @RequestMapping("/api/intercepter")
    public String testIntercepter(){
        return "hello";
    }
}
