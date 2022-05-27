package com.AlbertAbuav.Dog.beans;

import com.AlbertAbuav.Dog.aop.SendSms;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
//@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Scope("prototype")
@Data
public class MyPrototype {
    private int id = (int)(Math.random()*101);

    public MyPrototype() {
        System.out.println("CTOR - in Action of: " + this.getClass().getSimpleName());
    }

    @PostConstruct
    public void hi(){
        System.out.println("Hi.....I'm Here....!");
    };

    @PreDestroy // this method wont work because spring want us to use singletons
    public void bye(){
        System.out.println("Good bye....!");
    };

    @SendSms
    public int getId() {
        return id;
    }
}
