package br.com.caelum.contatos.dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.caelum.contatos.dao.ConnectionFactory;
import br.com.caelum.contatos.dao.DAOException;
import br.com.caelum.contatos.modelo.Contato;

@Repository
public class ContatoDAO {

	private Connection connection; // = ConnectionFactory.getConnection();

	@Autowired
	//public ContatoDAO(Connection connection) {
	public ContatoDAO(DataSource dataSource) {
		//this.connection = connection;
		try {
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ContatoDAO() {
	
	}

	public void adicionaContato(Contato contato) throws SQLException {
		PreparedStatement prepareStatement = null;
		try {

			String sql = "insert into contatos (nome, email, endereco, data_nascimento) " + "values (?,?,?,?);";

			prepareStatement = connection.prepareStatement(sql);

			prepareStatement.setString(1, contato.getNome());
			prepareStatement.setString(2, contato.getEmail());
			prepareStatement.setString(3, contato.getEndereco());
			if(contato.getDataNascimento() == null) {
				contato.setDataNascimento(Calendar.getInstance());
			}
				prepareStatement.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			

			prepareStatement.execute();
			//throw new IllegalArgumentException();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("DEU ERRO MANO!");
		} finally {
			prepareStatement.close();
		}

	}

	public List<Contato> getLista() throws SQLException {

		//String sql = "select * from contatos where nome like '%A%'";
		String sql = "select * from contatos";

		PreparedStatement prepareStatement = null;

		try {

			List<Contato> contatos = new ArrayList<>();
			prepareStatement = connection.prepareStatement(sql);

			// prepareStatement.setString(1, "A");

			ResultSet resultSet = prepareStatement.executeQuery();

			while (resultSet.next()) {
				Contato contato = new Contato();

				contato.setId(resultSet.getLong("id"));
				contato.setNome(resultSet.getString("nome"));
				contato.setEmail(resultSet.getString("email"));
				contato.setEndereco(resultSet.getString("endereco"));

				Calendar data = Calendar.getInstance();
				Date date = resultSet.getDate("data_nascimento");
				data.setTime(date);

				contato.setDataNascimento(data);

				contatos.add(contato);
			}

			return contatos;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Deu Zica!");
		} finally {
			prepareStatement.close();
		}

	}

	public Contato buscaContatoPorID(long id) throws SQLException {
		PreparedStatement preparedStatement = null;
		String sql = "select * from contatos where id = ?";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			Contato contato = new Contato();

			rs.next();
			contato.setId(rs.getLong("id"));
			contato.setNome(rs.getString("nome"));
			contato.setEmail(rs.getString("email"));
			contato.setEndereco(rs.getString("endereco"));
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("data_nascimento"));
			contato.setDataNascimento(data);

			return contato;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Lascou!");
		} finally {
			preparedStatement.close();
		}
	}

	public void alteraContato(Contato contato) throws SQLException {

		String sql = "update contatos set nome = ?, email = ?, endereco = ?, data_nascimento = ?" + "where id = ?";

		PreparedStatement prepareStatement = null;

		try {
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, contato.getNome());
			prepareStatement.setString(2, contato.getEmail());
			prepareStatement.setString(3, contato.getEndereco());
			if(contato.getDataNascimento() == null) {
				contato.setDataNascimento(Calendar.getInstance());
			}
			prepareStatement.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			
			prepareStatement.setLong(5, contato.getId());

			prepareStatement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Eita Nóis");
		} finally {
			prepareStatement.close();
		}

	}
	
public void removeContato(Contato contato) throws SQLException {
		
		String sql = "delete from contatos where id = ?";
		PreparedStatement prepareStatement = null;
		
		try {
			prepareStatement =  connection.prepareStatement(sql);
			prepareStatement.setLong(1, contato.getId());
			
			prepareStatement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("ZUOU");
		}finally {
			prepareStatement.close();
		}
		
		
	}

}
