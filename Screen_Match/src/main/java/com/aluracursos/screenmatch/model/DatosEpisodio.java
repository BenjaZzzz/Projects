package com.aluracursos.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosEpisodio(@JsonAlias("Title") String titulo,
                            @JsonAlias({"totalSeasons","Episode"})Integer numeroEpisodio,
                            @JsonAlias("imdbRating") String evaluacion,
                            @JsonAlias("Released") String fechaDeLanzamiento) {

//    @Override
//    public String toString() {
//        return String.format("""
//                Titulo: %s
//                Numero de episodios: %d
//                Evaluacion: %s
//                Fecha de lanzamiento: %s
//                """, titulo, numeroEpisodio, evaluacion, fechaDeLanzamiento);
//    }
}
