package com.mihtan;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.NonNull;

import java.time.LocalDate;

@Introspected
public class TipoCambioResponse {

    @NonNull
    private final Double compra;

    @NonNull
    private final Double venta;

    @NonNull
    private final LocalDate fecha;

    public TipoCambioResponse(@NonNull Double compra, @NonNull Double venta, @NonNull LocalDate fecha) {
        this.compra = compra;
        this.venta = venta;
        this.fecha = fecha;
    }

    @NonNull
    public Double getCompra() {
        return compra;
    }

    @NonNull
    public Double getVenta() {
        return venta;
    }

    @NonNull
    public LocalDate getFecha() {
        return fecha;
    }
}
