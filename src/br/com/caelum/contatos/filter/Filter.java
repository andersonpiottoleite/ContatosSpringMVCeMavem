package br.com.caelum.contatos.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import br.com.caelum.contatos.dao.ConnectionFactory;


@WebFilter("/*")
//@Repository
public class Filter implements javax.servlet.Filter {
	
	//private Connection connection;
	
	/*@Autowired
	public Filter(DataSource dataSource) {
		try {
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Connection connection = null;
		try {
			HttpServletRequest request2 = (HttpServletRequest) request;

			if (!request2.getRequestURI().contains("/form")) {
				connection = ConnectionFactory.getConnection();

				request.setAttribute("connection", connection);
			}
			chain.doFilter(request, response);

			if (connection != null) {
				connection.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
