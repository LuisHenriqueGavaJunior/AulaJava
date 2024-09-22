//O arquivo WebApplication.java é o ponto de entrada da sua aplicação Spring Boot. Aqui está o que ele faz de forma simples:
package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //Essa anotação combina várias funcionalidades do Spring e marca essa classe como a principal para rodar a aplicação Spring Boot.
public class WebApplication { // O método principal (main) usa SpringApplication.run() para iniciar a aplicação.
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}