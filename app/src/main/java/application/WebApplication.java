package application;
// Define o pacote onde a classe está localizada.

import org.springframework.boot.SpringApplication;
// Importa a classe responsável por inicializar a aplicação Spring Boot.

import org.springframework.boot.autoconfigure.SpringBootApplication;
// Importa a anotação que configura a aplicação Spring Boot, ativando o escaneamento de componentes, a configuração automática e o suporte ao Spring Boot.

@SpringBootApplication
// Marca esta classe como a classe principal de uma aplicação Spring Boot. 
// Combina as anotações @Configuration, @EnableAutoConfiguration e @ComponentScan.

public class WebApplication {
    // Define a classe principal da aplicação.

    public static void main(String[] args) {
        // Método principal que é o ponto de entrada da aplicação.

        SpringApplication.run(WebApplication.class, args);
        // Inicializa a aplicação Spring Boot, configurando e iniciando o servidor embutido.
    }
}
