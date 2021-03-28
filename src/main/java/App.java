public class App {

    public static void main(String[] args) {
        Solo solo = new Solo();
        Solo valorIdealSolo = new Solo();
        CalculaEquilibrioSolo memoriaDeCalculo = new CalculaEquilibrioSolo();
        solo = memoriaDeCalculo.recebeDadosDoSolo();
        valorIdealSolo = solo.verificaValorIdeal();
        double scmol = memoriaDeCalculo.calculaSCmol(solo);
        double ctcCmol = memoriaDeCalculo.calculaCTCCmol(solo);
        double vPercentual = memoriaDeCalculo.calculaVPercentual(solo);
        double moPercentual = memoriaDeCalculo.recebeECalculaMOPercentual();
        double carbono = memoriaDeCalculo.calculaCarbono(moPercentual);

        memoriaDeCalculo.imprimeTabela(solo, valorIdealSolo, scmol, ctcCmol, vPercentual, moPercentual, carbono);

        double fosfatoAAplicar = memoriaDeCalculo.quantidadeAplicarFosforo(solo);
        System.out.println("Quantidade de Fosfato a aplicar: " +fosfatoAAplicar+ " kg/hectare");


    }


}
