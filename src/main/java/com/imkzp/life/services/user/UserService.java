package com.imkzp.life.services.user;

import com.imkzp.life.bean.user.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void register(User user);
//    boolean login(String phone,String pwd);
}
