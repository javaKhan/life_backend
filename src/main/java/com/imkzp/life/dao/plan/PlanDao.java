package com.imkzp.life.dao.plan;

import com.imkzp.life.bean.plan.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanDao extends JpaRepository<Plan,String> {

}
