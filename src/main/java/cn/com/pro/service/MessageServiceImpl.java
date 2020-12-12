package cn.com.pro.service;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.pro.service.JRedisService;
import cn.com.pro.service.MessageService;

@Component
public class MessageServiceImpl implements MessageService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private JRedisService jRedisService;
	
	private String topic = "message";
	
	@PostConstruct
	public void startCousumer() {
		new Thread(new Runnable() {
			public void run() {
				getMessage(topic);
			}
		}).start();
	}

	@Override
	public String getMessage(String topic) {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Object o = jRedisService.pop(topic);
			if(null != o && !"null".equals(o)) {
				System.out.println("recieve msg: " + o);// 同步输出
				log.info("====  ， 获取消息：  {}, {}, {}, {}", o, o, o , o);
				log.info(""); // 想记录一下某一个内容
				log.debug(""); // 想了解里边详细的内容
				log.warn(""); // 提醒的日志
				log.error(""); // 完全有问题
			}
		}
	}

}
