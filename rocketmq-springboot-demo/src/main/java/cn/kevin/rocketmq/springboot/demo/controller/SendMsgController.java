package cn.kevin.rocketmq.springboot.demo.controller;

import cn.kevin.rocketmq.springboot.demo.service.SendMessageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * create by kevin.
 *
 * @Date 2020/9/21
 */
@RestController
@RequestMapping("/api/msg")
public class SendMsgController {

    @Resource
    SendMessageService messageService;

    @PostMapping("/")
    public void SendMsg(){
        messageService.sendMessage("测试发送消息");
    }

}
