package com.itheima.consumer.controller;

import com.itheima.consumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;
    // http://localhost:8080/consumer/8
    @GetMapping("/{id}")
    public User queryById(@PathVariable Long id){
        String url = "http://localhost:9091/user/" + id;
        return restTemplate.getForObject(url, User.class);
    }

    // http://localhost:8080/consumer/queryByIdEureka/8
    @GetMapping("/queryByIdEureka/{id}")
    public User queryByIdEureka(@PathVariable Long id) {
        String url = "http://localhost:9091/user/" + id;
        //获取eureka中注册的user-service实例列表
        List<ServiceInstance> serviceInstanceList =
                discoveryClient.getInstances("user-service");
        ServiceInstance serviceInstance = serviceInstanceList.get(0);
        url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort()
                + "/user/" + id;
        return restTemplate.getForObject(url, User.class);
    }


    // http://localhost:8080/consumer/queryByIdRibbon/8
    @GetMapping("/queryByIdRibbon/{id}")
    public User queryByIdRibbon(@PathVariable("id") Long id){
        String url = "http://user-service/user/" + id;
        User user = restTemplate.getForObject(url, User.class);
        return user;
    }
}
