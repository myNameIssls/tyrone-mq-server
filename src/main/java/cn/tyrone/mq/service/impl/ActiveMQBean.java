package cn.tyrone.mq.service.impl;


import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.log4j.Logger;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import cn.tyrone.mq.service.ActiveMQServer;

@Component
public class ActiveMQBean implements ActiveMQServer {

	Logger logger = Logger.getLogger(this.getClass());
	
	@Resource private JmsTemplate jmsTemplate;
	
	/**
	 * MQ 发送消息接口
	 * @param destination
	 * @param message
	 * @return 【0:发送消息成功 1:发送消息异常】
	 */
	public int sendMessage(Destination destination, final String message) {
		
		int result = 0;
		try {
			jmsTemplate.send(destination, new MessageCreator() {
				public Message createMessage(Session session) throws JMSException {
					return session.createTextMessage(message);
				}
			});
			logger.info("MQ发送消息成功：" + message);
		} catch (Exception e) {
			logger.error("MQ发送消息异常。", e);
			result = 1;
		}
		return result;
	}

}
