package org.ashok.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SimpleSpringbootWebappMonolithApplication {

	public static void main(String[] args) {
		ApplicationContext appContext = SpringApplication.run(SimpleSpringbootWebappMonolithApplication.class, args);
		
		System.out.println("BeansCount:" + appContext.getBeanDefinitionCount());
		for(String beanName: appContext.getBeanDefinitionNames())
		{
			System.out.println(beanName);
		}
	}

}
