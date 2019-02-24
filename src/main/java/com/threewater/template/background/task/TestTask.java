package com.threewater.template.background.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 功能描述：定时任务业务类
 */
@Component
public class TestTask {

	
	@Scheduled(fixedRate=2000)//两秒执行一次
//	@Scheduled(cron="*/2 * * * * *")
//	@Scheduled(fixedDelay = 2000)
	public void sum() throws InterruptedException{

//		Thread.sleep(4000L);
		Thread current = Thread.currentThread();
		System.out.println("结束 当前时间:"+new Date()+" current: "+current.getName());
		
	}
	
	
	
	
	//@Scheduled(cron="*/1 * * * * *")
	public void sum2(){
		System.out.println("cron 每秒 当前时间:"+new Date());
	}
	
	
	
	
	
}
