package com.example.demovaadinreport;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.SystemUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import com.example.demovaadinreport.model.Employee;
import com.example.demovaadinreport.repo.EmployeeRepo;
import com.github.javafaker.Faker;

@SpringBootApplication
public class DemoVaadinReportApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoVaadinReportApplication.class, args);
	}


	@Bean
	public CommandLineRunner run(EmployeeRepo repo) {
		return args -> {
			final Faker faker = new Faker();
			var data1 = Employee.builder().id(1).name(faker.name().fullName())
					.address(faker.address().fullAddress()).build();
			var data2 = Employee.builder().id(2).name(faker.name().fullName())
					.address(faker.address().fullAddress()).build();
			repo.save(data1);
			repo.save(data2);
		};
	}


	@EventListener({ApplicationReadyEvent.class})
	void applicationReadyEvent() {
		System.out.println("Application started ... launching browser now");
		browse("http://localhost:8080/pdf");
	}

	public static void browse(String url) {
		if (!SystemUtils.IS_OS_WINDOWS)
			return;
		try {
			Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
