package br.com.caelum.contatos.controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.contatos.dao.ContatoDAO;
import br.com.caelum.contatos.dao.UsuarioDAO;
import br.com.caelum.contatos.modelo.Usuario;

@Controller
public class LoginController {
	
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	public LoginController(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
		
	}

	@RequestMapping("formLogin")
	public String formLogin() {
		return "contatos/formulario-login";
	}
	
	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Usuario usuario, HttpSession httpSession, HttpServletRequest request) throws SQLException {
		
		Connection connection = (Connection) request.getAttribute("connection");
		//UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
		
		if(usuarioDAO.existeUsuario(usuario.getNome(), usuario.getSenha())) {
			
			httpSession.setAttribute("usuarioLogado", usuario);
			
			return "contatos/menu";
		}
		
		return "contatos/formulario-login";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession httpSession) {
		httpSession.invalidate();
		
		return "redirect:loginForm";
	}
	
}
