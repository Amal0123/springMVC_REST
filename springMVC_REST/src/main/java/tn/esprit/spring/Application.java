/*
 * Copyright 2017 by Walid YAICH <walid.yaich@esprit.tn>
 * This is an Open Source Software
 * License: http://www.gnu.org/licenses/gpl.html GPL version 3
 */

package tn.esprit.spring;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Cette Classe sert a Lancer l'application web et alimenter la base de données.
 * Toute la configuration de cette application SpringBoot est dans le fichier application.properties.
 * 
 * @author Walid YAICH
 *
 */


//https://spring.io/guides/gs/accessing-data-jpa/
//https://spring.io/guides/gs/rest-service/

//By default, Spring Boot will enable JPA repository support and look in the package 
//(and its subpackages) where @SpringBootApplication is located. If your configuration 
//has JPA repository interface definitions located in a package not visible, you can point 
//out alternate packages using @EnableJpaRepositories and its type-safe 

//Normally you would add @EnableWebMvc for a Spring MVC app, 
//but Spring Boot adds it automatically when it sees spring-webmvc on the classpath.
@SpringBootApplication
@EnableTransactionManagement
public class Application {
	
	public static void main(String[] args) {
		
		//Lancer l'application
		SpringApplication.run(Application.class, args);
	}
	
}