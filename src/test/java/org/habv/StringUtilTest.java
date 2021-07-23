package org.habv;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@MicronautTest
public class StringUtilTest {

    private static final String XML
            = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<string xmlns=\"http://ws.sdde.bccr.fi.cr\">&lt;Datos_de_INGC011_CAT_INDICADORECONOMIC&gt;\n" +
            "  &lt;INGC011_CAT_INDICADORECONOMIC&gt;\n" +
            "    &lt;COD_INDICADORINTERNO&gt;318&lt;/COD_INDICADORINTERNO&gt;\n" +
            "    &lt;DES_FECHA&gt;2021-07-22T00:00:00-06:00&lt;/DES_FECHA&gt;\n" +
            "    &lt;NUM_VALOR&gt;620.18000000&lt;/NUM_VALOR&gt;\n" +
            "  &lt;/INGC011_CAT_INDICADORECONOMIC&gt;\n" +
            "&lt;/Datos_de_INGC011_CAT_INDICADORECONOMIC&gt;</string>";

    @Inject
    StringUtil stringUtil;

    @Test
    public void testUtil() {
        Double result = stringUtil.obtenerValor(XML);
        Assertions.assertEquals(620.18, result);
    }
}
