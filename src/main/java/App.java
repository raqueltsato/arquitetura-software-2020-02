import java.util.ArrayList;

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
        double moPercentual = calculaEquilibrioSolo.recebeECalculaMOPercentual();
        double carbono = calculaEquilibrioSolo.calculaCarbono(moPercentual);

        calculaEquilibrioSolo.imprimeTabela(solo, valorIdealSolo, scmol, ctcCmol, vPercentual, moPercentual, carbono);

        calculaEquilibrioSolo.recebeDadosParaRecuperacaoDoFosforo(solo);
        calculaEquilibrioSolo.recebeDadosParaRecuperarPotassio(solo, ctcCmol);

    }




}
