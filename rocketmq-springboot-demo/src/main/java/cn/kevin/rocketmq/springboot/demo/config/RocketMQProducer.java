package cn.kevin.rocketmq.springboot.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * create by kevin.
 *
 * @Date 2020/9/18
 */
@Slf4j
@Configuration
public class RocketMQProducer {

    @Value("${rmq.nameSrv}")
    private String nameSrvAddr;
    @Value("${rmq.topic}")
    private String topic;
    @Value("${rmq.group}")
    private String group;

    @Bean
    public DefaultMQProducer getDefaultMQProducer(){
        DefaultMQProducer producer = new DefaultMQProducer(group);
        producer.setNamesrvAddr(nameSrvAddr);
        producer.setInstanceName(group);
        try {
            producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
            log.info("启动rocketMQ出现异常",e);
        }
        return producer;
    }

}
