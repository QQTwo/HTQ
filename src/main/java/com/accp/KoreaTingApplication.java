package com.accp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import com.accp.ws.SysMessageSocketHanlder;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KoreaTingApplication{

	public static void main(String[] args) {
		//SpringApplication.run(KoreaTingApplication.class, args);
		SpringApplication springApplication = new SpringApplication(KoreaTingApplication.class);        
		ConfigurableApplicationContext configurableApplicationContext = springApplication.run(args);        
		SysMessageSocketHanlder.ac=configurableApplicationContext;//非常重要
	

	}
}

