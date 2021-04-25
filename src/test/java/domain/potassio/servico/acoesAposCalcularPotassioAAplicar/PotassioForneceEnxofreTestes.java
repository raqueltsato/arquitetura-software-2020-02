package domain.potassio.servico.acoesAposCalcularPotassioAAplicar;

import domain.potassio.entidade.FonteDePotassio;
import domain.potassio.entidade.NutrientesPotassio;
import domain.potassio.servico.AcoesAposCalcularPotassioAAplicar.PotassioForneceEnxofre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PotassioForneceEnxofreTestes {
    @Test
    public void PotassioForneceEnxofre_comSucesso() {
        PotassioForneceEnxofre servico = new PotassioForneceEnxofre();
        NutrientesPotassio nutrientesRetornado = new NutrientesPotassio();
        BigDecimal enxofreRetornado = BigDecimal.valueOf(servico.executarAcao(FonteDePotassio.SULFATO_DE_POTASSIO, 502.53, nutrientesRetornado).getEnxofre()).setScale(2, RoundingMode.HALF_UP);
        BigDecimal enxofreEsperado = BigDecimal.valueOf(85.43);

        Assertions.assertEquals(enxofreEsperado, enxofreRetornado);
    }
}
