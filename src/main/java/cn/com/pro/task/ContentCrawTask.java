package cn.com.pro.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cn.com.pro.service.JRedisService;

/**
 * @author zhoubin 抓取数据的任务，抽象类，任务的总入口类
 */
@Component
@EnableScheduling
public class ContentCrawTask {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private JRedisService jRedisService;

	/**
	 * 这里可以研究下如何通过总入口来调度 每一个子类只需写任务实现逻辑，不用关注同步 每天执行一次
	 */
	@Scheduled(cron = "20,30,50 * */1 * * *")
	public void scheduleTask() {

		log.info("start task======{}", Thread.currentThread());
		executeTask();
		log.info("end task======");
	}

	/**
	 * 执行的调度任务,实现具体逻辑
	 */
	public void executeTask() {
		log.info("t1 message is : {}",jRedisService.pop("message"));
	}
}
