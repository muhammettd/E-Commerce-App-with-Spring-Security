package com.app.eticaret;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.app.eticaret"})
@SpringBootApplication
public class EticaretApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EticaretApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}





}
