package edu.infnet.applivraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import edu.infnet.applivraria.domain.Aluno;
import edu.infnet.applivraria.domain.Usuario;
import edu.infnet.applivraria.service.AlunoService;

@Controller
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;
	
	@GetMapping(value = "/aluno")
	public String telaCadastro() {
		return "aluno/cadastro";
	}
	
	@GetMapping(value = "/alunos")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("alunoLista", alunoService.obterLista(usuario));
		return "aluno/lista";
	}

	@PostMapping(value = "/aluno/incluir")
	public String incluir(Aluno aluno, Model model, @SessionAttribute("user") Usuario usuario){
		
		aluno.setUsuario(usuario);
		
		alunoService.incluir(aluno);
		
		model.addAttribute("mensagem", "O aluno " + aluno.getNome() + " foi incluído com sucesso!!!");

		return telaLista(model, usuario);
	}
	
	@GetMapping(value = "/aluno/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {
		
		Aluno aluno = alunoService.obterPorId(id);
		
		if(aluno != null) {
			alunoService.excluir(id);
			model.addAttribute("mensagem", "O aluno "+aluno.getNome()+" foi excluído com sucesso!!!"); 
		}else {
			model.addAttribute("mensagem", "Aluno inexistente. Imporssível excluir!"); 
		} 
		
		return telaLista(model, usuario);
	} 

} 