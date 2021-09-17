package com.alejandro.paginationexample;

import com.alejandro.paginationexample.entity.Animal;
import com.alejandro.paginationexample.service.contract.SaveAnimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaginationExampleApplication implements CommandLineRunner {

	@Autowired
	private SaveAnimal saveAnimal;

	public static void main(String[] args) {
		SpringApplication.run(PaginationExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i < 200; i++) {
			this.saveAnimal.execute(new Animal("Animal"+i));
		}
	}
}
