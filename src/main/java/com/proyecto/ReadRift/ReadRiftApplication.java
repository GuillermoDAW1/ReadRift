package com.proyecto.ReadRift;

import com.proyecto.ReadRift.services.InitialDataCreationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReadRiftApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReadRiftApplication.class, args);
	}
	@Bean
	public CommandLineRunner init(InitialDataCreationService service) {
		return args -> {
			service.createDefaultAdminUser();
			//service.createFakeCategories(10);
			//service.createFakeProducts(100);
		};}
}
