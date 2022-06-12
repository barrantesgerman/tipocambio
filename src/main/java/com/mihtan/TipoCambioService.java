package com.mihtan;

import jakarta.inject.Singleton;

import java.time.LocalDate;

@Singleton
public class TipoCambioService {

    private static final Integer DOLAR_COMPRA = 317;
    private static final Integer DOLAR_VENTA = 318;
    private static final String PREFIX = "&lt;NUM_VALOR&gt;";
    private static final String SUFFIX = "&lt;/NUM_VALOR&gt;";

    private final TipoCambioClient client;
    private final TipoCambioConfig config;

    public TipoCambioService(TipoCambioClient client, TipoCambioConfig config) {
        this.client = client;
        this.config = config;
    }

    public TipoCambioResponse obtenerTipoCambio(LocalDate fecha) {
        fecha = fecha == null ? LocalDate.now() : fecha;
        Double compra = obtenerTipoCambio(fecha, DOLAR_COMPRA);
        Double venta = obtenerTipoCambio(fecha, DOLAR_VENTA);
        return new TipoCambioResponse(compra, venta, fecha);
    }

    private Double obtenerTipoCambio(LocalDate fecha, Integer indicador) {
        String response = client.obtenerIndicadorEconomico(
                indicador,
                fecha,
                fecha,
                config.getNombre(),
                "N",
                config.getCorreo(),
                config.getToken());
        return obtenerValor(response);
    }

    private Double obtenerValor(String response) {
        if(response.contains(PREFIX)) {
            String valor = response.substring(
                    response.indexOf(PREFIX) + PREFIX.length(),
                    response.indexOf(SUFFIX));
            return Double.valueOf(valor);
        } else {
            return 0D;
        }
    }
}
