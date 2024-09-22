//define a entidade Genero, que será mapeada para a tabela generos no banco de dados.
package application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity //Indica que essa classe é uma entidade JPA e será mapeada para uma tabela no banco de dados.
@Table(name = "generos") //Especifica que a entidade será mapeada para a tabela chamada generos.
public class Genero {
    @Id //Indica que o campo id é a chave primária da entidade.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Indica que o valor do id será gerado automaticamente pelo banco de dados (usando a estratégia de auto-incremento).
    private long id; //Armazena o ID do gênero.
    private String nome; //Armazena o nome do gênero.

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }
}