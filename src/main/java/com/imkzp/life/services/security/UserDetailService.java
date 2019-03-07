package com.imkzp.life.services.security;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailService {
    public UserDetails loadUserByUsername(String phone) ;

}
