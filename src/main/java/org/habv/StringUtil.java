package org.habv;

import javax.inject.Singleton;

@Singleton
public class StringUtil {

    private static final String PREFIX = "&lt;NUM_VALOR&gt;";
    private static final String SUFFIX = "&lt;/NUM_VALOR&gt;";

    public Double obtenerValor(String response) {
        String valor = response.substring(
                response.indexOf(PREFIX) + PREFIX.length(),
                response.indexOf(SUFFIX));
        return Double.valueOf(valor);
    }
}
