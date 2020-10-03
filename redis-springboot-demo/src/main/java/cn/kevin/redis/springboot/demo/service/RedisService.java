package cn.kevin.redis.springboot.demo.service;

import cn.kevin.redis.springboot.demo.bean.User;
import com.alibaba.fastjson.JSON;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * create by kevin.
 *
 * @Date 2020/10/3
 */
@Service
public class RedisService {

    @Resource
    StringRedisTemplate stringRedisTemplate;

    public void setUserInfoToRedis(User user){
        stringRedisTemplate.opsForValue().set("user", JSON.toJSONString(user));
    }

    public String getUserByRedis(){
        return stringRedisTemplate.opsForValue().get("user");
    }
}
