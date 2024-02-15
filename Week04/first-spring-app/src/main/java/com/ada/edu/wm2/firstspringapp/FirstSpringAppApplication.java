package com.ada.edu.wm2.firstspringapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class FirstSpringAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringAppApplication.class, args);
	}

	@GetMapping("/")
	public String sayHello() {
		return "Hi!";
	}

	@GetMapping("/students")
	public List<Person> listStudents() {
		return List.of(
				new Person("Farid", "Mammadli"),
				new Person("Aliya", "Huseynova"),
				new Person("Gabil", "Gurbanov")
		);
	}

	class Person {
		private String firstName;
		private String lastName;

		public Person(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public String getFirstName() {
			return firstName;
		}

		public String getLastName() {
			return lastName;
		}
	}
}
