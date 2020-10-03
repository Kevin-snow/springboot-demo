package cn.kevin.redis.springboot.demo.controller;

import cn.kevin.redis.springboot.demo.bean.User;
import cn.kevin.redis.springboot.demo.service.RedisService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * create by kevin.
 *
 * @Date 2020/10/3
 */
@RestController
@RequestMapping("/api")
public class RedisController {

    @Resource
    RedisService redisService;

    @GetMapping("/user")
    public JSONObject user(){
        User user = new User();
        user.setAge(18);
        user.setId(UUID.randomUUID().toString());
        user.setName("张三");
        redisService.setUserInfoToRedis(user);

        String userStr = redisService.getUserByRedis();
        return (JSONObject) JSONObject.parse(userStr);
    }

}
