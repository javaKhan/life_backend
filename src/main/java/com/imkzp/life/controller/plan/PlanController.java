package com.imkzp.life.controller.plan;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plan")
public class PlanController {
    @RequestMapping("/add")
    public Object addPlan(){
        return "addPlan";
    }
}
