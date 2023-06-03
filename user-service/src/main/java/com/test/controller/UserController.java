package com.test.controller;

import com.test.entity.User;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.SQLOutput;

@RestController
@RefreshScope
public class UserController {

    @Resource
    UserService service;

    @Value("${test:德丽莎我的德丽莎}")
    String test;

    @RequestMapping("/user/{uid}")
    public User findUserById(@PathVariable("uid") int uid){
        System.out.println("调用用户服务");
        System.out.println(test);
        return service.getUserById(uid);
    }
}
