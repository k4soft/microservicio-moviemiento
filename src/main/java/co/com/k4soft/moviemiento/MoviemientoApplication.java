package co.com.k4soft.moviemiento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MoviemientoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviemientoApplication.class, args);
	}

}
