package br.com.squadra.segurancadigital.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.squadra.segurancadigital.model.DetalheErro;
import br.com.squadra.segurancadigital.services.exceptions.SistemaNaoEncontradoException;

//Encarregado de tratar as exceções 
@ControllerAdvice
public class ResourceExceptionHandler {

	//Qualquer exceção que for lançado do tipo SistemaNaoEncontradoException retorna para o cliente final um not found
	@ExceptionHandler(SistemaNaoEncontradoException.class)
	public ResponseEntity<DetalheErro> handleSistemaNaoEncontradoException(SistemaNaoEncontradoException e, HttpServletRequest request){
		
		DetalheErro erro = new DetalheErro();
		erro.setStatus(404l);
		erro.setTitulo("Nenhum Sistema foi encontrado. Favor revisar os critérios da sua pesquisa!");
				
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
}
