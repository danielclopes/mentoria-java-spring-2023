package br.tec.db.springjava2023.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.tec.db.springjava2023.data.CepDTO;
import br.tec.db.springjava2023.endpoint.CepEndpoint;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CepService {

	@Autowired
	private CepEndpoint cepEndpoint;

	public CepDTO buscaDadosCep(String cep) {
		log.info(">>>>> Buscando dados para o cep {}", cep);
		return cepEndpoint.buscaDadosCep(cep);
	}
}
