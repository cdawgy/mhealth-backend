package main.java.com.mhealth.cosmoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CosmoServiceApplication {

	public static void main(String[] args) {
		InMemoryDatabase.InitInMemoryDatabase();
		SpringApplication.run(CosmoServiceApplication.class, args);
	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**").allowCredentials(true).allowedOriginPatterns("*").allowedMethods("*");
//			}
//		};
//	}

}
