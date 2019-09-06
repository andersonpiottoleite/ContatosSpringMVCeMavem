package br.com.caelum.contatos.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if(request.getRequestURI().endsWith("formLogin")
				|| request.getRequestURI().endsWith("efetuaLogin")
				|| request.getRequestURI().contains("resources")) {
			
			return true;
		}
		
		if(request.getSession().getAttribute("usuarioLogado") != null) {
			return true;
		}
		response.sendRedirect("formLogin");
		return false;
	}
}
