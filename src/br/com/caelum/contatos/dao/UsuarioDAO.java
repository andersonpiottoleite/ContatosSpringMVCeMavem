package br.com.caelum.contatos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.caelum.contatos.modelo.Contato;

@Repository
public class UsuarioDAO {
	
	private Connection connection;// = ConnectionFactory.getConnection();

	@Autowired
	//public UsuarioDAO(Connection connection) {
	public UsuarioDAO(DataSource dataSource) {
		//this.connection = connection;
		try {
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean existeUsuario(String nome, String senha) throws SQLException {
		PreparedStatement preparedStatement = null;
		String sql = "select * from Usuario where nome = ? and senha = ?";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, nome);
			preparedStatement.setString(2, senha);
			ResultSet rs = preparedStatement.executeQuery();

			if(rs.next()) {
				return true;
			}
			
			return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Lascou!");
		} finally {
			preparedStatement.close();
		}
	}

}
