package domain.potassio.servico;

import domain.fosforo.servico.CalcularCustoFosforoServicoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalcularCustoPOtassioServicoImplTestes {
    @Test
    public void calculaCustoDoPotassio_comSucesso() {
        CalcularCustoPotassioServicoImpl servico = new CalcularCustoPotassioServicoImpl();
        BigDecimal custoDoPotassioRetornado = BigDecimal.valueOf(servico.calculaCustoDoPotassio(502.53)).setScale(1, RoundingMode.HALF_UP);
        BigDecimal custoDoPotassioEsperado = BigDecimal.valueOf(1256.3);

        Assertions.assertEquals(custoDoPotassioEsperado, custoDoPotassioRetornado);
    }
}
