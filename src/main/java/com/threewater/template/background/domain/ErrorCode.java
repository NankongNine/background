package com.threewater.template.background.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

//错误码

@Component
@PropertySource(value = {"classpath:/message/err_zh.properties"}, encoding = "utf-8")
@ConfigurationProperties(prefix = "errcode")
public class ErrorCode {

	public Map<String, Object> map;

	public static ErrorCode errorCode;

	@PostConstruct
	public void init(){
		errorCode = this;
	}

	public static String getErrMsg(String str) {
		return (String)errorCode.map.get(str);
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
}
