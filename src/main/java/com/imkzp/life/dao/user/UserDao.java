package com.imkzp.life.dao.user;

import com.imkzp.life.bean.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,String> {
    User findByPhone(String phone);
}
