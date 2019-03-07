package com.imkzp.life.bean.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class User {
    @Id
    private String uid;
    private String phone;
    private String pwd;
    private String nickName;
}
