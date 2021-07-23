package org.habv;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@MicronautTest
public class TipoCambioClientTest {

    private static final String FECHA = "22/07/2021";
    private static final String SUB_NIVEL = "N";

    @Inject
    private TipoCambioClient tipoCambioClient;
    @Inject
    private BccrConfig bccrConfig;
    @Inject
    private StringUtil stringUtil;

    @Test
    public void testClientCompra() {
        String response = tipoCambioClient
                .obtenerIndicadorEconomico(
                        BccrConfig.DOLAR_COMPRA,
                        FECHA,
                        FECHA,
                        bccrConfig.getNombre(),
                        SUB_NIVEL,
                        bccrConfig.getCorreo(),
                        bccrConfig.getToken());
        Double result = stringUtil.obtenerValor(response);
        Assertions.assertEquals(614.45, result);
    }

    @Test
    public void testClientVenta() {
        String response = tipoCambioClient
                .obtenerIndicadorEconomico(
                        BccrConfig.DOLAR_VENTA,
                        FECHA,
                        FECHA,
                        bccrConfig.getNombre(),
                        SUB_NIVEL,
                        bccrConfig.getCorreo(),
                        bccrConfig.getToken());
        Double result = stringUtil.obtenerValor(response);
        Assertions.assertEquals(620.18, result);
    }
}
