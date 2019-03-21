package com.accp.quartz;

import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import com.accp.dao.gsq.IUserDao;

/**
 * 
* @ClassName: QuartzRun 
* @Description: 每日6点重置所有用户的签到
* @author 筠颜
* @date 2019年3月18日 下午9:26:11 
*
 */
@Configuration
public class QuartzRun{
	@Autowired
	private  IUserDao dao;

	@Scheduled(cron = "0 0 6 * * ?")
	public void execute() throws JobExecutionException {
		System.err.println("每日6点重置签到");
		dao.updateUserSign(0,0,0);
	}

}
