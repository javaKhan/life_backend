package com.imkzp.life.services.user.impl;

import com.imkzp.life.bean.security.JwtUser;
import com.imkzp.life.bean.user.User;
import com.imkzp.life.dao.user.UserDao;
import com.imkzp.life.services.user.UserService;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.implementation.bytecode.Throw;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Slf4j
public class UserServiceImpl implements UserService {
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        logger.info("用户名:"+phone);
        User u = userDao.findByPhone(phone);
        Optional o = Optional.ofNullable(u);
        if (!o.isPresent()){
            throw  new UsernameNotFoundException("没有该用户");
        }
        JwtUser jwtUser = new JwtUser(u.getPhone(),u.getPwd());
        return jwtUser;
    }

    @Override
    public void register(User user) {
        userDao.save(user);
    }
}
