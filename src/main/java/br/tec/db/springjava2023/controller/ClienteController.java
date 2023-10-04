package br.tec.db.springjava2023.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.tec.db.springjava2023.data.ClienteDTO;
import br.tec.db.springjava2023.service.ClienteService;

@RestController
@RequestMapping(path = "clientes")
@SuppressWarnings("rawtypes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity listaClientes() {
		return ResponseEntity.ok(clienteService.listaClientes());
	}

	@GetMapping(value = { "busca-por-id/{id}" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity listaClientePorId(@PathVariable Long id) {
		ClienteDTO retorno = clienteService.buscaClientePorId(id);

		if (retorno != null)
			return ResponseEntity.ok(retorno);
		return ResponseEntity.notFound().build();
	}

	@GetMapping(value = { "busca-por-cpf/{cpf}" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity listaClientePorCPF(@PathVariable(name = "cpf") String cpf) {
		ClienteDTO retorno = clienteService.buscaClientePorCPF(cpf);

		if (retorno != null)
			return ResponseEntity.ok(retorno);
		return ResponseEntity.notFound().build();
	}

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity cadastraCliente(@RequestBody ClienteDTO cliente) {
		return ResponseEntity.ok(clienteService.cadastraCliente(cliente));
	}
}
