package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import application.repository.AutorRepository;

@Controller
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepo; // Injeta o repositório de autores para acessar o banco de dados.

    // Mapeia a URL "/autores/list" para listar todos os autores
    @RequestMapping("/list")
    public String list(Model ui) {
        // Adiciona todos os autores ao modelo para exibição na view
        ui.addAttribute("autores", autorRepo.findAll());
        // Retorna a view "/autores/list" para renderizar a lista de autores
        return "/autores/list";
    }

    // Mapeia a URL "/autores/insert" para mostrar o formulário de inserção de um novo autor
    @RequestMapping("/insert")
    public String insert() {
        // Retorna a view "/autores/insert" com o formulário para inserir um autor
        return "/autores/insert";
    }

    // Mapeia a URL "/autores/insert" com o método POST para processar a inserção de um autor
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insertAutor(String nome) {
        // Cria e salva um novo autor no banco de dados
        Autor novoAutor = new Autor();
        novoAutor.setNome(nome);
        autorRepo.save(novoAutor);
        
        // Após salvar o autor, redireciona para a lista de autores
        return "redirect:/autores/list";
    }
}
