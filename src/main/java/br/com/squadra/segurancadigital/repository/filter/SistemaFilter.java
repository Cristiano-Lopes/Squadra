package br.com.squadra.segurancadigital.repository.filter;

import org.hibernate.validator.constraints.Email;

public class SistemaFilter {

	private String descricao;
	private String sigla;
	private String email;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	@Email
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
