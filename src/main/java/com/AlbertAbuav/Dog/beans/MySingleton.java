package com.AlbertAbuav.Dog.beans;

import lombok.Data;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Lazy
@Data
public class MySingleton {
    //private int s = 20;

    private int id = (int)(Math.random()*101);

    public MySingleton() {
        System.out.println("CTOR - in Action of: " + this.getClass().getSimpleName() + "....!");
    }

    @PostConstruct
    public void hi(){
        System.out.println("Hi.....I'm Here....!");
    };

    @PreDestroy
    public void bye(){
        System.out.println("Good bye....!");
    };

}
