package com.mihtan;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.core.annotation.NonNull;

@ConfigurationProperties(TipoCambioConfig.PREFIX)
public interface TipoCambioConfig {

    String PREFIX = "bccr";

    @NonNull
    String getUrl();

    @NonNull
    String getToken();

    @NonNull
    String getNombre();

    @NonNull
    String getCorreo();
}
