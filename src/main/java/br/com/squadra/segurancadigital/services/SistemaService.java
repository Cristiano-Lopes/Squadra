package br.com.squadra.segurancadigital.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.squadra.segurancadigital.model.Sistema;
import br.com.squadra.segurancadigital.model.Status;
import br.com.squadra.segurancadigital.repository.SistemaRepository;
import br.com.squadra.segurancadigital.services.exceptions.SistemaNaoEncontradoException;

@Service
public class SistemaService {

	@Autowired
	private SistemaRepository sistemaRepository;
	
	public List<Sistema> listar(){
		return sistemaRepository.findAll();
	}
	
	public Sistema buscar(Long id) {
		Sistema sistema = sistemaRepository.findOne(id);
		
		if(sistema == null) {
			throw new SistemaNaoEncontradoException("O sistema não pode ser encontrado.");
		}
		return sistema;
	}
	
	public Sistema salvar(Sistema sistema) {
		sistema.setId(null);
		sistema.setStatus(Status.ATIVO);
		sistema.setDataAlteracao(LocalDate.now());
		return sistemaRepository.save(sistema);
	}
	
	public void deletar(Long id) {
		try {
			sistemaRepository.delete(id);
		}catch(EmptyResultDataAccessException e) {
			throw new SistemaNaoEncontradoException("O Sistema não pode ser encontrado.");
		}		
	}
	
	public void atualizar(Sistema sistema) {
		verificarExistencia(sistema);
		sistemaRepository.save(sistema);
	}
	
	private void verificarExistencia(Sistema sistema) {
		buscar(sistema.getId());
	}
	
	
}
