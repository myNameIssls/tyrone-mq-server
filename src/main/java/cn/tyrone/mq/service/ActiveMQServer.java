package cn.tyrone.mq.service;


import javax.jms.Destination;

public interface ActiveMQServer {
	
	/**
	 * MQ 发送消息接口
	 * @param destination
	 * @param message
	 * @return 【0:发送消息成功 1:发送消息异常】
	 */
	public int sendMessage(Destination destination, final String message);
	
}
