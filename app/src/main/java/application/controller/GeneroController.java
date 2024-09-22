//um controlador Spring que gerencia as requisições relacionadas à entidade Genero. Toda requisição passa por aqui. Ele é quem faz o show
package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.Genero;
import application.repository.GeneroRepository;

@Controller //Marca a classe como um controlador Spring.
@RequestMapping("/generos") // Define a URL base para as rotas deste controlador, que é /generos.
public class GeneroController {
    @Autowired //Injeta uma instância de GeneroRepository, permitindo acesso às operações de banco de dados.
    private GeneroRepository generoRepo;
    
    @RequestMapping("/insert") 
    public String insert() {
        return "/generos/insert";
    } //Retorna a página do formulário de inserção (/generos/insert).


    @RequestMapping(value = "/insert", method = RequestMethod.POST) //Trata a requisição POST do formulário.
    public String insert(@RequestParam("nome") String nome) {
        //Cria um novo objeto Genero, define seu nome e o salva no banco de dados usando generoRepo.save(genero).
        Genero genero = new Genero(); 
        genero.setNome(nome);

        generoRepo.save(genero);

        return "redirect:/generos/list"; //Redireciona para a lista de gêneros após a inserção.
    }

    @RequestMapping("/list") //Busca todos os gêneros no banco e os adiciona ao modelo (ui).
    public String getAll(Model ui) {
        ui.addAttribute("generos", generoRepo.findAll());
        return "/generos/list"; //Retorna a página de listagem (/generos/list), que exibirá a lista de gêneros.
    }
}