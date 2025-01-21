package com.aluracursos.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.text.Format;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosSerie(
        @JsonAlias("Title") String titulo,
        @JsonAlias("totalSeasons")Integer totalTemporadas,
        @JsonAlias("imdbRating") String evaluacion) {

//    @Override
//    public String toString() {
////         String texto = """
////                Titulo: %s
////                Total de temporadas: %d
////                Evaluacion: %s
////                """;
//        //var textoMod  = String.format(texto, titulo, totalTemporadas, evaluacion);
//        return String.format("""
//                Titulo: %s
//                Total de temporadas: %d
//                Evaluacion: %s
//                """, titulo, totalTemporadas, evaluacion);
//    }
}
