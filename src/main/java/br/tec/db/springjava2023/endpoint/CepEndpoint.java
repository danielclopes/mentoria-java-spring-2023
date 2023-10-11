package br.tec.db.springjava2023.endpoint;

import org.springframework.cloud.openfeign.FeignClient;

import br.tec.db.springjava2023.data.CepDTO;
import feign.Param;
import feign.RequestLine;

@FeignClient(value = "cep-resource", url = "${feign.client.config.default.cep-resource.url}")
public interface CepEndpoint {

	@RequestLine("GET {cep}/json/")
	CepDTO buscaDadosCep(@Param(value = "cep") String cep);
}
