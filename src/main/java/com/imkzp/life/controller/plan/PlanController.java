package com.imkzp.life.controller.plan;

import com.imkzp.life.bean.plan.Plan;
import com.imkzp.life.services.plan.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plan")
public class PlanController {
    @Autowired
    private PlanService planService;

    @RequestMapping("/add")
    public Object addPlan(Plan plan){
        planService.addPlan(plan);
        return "addPlan";
    }

    @RequestMapping("/del")
    public Object delPlan(){
        return null;
    }

    @RequestMapping("/edit")
    public Object editPlan(){
        return null;
    }

    public Object listPlan(){
        return null;
    }
}
