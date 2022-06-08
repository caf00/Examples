package com.aleDev.democriteriaAPI;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@AllArgsConstructor
public class DemoCriteriaApiApplication implements CommandLineRunner {

	private final BookJpaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(DemoCriteriaApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.getBooksByAuthorNameAndTitle("Alejandro", "Mat")
				.forEach(System.out::println);
		repository.getBooksByAuthorNameAndTitle(null, "Prog")
				.forEach(System.out::println);
	}
}
