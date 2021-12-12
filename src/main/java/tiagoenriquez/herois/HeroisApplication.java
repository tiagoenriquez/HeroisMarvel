package tiagoenriquez.herois;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDynamoDBRepositories
public class HeroisApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeroisApplication.class, args);
	}

}
