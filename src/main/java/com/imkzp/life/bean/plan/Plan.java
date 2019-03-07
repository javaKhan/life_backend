package com.imkzp.life.bean.plan;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class Plan {
    @Id
    private String pid;
    private String title;
    private String describ;
    private Date startDate;
    private Date endDate;
}
