package org.habv;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Introspected;

import java.time.LocalDate;

@Introspected
public class TipoCambioRequest {

    @NonNull
    private LocalDate fecha;

    public TipoCambioRequest() {
    }

    @NonNull
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(@NonNull LocalDate fecha) {
        this.fecha = fecha;
    }
}
