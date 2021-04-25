package domain.fosforo.servicos;

import domain.fosforo.entidade.FonteDeFosforo;
import domain.fosforo.servico.CalcularFosforoAaplicarServicoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalcularFosforoAaplicarServicoImplTestes {
    @Test
    public void calcularFosforo_comSucesso() {
        CalcularFosforoAaplicarServicoImpl servico = new CalcularFosforoAaplicarServicoImpl();
        servico.calcularFosforo(8.59, FonteDeFosforo.SUPERFOSFATO_SIMPLES);
        BigDecimal quantidadeDeFosforoAAplicarEsperado = BigDecimal.valueOf(123.95);
        BigDecimal quantidadeDeFosforoAAplicarRetornado = BigDecimal.valueOf(servico.getQuantidadeAplicar()).setScale(2, RoundingMode.HALF_UP);

        Assertions.assertEquals(quantidadeDeFosforoAAplicarEsperado, quantidadeDeFosforoAAplicarRetornado);

    }
}
