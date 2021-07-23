package org.habv;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.client.annotation.Client;

@Client(BccrConfig.API_URL)
public interface TipoCambioClient {

    @Get("/ObtenerIndicadoresEconomicosXML")
    public String obtenerIndicadorEconomico(
            @QueryValue("Indicador") String indicador,
            @QueryValue("FechaInicio") String fechaInicio,
            @QueryValue("FechaFinal") String fechaFinal,
            @QueryValue("Nombre") String nombre,
            @QueryValue("SubNiveles") String subNivel,
            @QueryValue("CorreoElectronico") String correo,
            @QueryValue("Token") String token);
}
