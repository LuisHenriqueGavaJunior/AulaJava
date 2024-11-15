package application.model;

import jakarta.persistence.Entity; // Importa a anotação Entity, que marca a classe como uma entidade JPA
import jakarta.persistence.Id; // Importa a anotação Id, usada para marcar o campo como chave primária
import jakarta.persistence.Table; // Importa a anotação Table, que define o nome da tabela no banco de dados
import lombok.Getter; // Importa a anotação Getter do Lombok, para gerar automaticamente os métodos getters
import lombok.Setter; // Importa a anotação Setter do Lombok, para gerar automaticamente os métodos setters
import jakarta.persistence.GeneratedValue; // Importa a anotação GeneratedValue, usada para definir a geração automática de valores para o ID
import jakarta.persistence.GenerationType; // Importa a anotação GenerationType, usada para especificar a estratégia de geração do ID
import jakarta.persistence.JoinColumn; // Importa a anotação JoinColumn, usada para definir a coluna de junção entre as tabelas
import jakarta.persistence.ManyToOne; // Importa a anotação ManyToOne, que define o relacionamento de muitos para um
import jakarta.persistence.ManyToMany; // Importa a anotação ManyToMany, que define o relacionamento de muitos para muitos
import java.util.Set; // Importa a classe Set, usada para armazenar coleções de objetos

@Entity // Marca a classe como uma entidade JPA
@Table(name = "livros") // Define o nome da tabela no banco de dados como "livros"
@Getter // Gera automaticamente os métodos getters para os campos da classe
@Setter // Gera automaticamente os métodos setters para os campos da classe
public class Livro {

    @Id // Marca o campo 'id' como a chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define a geração automática do valor do ID utilizando a estratégia de identidade
    private long id; // Atributo 'id' que será a chave primária do livro

    private String titulo; // Atributo 'titulo' do livro

    @ManyToOne // Define um relacionamento de muitos para um com a entidade 'Genero'
    @JoinColumn(name = "id_genero") // Define a coluna de junção entre a tabela 'livros' e 'genero'
    private Genero genero; // Atributo 'genero', que se refere ao gênero do livro

    @ManyToOne // Define um relacionamento de muitos para um com a entidade 'Editora'
    @JoinColumn(name = "id_editora") // Define a coluna de junção entre a tabela 'livros' e 'editora'
    private Editora editora; // Atributo 'editora', que se refere à editora do livro

    @ManyToMany // Define um relacionamento de muitos para muitos com a entidade 'Autor'
    @JoinTable(
        name = "livros_possuem_autores", // Define o nome da tabela de junção
        joinColumns = @JoinColumn(name = "id_livro"), // Define a coluna de junção na tabela 'livros'
        inverseJoinColumns = @JoinColumn(name = "id_autor") // Define a coluna de junção na tabela 'autor'
    )
    private Set<Autor> autores; // Atributo 'autores', que representa os autores do livro (coleção de autores)
}
