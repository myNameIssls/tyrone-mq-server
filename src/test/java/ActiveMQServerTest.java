import javax.annotation.Resource;
import javax.jms.Destination;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.tyrone.mq.service.ActiveMQServer;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext-*.xml")
public class ActiveMQServerTest {
	
	@Resource private ActiveMQServer activeMQServer;
	
	@Resource @Qualifier("firstQueueID") 
	private Destination firstDestination;
	
//	@Resource @Qualifier("firstQueueID2") 
//	private Destination firstDestination2;
	
	/**
	 * MQ发送消息测试
	 */
	@Test
	public void sendMessageTest(){
		int result = activeMQServer.sendMessage(firstDestination, "Hello MQ!!!Spring!!!");
		System.out.println("结果是：" + result);
	}
	
	/**
	 * MQ接收消息测试
	 */
	@Test
	public void receiveMessageTest(){
		System.out.println();
	}
	
}
