package org.habv;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.context.annotation.Requires;

@ConfigurationProperties(BccrConfig.PREFIX)
@Requires(property = BccrConfig.PREFIX)
public class BccrConfig {

    public static final String PREFIX = "bccr";
    public static final String API_URL = "https://gee.bccr.fi.cr/Indicadores/Suscripciones/WS/wsindicadoreseconomicos.asmx";

    public static final String DOLAR_COMPRA = "317";
    public static final String DOLAR_VENTA = "318";
    public static final String PATRON_FECHA = "dd/MM/yyyy";

    private String nombre;
    private String correo;
    private String token;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
