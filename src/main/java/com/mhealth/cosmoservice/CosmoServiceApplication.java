package main.java.com.mhealth.cosmoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CosmoServiceApplication {

	public static void main(String[] args) {
		InMemoryDatabase.InitInMemoryDatabase();
		SpringApplication.run(CosmoServiceApplication.class, args);
	}

}
