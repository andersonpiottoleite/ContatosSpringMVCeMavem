package br.com.caelum.contatos.modelo;


import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Contato {

	private long id;
	@NotNull @Size(min=5)
	private String nome;
	private String email;
	private String endereco;
	private Calendar dataNascimento;
	private boolean vivo = true;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	@Override
	public String toString() {
	
		StringBuilder sb = new StringBuilder();
		
		sb.append(getId() + "\n");
		sb.append(getNome() + "\n");
		sb.append(getEmail() + "\n");
		sb.append(getEndereco()+ "\n");
		
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = fmt.format(getDataNascimento().getTime());
		sb.append(dataFormatada + "\n");
		
		return sb.toString();
	}

	public boolean isVivo() {
		return vivo;
	}

	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}

}
