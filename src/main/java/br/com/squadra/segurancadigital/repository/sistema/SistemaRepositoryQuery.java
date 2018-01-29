package br.com.squadra.segurancadigital.repository.sistema;

import java.util.List;

import br.com.squadra.segurancadigital.model.Sistema;
import br.com.squadra.segurancadigital.repository.filter.SistemaFilter;

public interface SistemaRepositoryQuery {

	//Abstração do metodo filtrar 
	List<Sistema> filtrar(SistemaFilter filter);
}
