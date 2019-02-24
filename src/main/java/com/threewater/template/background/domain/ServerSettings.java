package com.threewater.template.background.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

//服务器配置

@Component
@PropertySource({"classpath:/config/property-test.properties"})//该注解无法加载yml配置文件
@ConfigurationProperties(prefix="custom")
public class ServerSettings {

	private String appname;

	private String domain;

	public String getAppname() {
		return appname;
	}

	public void setAppname(String appname) {
		this.appname = appname;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	
	
	
}
