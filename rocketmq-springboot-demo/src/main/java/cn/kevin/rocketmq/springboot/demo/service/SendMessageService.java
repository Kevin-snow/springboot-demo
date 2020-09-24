package cn.kevin.rocketmq.springboot.demo.service;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * create by kevin.
 *
 * @Date 2020/9/18
 */
@Service
public class SendMessageService {

    @Resource
    private DefaultMQProducer producer;

    public void sendMessage(String msg){
        Message message = new Message("test-topic","tage",msg.getBytes());
        try {
            producer.send(message);
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
