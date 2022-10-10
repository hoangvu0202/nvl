package com.computer.nlv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.computer.nlv.repositories.CountriesRepository;

@SpringBootApplication
public class NlvApplication extends SpringBootServletInitializer {

	@Autowired
	CountriesRepository s;
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(NlvApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(NlvApplication.class, args); 
	}
	
	/*
	 * @Bean public CommandLineRunner demo(CountryService repository) { return
	 * (args) -> { for (CountriesEntity en : s.findAll()) {
	 * System.out.println(en.getName()); } for (Countries customer :
	 * repository.countriesList()) { System.out.println(customer.getPopulation()); }
	 * }; }
	 */

}
