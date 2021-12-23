package br.com.mhenrique.spring.boot.estudo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class SpringBootEstudoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEstudoApplication.class, args);
	}

}
