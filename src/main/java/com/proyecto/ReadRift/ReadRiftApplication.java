package com.proyecto.ReadRift;

import com.proyecto.ReadRift.services.InitialDataCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReadRiftApplication implements CommandLineRunner {

	@Autowired
	private InitialDataCreationService initialDataCreationService;

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

	@Override
	public void run(String... args) throws Exception {
		initialDataCreationService.createInitialData();
	}
}
