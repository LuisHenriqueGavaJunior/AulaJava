//define um repositório para a entidade Genero usando Spring Data JPA.
//Essa interface permite que realizar operações básicas no banco de dados para a entidade Genero sem precisar 
//implementar os métodos manualmente, aproveitando as funcionalidades do Spring Data JPA.

package application.repository;

import org.springframework.data.repository.CrudRepository;
import application.model.Genero;

public interface GeneroRepository extends CrudRepository<Genero, Long>{

    
}

//GeneroRepository estende CrudRepository, que fornece métodos básicos para operações de CRUD (Criar, Ler, Atualizar, Deletar) na entidade Genero
//Genero: A classe da entidade que será gerenciada pelo repositório.
//Long: O tipo da chave primária da entidade Genero.