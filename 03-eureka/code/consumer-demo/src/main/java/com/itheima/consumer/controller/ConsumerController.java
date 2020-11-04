package com.itheima.consumer.controller;

import com.itheima.consumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    // http://localhost:8080/consumer/8
    @GetMapping("/{id}")
    public User queryById(@PathVariable Long id){
        String url = "http://localhost:9091/user/" + id;
        return restTemplate.getForObject(url, User.class);
    }

}