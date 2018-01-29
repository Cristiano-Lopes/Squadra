package br.com.squadra.segurancadigital.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.squadra.segurancadigital.model.Sistema;
import br.com.squadra.segurancadigital.repository.SistemaRepository;
import br.com.squadra.segurancadigital.repository.filter.SistemaFilter;
import br.com.squadra.segurancadigital.services.SistemaService;

//Com RestController é mais simples do que com o Controller do SpringMVC Elimina o processo de resolver algumas tratativas
@RestController
@RequestMapping("/sistemas")
public class SistemaResource {

	@Autowired
	private SistemaRepository sistemaRepository;

	@Autowired
	private SistemaService sistemaService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Sistema>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(sistemaService.listar());
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> Salvar(@Valid @RequestBody Sistema sistema) {// @RequestBody Pega o que esta vindo na
																				// requisição e coloca as informação
																				// dentro do objeto sistema
		sistema = sistemaService.salvar(sistema);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(sistema.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("id") Long id) {// @PathVariable vai pegar o valor que vem na variavel
																	// e setar no atributo id
		Sistema sistema = sistemaService.buscar(id);
		;
		return ResponseEntity.status(HttpStatus.OK).body(sistema);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		sistemaService.deletar(id);
		return ResponseEntity.noContent().build();

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Sistema sistema, @PathVariable("id") Long id) {
		sistema.setId(id);
		sistemaService.atualizar(sistema);
		return ResponseEntity.noContent().build();
	}

	@GetMapping(params = "filtrar")
	public List<Sistema> filtrar(@Valid SistemaFilter filter) {
		return sistemaRepository.filtrar(filter);
	}
}
