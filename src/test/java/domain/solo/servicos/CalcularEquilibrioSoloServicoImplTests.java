package domain.solo.servicos;

import domain.solo.entidade.Solo;
import domain.solo.entidade.SoloTextura;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalcularEquilibrioSoloServicoImplTests {
    @Test
    public void calculaCTCCmol_comSucesso() {
        Solo solo = new Solo(SoloTextura.CODIG0_ARGILOSO, 8.59, 0.15, 5.76, 1.63, 3.67, 0.0, 5.35 );
        CalcularEquilibrioSoloServicoImpl servico = new CalcularEquilibrioSoloServicoImpl();
        double ctcRetornado = servico.calculaCTCCmol(solo);
        double ctcEsperado = 12.89;

        Assertions.assertEquals(ctcRetornado, ctcEsperado);
    }
}
