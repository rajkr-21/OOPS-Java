package com.kiet.Student;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StudentApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(StudentApplication.class);

	// private static final ConfigurableApplicationContext applicationContext;
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(StudentApplication.class, args);

		System.out.println(applicationContext.getBeanDefinitionCount());

		String names[] = applicationContext.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("KIET Student Management System Started");
		logger.info("Loading Student Data...");
		logger.info("Student Management REST API is Ready");
	}
}
