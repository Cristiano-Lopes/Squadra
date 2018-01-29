package br.com.squadra.segurancadigital.services.exceptions;

public class SistemaNaoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = 7052381483301345155L;

	public SistemaNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public SistemaNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
