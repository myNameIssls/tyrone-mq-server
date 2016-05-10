package cn.tyrone.mq.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * MQ消息监听器
 * @author slsadmin
 *
 */
public class ActiveMQListener implements MessageListener {

	public void onMessage(Message message) {
		TextMessage textMessage = (TextMessage) message;
		try {
			/*
			 * 在此接收到MQ消息后进行业务逻辑处理
			 */
			System.out.println("接收消息" + textMessage.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
