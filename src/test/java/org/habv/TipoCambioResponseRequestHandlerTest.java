package org.habv;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TipoCambioResponseRequestHandlerTest {

    private static TipoCambioRequestHandler tipoCambioRequestHandler;

    @BeforeAll
    public static void setupServer() {
        tipoCambioRequestHandler = new TipoCambioRequestHandler();
    }

    @AfterAll
    public static void stopServer() {
        if (tipoCambioRequestHandler != null) {
            tipoCambioRequestHandler.getApplicationContext().close();
        }
    }

    @Test
    public void testHandler() {
        TipoCambioRequest tipoCambioRequest = new TipoCambioRequest();
        tipoCambioRequest.setFecha(LocalDate.of(2021, 7, 22));

        TipoCambioResponse tipoCambioResponse = tipoCambioRequestHandler.execute(tipoCambioRequest);
        assertEquals(614.45, tipoCambioResponse.getCompra());
        assertEquals(620.18, tipoCambioResponse.getVenta());
    }
}
