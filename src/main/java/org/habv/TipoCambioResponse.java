package org.habv;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Introspected;

import java.time.LocalDate;

@Introspected
public class TipoCambioResponse {

    @NonNull
    private Double compra;

    @NonNull
    private Double venta;

    public TipoCambioResponse() {
    }

    @NonNull
    public Double getCompra() {
        return compra;
    }

    public void setCompra(@NonNull Double compra) {
        this.compra = compra;
    }

    @NonNull
    public Double getVenta() {
        return venta;
    }

    public void setVenta(@NonNull Double venta) {
        this.venta = venta;
    }

}
