package domain.potassio.servico;

import domain.potassio.entidade.FonteDePotassio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalcularPotassioAAplicarImplTestes {
    @Test
    public void calcularPotassio_comSucesso() {
        CalcularPotassioAAplicarServicoImpl servico = new CalcularPotassioAAplicarServicoImpl();
        servico.calcularPotassio(0.15, 12.89, FonteDePotassio.SULFATO_DE_POTASSIO);
        BigDecimal quantidadeDePotassioAAplicarEsperado = BigDecimal.valueOf(502.53);
        BigDecimal quantidadeDePotassioAAplicarRetornado = BigDecimal.valueOf(servico.getQuantidadeAplicar()).setScale(2, RoundingMode.HALF_UP);

        Assertions.assertEquals(quantidadeDePotassioAAplicarEsperado, quantidadeDePotassioAAplicarRetornado);
    }
}
