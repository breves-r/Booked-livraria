package edu.infnet.applivraria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BookedApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookedApplication.class, args);
	}

}
