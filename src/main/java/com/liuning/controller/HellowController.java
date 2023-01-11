package com.liuning.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.liuning.mapper.UserMapper;
import com.liuning.pojo.Jdbclianjie;
import com.liuning.pojo.User;
import com.liuning.service.impl.UserMapperIpml;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableConfigurationProperties(Jdbclianjie.class)
public class HellowController {
    @Autowired
    private User user;
    @Autowired
    private Jdbclianjie jdbclianjie;
    @Autowired
    private UserMapperIpml userMapperIpml;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/hellow")
    public String hello(){
        System.out.println(jdbclianjie);
        System.out.println(user);
        return "hello springboot";
    }
    @RequestMapping("/getAll")
    public List<User> getAll(){

        List<User> user = (List<User>) redisTemplate.opsForValue().get("user");
        if (user==null){
            user = userMapperIpml.selectAll();
            redisTemplate.opsForValue().set("user",user);
            System.out.println("查询数据库");
        }else {
            System.out.println("查询redis");
        }
        return user;
    }
    @RequestMapping("/selectById")
    public User selectById(@RequestParam("id") Integer id){
        User user = userMapperIpml.selectById(id);
        return user;
    }

    @PostMapping("/insert")
    public int insert(User user){
        Integer insert = userMapperIpml.insert(user);
        return insert;
    }

    @PostMapping("/update")
    public int update(User user){
        User user1 = new User();
        user1.setUserName(user.getUserName());
        user1.setPassWord(user.getPassWord());
        Integer insert = userMapperIpml.update(user);
        return insert;
    }
}
