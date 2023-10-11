package br.tec.db.springjava2023;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import br.tec.db.springjava2023.entity.ClienteEntity;
import br.tec.db.springjava2023.repository.ClienteRepository;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
@EnableFeignClients
public class Application {
	
	private static Path pathArquivo = Paths.get("src", "main", "resources", "clientes.csv");
	
	@Autowired
	private ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public void carregarDados() throws IOException, CsvException {
		log.info(">>>> Iniciando a carga de dados");
		FileReader filereader = new FileReader(pathArquivo.toString());

		CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
		List<String[]> allData = csvReader.readAll();

		for (String[] row : allData) {
			ClienteEntity cliente = ClienteEntity.builder()
					.nome(row[0])
					.cpf(row[1])
					.dataNascimento(row[2])
					.email(row[3])
					.celular(row[4])
					.build();

			clienteRepository.save(cliente);
		}
		
		log.info(">>>> Carga de dados finalizada");
	}
}
