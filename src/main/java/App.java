import AcoesAposCalcularPotassioAAplicarECusto.PotassioForneceEnxofre;
import AcoesAposCalcularPotassioAAplicarECusto.PotassioForneceMagnesio;
import domain.fosforo.servico.CalcularCustoFosforoServicoImpl;
import domain.fosforo.servico.CalcularFosforoAaplicarServicoImpl;
import CorrecaoFosforo.FonteDeFosforo;
import CorrecaoPotassio.CalculaPotassioAAplicarECusto;
import CorrecaoPotassio.FonteDePotassio;
import domain.solo.entidade.Solo;
import domain.solo.entidade.SoloTextura;
import domain.solo.servicos.CalcularEquilibrioSoloServicoImpl;
import domain.solo.servicos.SoloVerificarValorIdealServicoImpl;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        Solo solo = new Solo(SoloTextura.CODIG0_ARGILOSO, 8.59, 0.15, 5.76, 1.63, 3.67, 0.0, 5.35 );

        Solo valorIdealSolo = SoloVerificarValorIdealServicoImpl.verificarValorIdeal(solo.getTextura());

        CalcularEquilibrioSoloServicoImpl calculaEquilibrioSolo = new CalcularEquilibrioSoloServicoImpl();

        calculaEquilibrioSolo.imprimeTabela(solo, valorIdealSolo);

        CalcularFosforoAaplicarServicoImpl calculaFosforoAAplicar = new CalcularFosforoAaplicarServicoImpl();
        calculaFosforoAAplicar.calcularFosforo(solo.getFosforo(), FonteDeFosforo.SUPERFOSFATO_SIMPLES);

        CalcularCustoFosforoServicoImpl calcularCustoFosforoServico = new CalcularCustoFosforoServicoImpl();

        calcularCustoFosforoServico.calculaCustoDoFosforo(calculaFosforoAAplicar.getQuantidadeAplicar());

        double participacaoDoPotassioDesejadaNaCTC = 3.0;
        double precoDaToneladaDoPotassio = 2500.00;
        CalculaPotassioAAplicarECusto calculaPotassioAAplicarECusto = new CalculaPotassioAAplicarECusto(Arrays.asList(new PotassioForneceEnxofre(), new PotassioForneceMagnesio()));
        calculaPotassioAAplicarECusto.calcularPotassio(solo.getPotassio(), calculaEquilibrioSolo.calculaCTCCmol(solo), participacaoDoPotassioDesejadaNaCTC, FonteDePotassio.CLORETO_DE_POTASSIO, precoDaToneladaDoPotassio);

    }




}
