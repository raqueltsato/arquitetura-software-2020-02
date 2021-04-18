import AcoesAposCalcularFosforoAAplicarECusto.FosforoForneceCalcio;
import AcoesAposCalcularFosforoAAplicarECusto.FosforoForneceEnxofre;
import AcoesAposCalcularFosforoAAplicarECusto.FosforoForneceMagnesio;
import AcoesAposCalcularFosforoAAplicarECusto.FosforoForneceNitrogenio;
import CorrecaoFosforo.CalculaFosforoAAplicarECusto;
import CorrecaoFosforo.FonteDeFosforo;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        Solo solo = new Solo();
        Solo valorIdealSolo = new Solo();
        CalculaEquilibrioSolo calculaEquilibrioSolo = new CalculaEquilibrioSolo();
        solo = calculaEquilibrioSolo.recebeDadosDoSolo("1", 8.59, 0.15, 5.76, 1.63, 3.67, 0.0, 5.35 );
        valorIdealSolo = solo.verificaValorIdeal();
        double scmol = calculaEquilibrioSolo.calculaSCmol(solo);
        double ctcCmol = calculaEquilibrioSolo.calculaCTCCmol(solo);
        double vPercentual = calculaEquilibrioSolo.calculaVPercentual(solo);
        double moPercentual = calculaEquilibrioSolo.calculaMOPercentual(30.7);
        double carbono = calculaEquilibrioSolo.calculaCarbono(moPercentual);

        calculaEquilibrioSolo.imprimeTabela(solo, valorIdealSolo, scmol, ctcCmol, vPercentual, moPercentual, carbono);

        double fosforoAAtingir = 12;
        double eficienciaDoFosforo = 70;
        double precoDaToneladaDoFosforo = 1260.00;
        CalculaFosforoAAplicarECusto calculaFosforoAAplicarECusto = new CalculaFosforoAAplicarECusto(Arrays.asList(new FosforoForneceEnxofre(), new FosforoForneceMagnesio(),
                                                                                                                    new FosforoForneceCalcio(), new FosforoForneceNitrogenio()));
        calculaFosforoAAplicarECusto.calcularFosforo(solo.getFosforo(), fosforoAAtingir, eficienciaDoFosforo, FonteDeFosforo.SUPERFOSFATO_SIMPLES, precoDaToneladaDoFosforo);


        double participacaoDoPotassioDesejadaNaCTC = 3.0;
        double fonteDePotassio = FonteDePotassio.CLORETO_DE_POTASSIO.valor();
        double precoDaToneladaDoPotassio = 2500.00;
        calculaEquilibrioSolo.recebeDadosParaRecuperarPotassio(solo, ctcCmol, participacaoDoPotassioDesejadaNaCTC, fonteDePotassio, precoDaToneladaDoPotassio);

    }




}
