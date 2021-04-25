package domain.fosforo.servicos.acoesAposCalcularFosforoAAplicar;

import domain.fosforo.entidade.FonteDeFosforo;
import domain.fosforo.entidade.NutrientesFosforo;
import domain.fosforo.servico.acoesAposCalcularFosforoAAplicar.FosforoForneceCalcio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FosforoForneceCalcioTestes {
    @Test
    public void FosforoForneceCalcio_comSucesso() {
        FosforoForneceCalcio servico = new FosforoForneceCalcio();
        NutrientesFosforo nutrientesRetornado = new NutrientesFosforo();
        BigDecimal calcioRetornado = BigDecimal.valueOf(servico.executarAcao(FonteDeFosforo.SUPERFOSFATO_SIMPLES, 123.95, nutrientesRetornado).getCalcio()).setScale(1, RoundingMode.HALF_UP);
        BigDecimal calcioEsperado = BigDecimal.valueOf(34.7);

        Assertions.assertEquals(calcioEsperado, calcioRetornado);
    }

}
