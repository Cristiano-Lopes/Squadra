package br.com.squadra.segurancadigital.model;

public enum Status {

	ATIVO("Ativo"), CANCELADO("Cancelado");

	private String descricao;

	private Status(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
