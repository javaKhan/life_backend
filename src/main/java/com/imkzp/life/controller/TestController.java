package com.imkzp.life.controller;

import com.imkzp.life.bean.user.User;
import com.imkzp.life.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class TestController {
    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    public Object test(){
        BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();

        User user = new User();
        user.setNickName("漫漫1");
        user.setPhone("13552407123");
        user.setPwd(encoder.encode("123456"));
        user.setUid(UUID.randomUUID().toString().replace("-",""));
        userService.register(user);
//
        Map map = new HashMap();
        map.put("msg","测试成功");
        map.put("time", LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        return map;
    }
}
