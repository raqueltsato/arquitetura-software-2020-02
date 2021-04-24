import AcoesAposCalcularFosforoAAplicarECusto.FosforoForneceCalcio;
import AcoesAposCalcularFosforoAAplicarECusto.FosforoForneceEnxofre;
import AcoesAposCalcularFosforoAAplicarECusto.FosforoForneceMagnesio;
import AcoesAposCalcularFosforoAAplicarECusto.FosforoForneceNitrogenio;
import AcoesAposCalcularPotassioAAplicarECusto.PotassioForneceEnxofre;
import AcoesAposCalcularPotassioAAplicarECusto.PotassioForneceMagnesio;
import CorrecaoFosforo.CalculaFosforoAAplicarECusto;
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

        double fosforoAAtingir = 12;
        double eficienciaDoFosforo = 70;
        double precoDaToneladaDoFosforo = 1260.00;
        CalculaFosforoAAplicarECusto calculaFosforoAAplicarECusto = new CalculaFosforoAAplicarECusto(Arrays.asList(new FosforoForneceEnxofre(), new FosforoForneceMagnesio(),
                                                                                                                    new FosforoForneceCalcio(), new FosforoForneceNitrogenio()));
        calculaFosforoAAplicarECusto.calcularFosforo(solo.getFosforo(), fosforoAAtingir, eficienciaDoFosforo, FonteDeFosforo.SUPERFOSFATO_SIMPLES, precoDaToneladaDoFosforo);

        double participacaoDoPotassioDesejadaNaCTC = 3.0;
        double precoDaToneladaDoPotassio = 2500.00;
        CalculaPotassioAAplicarECusto calculaPotassioAAplicarECusto = new CalculaPotassioAAplicarECusto(Arrays.asList(new PotassioForneceEnxofre(), new PotassioForneceMagnesio()));
        calculaPotassioAAplicarECusto.calcularPotassio(solo.getPotassio(), calculaEquilibrioSolo.calculaCTCCmol(solo), participacaoDoPotassioDesejadaNaCTC, FonteDePotassio.CLORETO_DE_POTASSIO, precoDaToneladaDoPotassio);

    }




}
