package com.aluracursos.screenmatch;

import ch.qos.logback.classic.pattern.LineSeparatorConverter;
import com.aluracursos.screenmatch.model.DatosEpisodio;
import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.model.DatosTemporadas;
import com.aluracursos.screenmatch.principal.EjemploStreams;
import com.aluracursos.screenmatch.principal.Principal;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class ScreenmatchApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		System.out.println("Primer proyecto Spring sin Web");
//		var consumoApi = new ConsumoAPI();
//		String url = "https://omdbapi.com/?t=Game+of+Thrones&season=1&pisode=1&apikey=aea7a791";
//		//var json = consumoApi.obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&Season=1&apikey=4fc7c187");
//		var json = consumoApi.obtenerDatos(url);
//
//		//System.out.println(json);
////		json = consumoApi.obtenerDatos("https://coffee.alexflipnote.dev/random.json");
////		System.out.println(json);
//
//		//
//		ConvierteDatos conversor = new ConvierteDatos();
//		DatosSerie datos = conversor.obtenerDatos(json, DatosSerie.class);
//		//System.out.println(datos);
//
//		//
//		json = consumoApi.obtenerDatos(url);
//		DatosEpisodio episodios = conversor.obtenerDatos(json,DatosEpisodio.class);
//		//System.out.println(episodios);

		Principal principal = new Principal();
		principal.muestraElMenu();

//		EjemploStreams ejemploStreams = new EjemploStreams();
//		ejemploStreams.muestraEjemplo();

	}
}
