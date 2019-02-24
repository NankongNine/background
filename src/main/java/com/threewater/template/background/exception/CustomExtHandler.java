package com.threewater.template.background.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomExtHandler {

    private static final Logger log = LoggerFactory.getLogger(CustomExtHandler.class);

	//捕获全局异常,处理所有不可知的异常
	@ExceptionHandler(value=Exception.class)
	//@ResponseBody
    Object handleException(Exception e,HttpServletRequest request){
		log.error("url {}, msg {}",request.getRequestURL(), e.getMessage());
		e.printStackTrace();
		Map<String, Object> map = new HashMap<>();
	        map.put("code", 100);
	        map.put("msg", e.getMessage());
	        map.put("url", request.getRequestURL());
	        return map;
    }

	/**
	 * 功能描述：处理自定义异常
	 * @return
	 */
	@ExceptionHandler(value=MyException.class)
	Object handleMyException(MyException e,HttpServletRequest request){
		//进行页面跳转
//		ModelAndView modelAndView = new ModelAndView();
//	    modelAndView.setViewName("error.html");
//	    modelAndView.addObject("msg", e.getMessage());
//	    return modelAndView;

		//返回json数据，由前端去判断加载什么页面
		e.printStackTrace();
		Map<String, Object> map = new HashMap<>();
		map.put("code", e.getCode());
		map.put("msg", e.getMsg());
		map.put("url", request.getRequestURL());
		return map;

	}

//	/**
//	 * 功能描述：处理shiro异常
//	 * @return
//	 */
//	@ExceptionHandler(value= AuthenticationException.class)
//	Object handleAuthenticationException(AuthenticationException e,HttpServletRequest request){
//		//返回json数据，由前端去判断加载什么页面
//		e.printStackTrace();
//		Map<String, Object> map = new HashMap<>();
//		map.put("code", "01");
//		map.put("msg", "用户验证失败！");
//		map.put("url", request.getRequestURL());
//		return map;
//	}

}
