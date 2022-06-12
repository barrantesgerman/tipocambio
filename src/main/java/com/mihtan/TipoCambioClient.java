package com.mihtan;

import io.micronaut.core.convert.format.Format;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.client.annotation.Client;

import java.time.LocalDate;

@Client("${bccr.url}")
public interface TipoCambioClient {

    @Get("/ObtenerIndicadoresEconomicosXML")
    public String obtenerIndicadorEconomico(
            @QueryValue("Indicador") Integer indicador,
            @QueryValue("FechaInicio") @Format("dd/MM/yyyy") LocalDate fechaInicio,
            @QueryValue("FechaFinal")  @Format("dd/MM/yyyy") LocalDate fechaFinal,
            @QueryValue("Nombre") String nombre,
            @QueryValue("SubNiveles") String subNivel,
            @QueryValue("CorreoElectronico") String correo,
            @QueryValue("Token") String token);
}
