package com.AlbertAbuav.Dog;

import com.AlbertAbuav.Dog.beans.MyComposed;
import com.AlbertAbuav.Dog.beans.MyPrototype;
import com.AlbertAbuav.Dog.beans.MySingleton;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication // @Configuration + @ComponentScan(basePackages = "com.AlbertAbuav.Dog")
@RestController
@RequestMapping("add")
@EnableAspectJAutoProxy
public class DogApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DogApplication.class, args);

		MyPrototype p1 = ctx.getBean("myPrototype", MyPrototype.class);
		System.out.println(p1.getId());
		MyPrototype p2 = ctx.getBean("proto6", MyPrototype.class);
		System.out.println(p2.getId());

		MySingleton s1 = ctx.getBean("mySingleton", MySingleton.class);
		System.out.println(s1.getId());
		MySingleton s2 = ctx.getBean("single6", MySingleton.class);
		System.out.println(s2.getId());

		MyComposed c1 = ctx.getBean(MyComposed.class);
		System.out.println(c1);

		System.out.println("I am using the method getId of MyPrototype: " + p1.getId());

	}

	@Bean // creates new bean as MySingleton named single6
	@Lazy // automatically create the new bean as eagerly load so we need to put the annotation "@Lazy"
	public MySingleton single6() {
		MySingleton mySingleton = new MySingleton();
		mySingleton.setId(6);
		return mySingleton;
	}

	@Bean // automatically create a singleton all though the main bean is a prototype
	@Scope(BeanDefinition.SCOPE_PROTOTYPE) // we need to define the Scope again
	public MyPrototype proto6() {
		MyPrototype myPrototype = new MyPrototype();
		myPrototype.setId(6);
		return myPrototype;
	}

	@GetMapping
	public int sum(@RequestParam(value = "num1") int a, @RequestParam(value = "num2") int b) {
		return a+b;
	}
}
