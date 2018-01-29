package br.com.squadra.segurancadigital.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexResource {

	@RequestMapping("/")
	public String iniciaIndex() {
		return "index";
	}
}
