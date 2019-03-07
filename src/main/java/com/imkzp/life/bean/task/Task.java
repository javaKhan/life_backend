package com.imkzp.life.bean.task;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Task {
    @Id
    private String tid;
    private String taskName;
    private Date createTime;
    private Date startDate;
    private Date endDate;
    private int status;
    private String describe;

}
