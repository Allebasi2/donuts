package br.com.donuts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.donuts.dao.ConnectionFactory;
import br.com.donuts.dao.DonutsDao;
import br.com.donuts.model.Donuts;

// Anotação
@Controller
public class IndexController {

	@RequestMapping
	public String inicio() {
		// conecta ao banco de dados
		ConnectionFactory.conectar();
		// Redirecionar para rota/home
		return "redirect:home";
	}

	// String -> Retorno de uma pagina
	@RequestMapping("/home") // http://localhost:8080/
	public String index(Model model) {
		DonutsDao dao = new DonutsDao();
		
		model.addAttribute("donuts", dao.listar());
		return "home"; // home.html
	}

	@RequestMapping("/form")
	public String form(Long idDonuts, Model model) {
		DonutsDao dao = new DonutsDao();
		
		Donuts d = new Donuts();
		
		if(idDonuts != null) {
			d = dao.buscar(idDonuts);
		}
				
		model.addAttribute("donuts", d);	
		
		return "form"; // form.html
	}

	@RequestMapping("/donuts")
	public String donuts(Long idDonuts, Model model) {
		
		DonutsDao dao = new DonutsDao();
		
		model.addAttribute("donuts", dao.buscar(idDonuts));
		return "donuts";
	}
	@RequestMapping(value = "adicionarDonuts", method = RequestMethod.POST)
	public String adicionarDonuts(Donuts donuts) {
		DonutsDao dao = new DonutsDao();
		dao.inserir(donuts);
		return "redirect:home";
	}
	
	@RequestMapping(value = "atualizarDonuts", method = RequestMethod.POST)
	public String atualizarDonuts(Long idDonuts, Donuts donuts) {
		DonutsDao dao = new DonutsDao();
		
		dao.atualizar(donuts, idDonuts);
		
		return "redirect:home";
	}
	
@RequestMapping("deletarDonuts")
public String deletarDonuts(Long idDonuts) {
	
	DonutsDao dao = new DonutsDao();
	
	dao.excluir(idDonuts);
	
	return "redirect:home";
	
	
}
	
}
