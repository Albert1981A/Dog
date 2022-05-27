package com.AlbertAbuav.Dog.beans;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Data
public class MyComposed {

    @Autowired
    private MySingleton mySingleton;
    @Autowired
    private MySingleton single6;
    @Autowired
    private MyPrototype myPrototype;
    @Autowired
    private MyPrototype proto6;


    // it is not recommended to write this way !!!
//    @Autowired
//    @Qualifier("mySingleton")
//    private MySingleton s1;
//    @Autowired
//    @Qualifier("single6")
//    private MySingleton s2;
//    @Autowired
//    @Qualifier("myPrototype")
//    private MyPrototype p1;
//    @Autowired
//    @Qualifier("proto6")
//    private MyPrototype p2;

}
