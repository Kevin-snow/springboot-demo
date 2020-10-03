package cn.kevin.redis.springboot.demo.bean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * create by kevin.
 *
 * @Date 2020/10/3
 */
@Slf4j
@Data
public class User implements Serializable {

    private String id;
    private String name;
    private int age;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
