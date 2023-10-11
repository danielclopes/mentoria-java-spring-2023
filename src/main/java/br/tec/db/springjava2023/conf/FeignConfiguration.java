package br.tec.db.springjava2023.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;

@Configuration
public class FeignConfiguration {

	@Bean
	Contract feignContract() {
		return new Contract.Default();
	}
}
