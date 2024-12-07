package br.com.donuts.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.donuts.dao.FuncionarioDao;
import br.com.donuts.dao.ConnectionFactory;
import br.com.donuts.model.Funcionario;

@Controller
public class FuncionariosController {
 
	@RequestMapping("/funcionarios3")
	public String index(Long idFuncionario, Model model) {
		FuncionarioDao dao = new FuncionarioDao();
 
		model.addAttribute("funcionarios", dao.listar());
 
		Funcionario f = new Funcionario();
		
		FuncionarioDao dao2 = new FuncionarioDao();

		System.out.println("Esse e o id: " + idFuncionario);
		
		if (idFuncionario != null) {
			f = dao2.buscar(idFuncionario);
		}
		model.addAttribute("funcionario", f);
		
		return "funcionarios";
	}
 
	@RequestMapping("/funcionarios")
	public String funcionarios (Long idFuncionario, Model model) {
		FuncionarioDao dao = new FuncionarioDao();
 
		Funcionario f = new Funcionario();
 
		if (idFuncionario != null) {
			f = dao.buscar(idFuncionario);
		}
		model.addAttribute("funcionario", f);
		
		List<Funcionario> listaFuncionarios = dao.listar();
		
		listaFuncionarios = dao.listar();
		
		model.addAttribute("funcionarios", listaFuncionarios);
		
		return "funcionarios";
	}
 
	@RequestMapping("/funcionarios2")
	public String funcionario(Long idFuncionario, Model model) {
		FuncionarioDao dao = new FuncionarioDao();
 
		model.addAttribute("funcionarios", dao.buscar(idFuncionario));
 
		return "funcionarios";
	}
 
	@RequestMapping(value = "adicionarFuncionario", method = RequestMethod.POST)
	public String adicionarFuncionario(Funcionario funcionario) {
		FuncionarioDao dao = new FuncionarioDao();
		dao.inserir(funcionario);
		return "redirect:funcionarios3";
 
	}
 
	@RequestMapping(value = "atualizarFuncionario", method = RequestMethod.POST)
	public String atualizarFuncionario(Long idFuncionario, Funcionario f) {
		FuncionarioDao dao = new FuncionarioDao();
 
		dao.atualizar(f, idFuncionario);
		return "redirect:funcionarios3";
	}
 
	@RequestMapping("deletarFuncionario")
	public String deletarFuncionario(Long idFuncionario) {
		FuncionarioDao dao = new FuncionarioDao();
 
		dao.excluir(idFuncionario);
 
		return "redirect:funcionarios3";
	}
}


