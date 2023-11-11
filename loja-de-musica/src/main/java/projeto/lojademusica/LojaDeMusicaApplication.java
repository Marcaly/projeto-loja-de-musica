package projeto.lojademusica;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Loja de musica API",version = "1.0",description = "Api de uma loja de musica"))
public class LojaDeMusicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LojaDeMusicaApplication.class, args);
	}

}
