package com.mihtan;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.core.convert.format.Format;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;

import java.time.LocalDate;

@Controller
public class TipoCambioController {

    private final TipoCambioService service;

    public TipoCambioController(TipoCambioService service) {
        this.service = service;
    }

    @Get
    public TipoCambioResponse obtenerTipoCambio(@QueryValue @Nullable @Format("yyyy-MM-dd") LocalDate fecha) {
        return service.obtenerTipoCambio(fecha);
    }
}
