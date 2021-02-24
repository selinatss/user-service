package com.freetimeactivity.userservice.controller;

import com.freetimeactivity.userservice.VO.ResponseTemplateVO;
import com.freetimeactivity.userservice.entity.User;
import com.freetimeactivity.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("Inside saveUser method of save UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){

        return userService.getUserWithDepartment(userId);
    }
}
