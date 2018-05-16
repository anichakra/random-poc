package me.anichakra.poc.random.beanio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CsvReadWriteApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(CsvReadWriteApplication.class, args);
	}

	@Autowired
	private CsvService csvService;

	@Override
	public void run(String... args) throws Exception{
		csvService.readWriteCsv();
	}



}
