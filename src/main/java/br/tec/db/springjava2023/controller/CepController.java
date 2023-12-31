package br.tec.db.springjava2023.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.tec.db.springjava2023.service.CepService;

@RestController
@RequestMapping(path = "cep")
@SuppressWarnings("rawtypes")
public class CepController {

	@Autowired
	private CepService cepService;

	@GetMapping(value = { "busca-dados/{cep}" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity buscaDadosCep(@PathVariable String cep) {
		return ResponseEntity.ok(cepService.buscaDadosCep(cep));
	}
}
