package domain.fosforo.servicos;

import domain.fosforo.servico.CalcularCustoFosforoServicoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalcularCustoFosforoServicoImplTestes {
    @Test
    public void calculaCustoDoFosforo_comSucesso() {
        CalcularCustoFosforoServicoImpl servico = new CalcularCustoFosforoServicoImpl();
        BigDecimal custoDoFosforRetornado = BigDecimal.valueOf(servico.calculaCustoDoFosforo(123.95)).setScale(2, RoundingMode.HALF_UP);
        BigDecimal custoDoFosforoEsperado = BigDecimal.valueOf(156.18);

        Assertions.assertEquals(custoDoFosforoEsperado, custoDoFosforRetornado);
    }
}
