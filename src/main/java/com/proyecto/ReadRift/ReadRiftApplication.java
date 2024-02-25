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
		System.out.println("Hasieratzen/Starteando...");
		System.out.println("*******************************************************************************************************************************************************************************************");
		System.out.println("*                                                                                                                                                      			                          *");
		System.out.println("*                                                                                                                                                      			       			          *");
		System.out.println("*                                                                                                                                                                           		      *");
		System.out.println("*                                                                                   ¡BIENVENIDO!                                                                            		      *");
		System.out.println("*                                                                                    A READRIFT                                                                         		          *");
		System.out.println("*                                                                                                                                                                           		      *");
		System.out.println("*                                                                                                                                                      			            		      *");
		System.out.println("*                                                                                                                                                                          			      *");
		System.out.println("*******************************************************************************************************************************************************************************************");

		System.out.println("Abra Postman en http://localhost:8080/api/books para ver las BOOKS.");

	}


	@Bean
	public CommandLineRunner init(InitialDataCreationService service) {
		return args -> {
			service.createDefaultAdminUser();
			service.createFakeBooks(100);
			//service.createFakeExchanges(10);
		};}
}
