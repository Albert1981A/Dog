package com.AlbertAbuav.Dog.services;

import org.springframework.stereotype.Service;

@Service
public class SmsService {

    public void sendMessage(String message) {
        System.out.println("SPAM... SPAM... SPAM... " + message);
    }
}
