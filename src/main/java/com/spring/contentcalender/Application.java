package com.spring.contentcalender;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.spring.contentcalender.model.Content;
import com.spring.contentcalender.model.Status;
import com.spring.contentcalender.model.Type;
import com.spring.contentcalender.repository.ContentRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
//		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
//		RestTemplate resttemplate = (RestTemplate) context.getBean("restTemplate");
		SpringApplication.run(Application.class, args);
//		System.out.println(resttemplate);
		
	}
	@Bean
	CommandLineRunner commandlineRunner(ContentRepository repository) {
		return args-> {
			Content c = new Content(null,
	                "Hello ChatGpt",
	                "All abobut ChatGPT",
	                Status.IDEA,
	                Type.VIDEO,
	                LocalDateTime.now(),
	                null,
	                "");
			repository.save(c);
		};
	}
}
