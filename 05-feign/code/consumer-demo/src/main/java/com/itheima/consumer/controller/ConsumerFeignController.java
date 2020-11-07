package com.itheima.consumer.controller;

/**
 * @author XUAN
 * @date 2020/11/7 - 20:40
 * @references
 * @purpose
 * @errors
 */
import com.itheima.consumer.client.UserClient;
import com.itheima.consumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/consumerFeign")
public class ConsumerFeignController {

    @Autowired
    private UserClient userClient;

    // http://localhost:8080/consumerFeign/2
    @GetMapping("/{id}")
    public User queryById(@PathVariable Long id){
        return userClient.queryById(id);
    }
}