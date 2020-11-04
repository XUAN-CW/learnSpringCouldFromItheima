package com.itheima.controller;

import com.itheima.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

/**
 * @author XUAN
 * @date 2020/11/4 - 1:00
 * @references
 * @purpose
 * @errors
 */
@RestController
public class Controller {
    @Autowired
    private User user;

    // http://localhost:8081/user
    @GetMapping("user")
    public User helloMultiYml() {
        return user;
    }

}
