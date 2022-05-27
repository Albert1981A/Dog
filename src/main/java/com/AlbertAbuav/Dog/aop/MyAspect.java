package com.AlbertAbuav.Dog.aop;

import com.AlbertAbuav.Dog.services.SmsService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

    @Autowired
    private SmsService smsService;

    @After("@annotation(SendSms)")
    public void doTheThing(JoinPoint jp) {
        String method = jp.getSignature().getName();
        Object obj = jp.getTarget();
        smsService.sendMessage("Ku... Ku... Riku...! "+ method + " " + obj.toString());
    }


}
