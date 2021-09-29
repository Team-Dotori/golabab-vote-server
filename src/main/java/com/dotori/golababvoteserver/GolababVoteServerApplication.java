package com.dotori.golababvoteserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class GolababVoteServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GolababVoteServerApplication.class, args);
	}

}
