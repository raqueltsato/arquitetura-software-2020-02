package domain.solo.servicos;

import domain.solo.entidade.Solo;
import domain.solo.entidade.SoloTextura;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SoloVerificarValorIdealServicoImplTests {

    @Test
    public void verificarValorIdeal_comSoloArgiloso_comSucesso() {
        Solo soloRetornado = SoloVerificarValorIdealServicoImpl.verificarValorIdeal(SoloTextura.CODIG0_ARGILOSO);
        Solo soloEsperado = new Solo(SoloTextura.CODIG0_ARGILOSO, 9, 0.35, 6.0, 1.5, 9.0, 0, 0);

        Assertions.assertEquals(soloRetornado.getTextura(), soloEsperado.getTextura());

    }
}
