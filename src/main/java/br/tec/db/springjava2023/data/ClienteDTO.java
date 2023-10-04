package br.tec.db.springjava2023.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ClienteDTO {

	private String nome;
	private String cpf;
	private String dataNascimento;
	private String email;
	private String celular;
}
