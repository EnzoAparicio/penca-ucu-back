package uy.edu.ucu.pencaucu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "uy.edu.ucu.pencaucu")
@EnableJpaRepositories(basePackages = "uy.edu.ucu.pencaucu.repo")
public class PencaucuApplication {

	public static void main(String[] args) {
		SpringApplication.run(PencaucuApplication.class, args);
	}

}
