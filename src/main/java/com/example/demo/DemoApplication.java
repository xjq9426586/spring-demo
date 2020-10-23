package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.aop.Speakable;

@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer{
	@Autowired
	private Speakable personSpring;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
//	 @Bean
//	 public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//	 return args -> {
//	 // spring aop
//	 System.out.println("******** spring aop ******** ");
//	 personSpring.sayHi();
//	 personSpring.sayBye();
//	 System.exit(0);
//	 };
//	 }
	
//	  @Override
//	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//	        return application.sources(DemoApplication.class);
//	    }
}
