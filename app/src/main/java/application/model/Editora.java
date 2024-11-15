package application.model;

import jakarta.persistence.Column; // Importa a anotação Column, que define as colunas na tabela do banco de dados
import jakarta.persistence.Entity; // Importa a anotação Entity, que marca a classe como uma entidade JPA
import jakarta.persistence.GeneratedValue; // Importa a anotação GeneratedValue, usada para definir a geração automática de valores para o ID
import jakarta.persistence.GenerationType; // Importa a anotação GenerationType, usada para especificar a estratégia de geração do ID
import jakarta.persistence.Id; // Importa a anotação Id, usada para marcar o campo como chave primária
import jakarta.persistence.Table; // Importa a anotação Table, que define o nome da tabela no banco de dados
import lombok.Getter; // Importa a anotação Getter do Lombok, para gerar automaticamente os métodos getters
import lombok.Setter; // Importa a anotação Setter do Lombok, para gerar automaticamente os métodos setters

@Entity // Marca a classe como uma entidade JPA, que será mapeada para uma tabela no banco de dados
@Table(name = "editoras") // Define o nome da tabela no banco de dados como "editoras"
@Getter // Gera automaticamente os métodos getters para os campos da classe
@Setter // Gera automaticamente os métodos setters para os campos da classe
public class Editora {

    @Id // Marca o campo 'id' como a chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define a geração automática do valor do ID utilizando a estratégia de identidade
    private long id; // Atributo 'id' que será a chave primária da editora

    @Column(nullable = false) // Marca o campo 'nome' como uma coluna obrigatória na tabela
    private String nome; // Atributo 'nome' da editora

    @Column(nullable = false) // Marca o campo 'cidade' como uma coluna obrigatória na tabela
    private String cidade; // Atributo 'cidade' da editora
}
