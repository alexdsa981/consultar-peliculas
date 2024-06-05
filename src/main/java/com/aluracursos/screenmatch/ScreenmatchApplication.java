package com.aluracursos.screenmatch;

import com.aluracursos.screenmatch.service.ConsumoAPI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(ScreenmatchApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		ConsumoAPI consumoApi = new ConsumoAPI();
		String json = consumoApi.obtenerDatos("https://www.omdbapi.com/?apikey=7880a47c&t=breaking+bad");
		System.out.println(json);
	}
}
