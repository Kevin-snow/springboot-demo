package cn.kevin.rocketmq.springboot.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.StandardCharsets;

/**
 * create by kevin.
 *
 * @Date 2020/9/23
 */
@Slf4j
@Configuration
public class RocketMQConsumer {

    @Value("${rmq.group}")
    private String group;
    @Value("${rmq.nameSrv}")
    private String nameSrvAddr;
    @Value("${rmq.topic}")
    private String topic;

    @Bean
    public DefaultMQPushConsumer defaultMQPushConsumer() throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(group);
        consumer.setNamesrvAddr(nameSrvAddr);
        consumer.subscribe(topic,"*");
        consumer.registerMessageListener((MessageListenerConcurrently)(msg,context) -> {
            try {
                Message currentMsg = msg.get(0);
                String body = new String(currentMsg.getBody(), StandardCharsets.UTF_8);
                System.out.println(body);
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            } catch (Exception e) {
                return ConsumeConcurrentlyStatus.RECONSUME_LATER;
            }
        });
        consumer.start();
        return consumer;
    }

}
