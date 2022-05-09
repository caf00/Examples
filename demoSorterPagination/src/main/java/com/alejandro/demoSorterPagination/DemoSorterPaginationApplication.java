package com.alejandro.demoSorterPagination;

import com.alejandro.demoSorterPagination.web.PageableBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoSorterPaginationApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSorterPaginationApplication.class, args);
	}

	@Bean
	public PageableBuilder pageableBuilder() {
		return new PageableBuilder();
	}

}
