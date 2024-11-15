package application.repository;

import org.springframework.data.repository.CrudRepository; // Importa a interface CrudRepository, que fornece métodos CRUD básicos para trabalhar com entidades
import application.model.Livro; // Importa a classe Livro, que é a entidade que o repositório vai manipular

// Interface LivroRepository, que estende CrudRepository para fornecer operações CRUD para a entidade Livro
public interface LivroRepository extends CrudRepository<Livro, Long> {
    // Não é necessário adicionar nenhum método aqui, pois CrudRepository já fornece implementações para os métodos básicos (save, findById, findAll, delete, etc.)
}
