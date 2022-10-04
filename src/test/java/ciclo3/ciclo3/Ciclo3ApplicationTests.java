package ciclo3.ciclo3;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;

@EntityScan(basePackages = {"co.usa.ciclo3.ciclo3.entidades"})
@SpringBootTest
class Ciclo3ApplicationTests {

	public static void main(String[] args){
		SpringApplication.run(Ciclo3Application.class);
	}

}
