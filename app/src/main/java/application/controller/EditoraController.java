package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.Editora;
import application.repository.EditoraRepository;

@Controller
@RequestMapping("/editoras") // Define o caminho base para as requisições relacionadas às editoras
public class EditoraController {
    
    @Autowired // Injeta a dependência do repositório de editoras
    private EditoraRepository editoraRepo;
    
    // Método que exibe o formulário para inserir uma nova editora
    @RequestMapping("/insert")
    public String insert() {
        return "/editoras/insert"; // Retorna a página de inserção
    }

    // Método que recebe os dados do formulário para inserir uma nova editora no banco de dados
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestParam("nome") String nome, @RequestParam("cidade") String cidade) {
        Editora editora = new Editora(); // Cria uma nova instância de Editora
        editora.setNome(nome); // Define o nome da editora
        editora.setCidade(cidade); // Define a cidade da editora

        editoraRepo.save(editora); // Salva a editora no banco de dados

        return "redirect:/editoras/list"; // Redireciona para a página de listagem das editoras
    }

    // Método que exibe a lista de todas as editoras
    @RequestMapping("/list")
    public String getAll(Model ui) {
        ui.addAttribute("editoras", editoraRepo.findAll()); // Adiciona as editoras ao modelo
        return "/editoras/list"; // Retorna a página que lista as editoras
    }

    // Método que exibe o formulário para editar uma editora existente
    @RequestMapping("/update")
    public String update(@RequestParam("id") long id, Model ui) {
        Optional<Editora> resultado = editoraRepo.findById(id); // Busca a editora pelo ID

        if(resultado.isPresent()) { // Se a editora foi encontrada
            ui.addAttribute("editora", resultado.get()); // Adiciona a editora ao modelo para exibição
            return "/editoras/update"; // Retorna a página de atualização
        }

        return "redirect:/editoras/list"; // Se não encontrar a editora, redireciona para a lista
    }

    // Método que recebe os dados do formulário para atualizar uma editora existente
    @RequestMapping(value="/update", method=RequestMethod.POST)
    public String update(
        @RequestParam("id") long id,
        @RequestParam("nome") String nome,
        @RequestParam("cidade") String cidade) {
        
        Optional<Editora> resultado = editoraRepo.findById(id); // Busca a editora pelo ID

        if(resultado.isPresent()) { // Se a editora foi encontrada
            resultado.get().setNome(nome); // Atualiza o nome da editora
            resultado.get().setCidade(cidade); // Atualiza a cidade da editora
            editoraRepo.save(resultado.get()); // Salva as alterações no banco de dados
        }

        return "redirect:/editoras/list"; // Redireciona para a lista de editoras
    }

    // Método que exibe a página de confirmação de remoção de uma editora
    @RequestMapping("/delete")
    public String delete(@RequestParam("id") long id, Model ui) {
        Optional<Editora> resultado = editoraRepo.findById(id); // Busca a editora pelo ID

        if(resultado.isPresent()) { // Se a editora foi encontrada
            ui.addAttribute("editora", resultado.get()); // Adiciona a editora ao modelo para exibição
            return "/editoras/delete"; // Retorna a página de confirmação de remoção
        }

        return "redirect:/editoras/list"; // Se não encontrar a editora, redireciona para a lista
    }

    // Método que remove a editora do banco de dados
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("id") long id) {
        editoraRepo.deleteById(id); // Exclui a editora pelo ID
        return "redirect:/editoras/list"; // Redireciona para a lista de editoras
    }
}
