package br.tec.db.springjava2023.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.tec.db.springjava2023.entity.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

	Optional<ClienteEntity> findByCpf(String cpf);

}
