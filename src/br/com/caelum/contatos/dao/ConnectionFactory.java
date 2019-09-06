package br.com.caelum.contatos.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConnection(){
		try {
			// Nesse caso a senha � vazia mesmo.
			Class.forName("com.mysql.jdbc.Driver");// en caso de alguns servidores de alica��o
			//  servlets containers, e tambem caso de o JBDC for abaixo da ver�o 3 
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/banco", "root", "");
			return connection;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}
