package br.tec.db.springjava2023.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.tec.db.springjava2023.data.ClienteDTO;
import br.tec.db.springjava2023.entity.ClienteEntity;
import br.tec.db.springjava2023.repository.ClienteRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<ClienteDTO> listaClientes() {
		log.info(">>>> Listando clientes cadastrados");
		List<ClienteDTO> clientes = new ArrayList<>();
		List<ClienteEntity> clientesCadastrados = clienteRepository.findAll();

		for (ClienteEntity cadastrado : clientesCadastrados) {
			ClienteDTO cliente = ClienteDTO.builder()
					.nome(cadastrado.getNome())
					.cpf(cadastrado.getCpf())
					.dataNascimento(cadastrado.getDataNascimento())
					.email(cadastrado.getEmail())
					.celular(cadastrado.getCelular())
					.build();

			clientes.add(cliente);
		}

		return clientes;
	}

	public ClienteDTO buscaClientePorId(Long id) {
		log.info(">>>> Buscando cliente com id {}", id);
		ClienteDTO retorno = null;

		Optional<ClienteEntity> cliente = clienteRepository.findById(id);
		
		if (cliente.isPresent()) {
			retorno = ClienteDTO.builder()
					.nome(cliente.get().getNome())
					.cpf(cliente.get().getCpf())
					.dataNascimento(cliente.get().getDataNascimento())
					.email(cliente.get().getEmail())
					.celular(cliente.get().getCelular())
					.build();
		}
		
		return retorno;
	}
	
	public ClienteDTO buscaClientePorCPF(String cpf) {
		log.info(">>>> Buscando cliente com cpf {}", cpf);
		ClienteDTO retorno = null;

		Optional<ClienteEntity> cliente = clienteRepository.findByCpf(cpf);
		
		if (cliente.isPresent()) {
			retorno = ClienteDTO.builder()
					.nome(cliente.get().getNome())
					.cpf(cliente.get().getCpf())
					.dataNascimento(cliente.get().getDataNascimento())
					.email(cliente.get().getEmail())
					.celular(cliente.get().getCelular())
					.build();
		}
		
		return retorno;
	}

	public ClienteEntity cadastraCliente(ClienteDTO cliente) {
		log.info(">>>> Cadastrando novo cliente");
		ClienteEntity novoCliente = ClienteEntity.builder()
				.celular(cliente.getCelular())
				.cpf(cliente.getCpf())
				.dataNascimento(cliente.getDataNascimento())
				.email(cliente.getEmail())
				.nome(cliente.getNome())
				.build();
				
		return clienteRepository.save(novoCliente);
	}
}
