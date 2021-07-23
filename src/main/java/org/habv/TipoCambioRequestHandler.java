package org.habv;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.function.aws.MicronautRequestHandler;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Introspected
public class TipoCambioRequestHandler extends MicronautRequestHandler<TipoCambioRequest, TipoCambioResponse> {

    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern(BccrConfig.PATRON_FECHA);
    @Inject
    private TipoCambioClient tipoCambioClient;
    @Inject
    private BccrConfig bccrConfig;
    @Inject
    private StringUtil stringUtil;

    @Override
    public TipoCambioResponse execute(TipoCambioRequest input) {
        Double compra = obtenerIndicador(
                input.getFecha(),
                BccrConfig.DOLAR_COMPRA);
        Double venta = obtenerIndicador(
                input.getFecha(),
                BccrConfig.DOLAR_VENTA);
        TipoCambioResponse tipoCambioResponse = new TipoCambioResponse();
        tipoCambioResponse.setCompra(compra);
        tipoCambioResponse.setVenta(venta);
        return tipoCambioResponse;
    }

    private Double obtenerIndicador(LocalDate fecha, String indicador) {
        String response = tipoCambioClient.obtenerIndicadorEconomico(
                indicador,
                fecha.format(DTF),
                fecha.format(DTF),
                bccrConfig.getNombre(),
                "N",
                bccrConfig.getCorreo(),
                bccrConfig.getToken());
        return stringUtil.obtenerValor(response);
    }
}
