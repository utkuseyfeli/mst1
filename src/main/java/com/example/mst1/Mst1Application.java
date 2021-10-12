package com.example.mst1;

import com.example.mst1.model.Student;
import com.example.mst1.repo.StudentRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Mst1Application {

	public static void main(String[] args) {
		SpringApplication.run(Mst1Application.class, args);
	}
}
