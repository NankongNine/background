package com.threewater.template.background.controller;

import com.threewater.template.background.exception.MyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exception")
public class ExceptionContronller {

//    @Autowired
//    private ErrorCode errorCode;

//    @Autowired
//    private Map<String,String> errMap;

    @RequestMapping("/test")
    public String hello(){
//        System.out.println(errorCode.getMap());
//        System.out.println(errMap);

        try {
            int n = 1 / 0;
        }catch(Exception e){
            throw new MyException("TEST0002", e, "除数为0");
        }
        return "exception";
    }
}
