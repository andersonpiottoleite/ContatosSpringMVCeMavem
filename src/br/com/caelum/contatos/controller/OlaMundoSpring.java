package br.com.caelum.contatos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OlaMundoSpring {
	
	@RequestMapping("/olaMundo")
	public String olaMundo() {
		return "olaMundo";
	}
	

}
