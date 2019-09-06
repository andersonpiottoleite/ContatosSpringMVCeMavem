package br.com.caelum.contatos.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Connection;

import br.com.caelum.contatos.dao.ContatoDAO;
import br.com.caelum.contatos.modelo.Contato;

@Controller
public class ContatoController {
	
	private ContatoDAO contatoDAO;
	
	@Autowired
	public ContatoController(ContatoDAO contatoDAO) {
		this.contatoDAO = contatoDAO;
	}
	
	@RequestMapping("/form")
	public String form() {
		return "contatos/adiciona-contato"; 

	}
	
	@RequestMapping("/adicionaContato")
	public String adiciona(@Valid Contato contato, BindingResult result, HttpServletRequest request) throws SQLException {
		
		if (result.hasFieldErrors("nome")) {
			// instalar o bean validator depois
			System.out.println("Deu erro!");
			return "contatos/adiciona-contato";
		}
		
		Connection connection = (Connection) request.getAttribute("connection");
		//ContatoDAO contatoDAO = new ContatoDAO(connection);
		
		if(contato.getId() != 0) {
			contatoDAO.alteraContato(contato);
		}else {
			contatoDAO.adicionaContato(contato);
		}
		
		return "redirect:/lista";
	}
	
	@RequestMapping("/carregaContato")
	public String carrega(Long id, Model model, HttpServletRequest request) throws SQLException {
		
		Connection connection = (Connection) request.getAttribute("connection");
		//ContatoDAO contatoDAO = new ContatoDAO(connection);
		
		Contato contato = contatoDAO.buscaContatoPorID(id);
		
		model.addAttribute("contato", contato);
		
		
		return "contatos/editar-contato";
	}
	
	@RequestMapping("/lista")
	public String lista(Model model, HttpServletRequest request) {
		Connection connection = (Connection) request.getAttribute("connection");
		//ContatoDAO contatoDAO = new ContatoDAO(connection);
		  try {
			model.addAttribute("lista",contatoDAO.getLista());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		  return "contatos/lista";
	}
	
	@RequestMapping("/remove")
	public String remove(int id, HttpServletRequest request) {
		try {
		Connection connection = (Connection) request.getAttribute("connection");
		//ContatoDAO contatoDAO = new ContatoDAO(connection);
		Contato contato = new Contato();
		contato.setId(id);
		
		contatoDAO.removeContato(contato);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/lista";
	}

}
