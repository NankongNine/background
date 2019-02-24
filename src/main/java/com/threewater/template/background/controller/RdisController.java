package com.threewater.template.background.controller;

import com.threewater.template.background.domain.UserInfo;
import com.threewater.template.background.utils.JsonData;
import com.threewater.template.background.utils.JsonUtil;
import com.threewater.template.background.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
@RequestMapping("/api/v1/redis")
public class RdisController {

	
	@Autowired
	private StringRedisTemplate redisTpl; //jdbcTemplate

	@Autowired
	private RedisUtil redis;
	
	@GetMapping(value="add")
	public Object add(){
		 
		//redisTpl.opsForValue().set("name", "ch");
		redis.set("username", "ch");
		return JsonData.buildSuccess();
		
	}
	
	@GetMapping(value="get")
	public Object get(){
		
		//String value = redisTpl.opsForValue().get("name");
		String value = redis.get("username");
		return JsonData.buildSuccess(value);
		
	}
	

	@GetMapping(value="save_user")
	public Object saveUser(){
		UserInfo userInfo = new UserInfo("abc", "11", new Date());
		String userStr = JsonUtil.obj2String(userInfo);
		boolean flag = redis.set("base:userInfo:11", userStr);
		return JsonData.buildSuccess(flag);
		
	}
	
	@GetMapping(value="find_user")
	public Object findUser(){

		String userStr = redis.get("base:userInfo:11");
		UserInfo userInfo = JsonUtil.string2Obj(userStr, UserInfo.class);
		
		return JsonData.buildSuccess(userInfo);
		
	}
	
	
}
