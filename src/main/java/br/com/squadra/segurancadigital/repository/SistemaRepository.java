package br.com.squadra.segurancadigital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.squadra.segurancadigital.model.Sistema;
import br.com.squadra.segurancadigital.repository.sistema.SistemaRepositoryQuery;

//Abstração do Spring data e personalizando metodo de pesquisa com SistemaRepositoryQuery
public interface SistemaRepository extends JpaRepository<Sistema, Long>, SistemaRepositoryQuery{

}