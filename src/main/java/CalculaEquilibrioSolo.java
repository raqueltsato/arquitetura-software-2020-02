import java.util.ArrayList;
import java.util.Scanner;

public class CalculaEquilibrioSolo {

    public double calculaSCmol(Solo solo) {
        return solo.getPotassio()+solo.getCalcio()+solo.getMagnesio();
    }

    public double calculaCTCCmol(Solo solo) {
        return calculaSCmol(solo)+solo.getHal();
    }

    public double calculaVPercentual(Solo solo) {
        return 100 * calculaSCmol(solo)/calculaCTCCmol(solo);
    }

    //Baseado no código disponível em: https://github.com/gabrielcostasilva/sa-soilcorrection/blob/main/src/main/java/edu/utfpr/cp/dacom/sa/soilcorrection/EquilibrioCorrecaoCTC.java
    public double calculaMOPercentual(double mo) {
        if (mo > 0) {
            return mo / 10;
        }
        return 0.0;

    }
    //Baseado no código disponível em: https://github.com/gabrielcostasilva/sa-soilcorrection/blob/main/src/main/java/edu/utfpr/cp/dacom/sa/soilcorrection/EquilibrioCorrecaoCTC.java
    public double calculaCarbono(double moPercentual) {

        if (moPercentual > 0) {
            return moPercentual / 1.72 * 10;
        }
        return 0.0;
    }


    public Solo recebeDadosDoSolo(String textura, double fosforo, double potassio, double calcio, double magnesio, double enxofre, double aluminio, double hAl) {

        Solo solo = new Solo();

        solo.setTextura(textura);

        solo.setFosforo(fosforo);

        solo.setPotassio(potassio);

        solo.setCalcio(calcio);

        solo.setMagnesio(magnesio);

        solo.setEnxofre(enxofre);

        solo.setAluminio(aluminio);

        solo.setHal(hAl);

        return solo;
    }


    public void imprimeTabela(Solo solo, Solo valorIdealSolo, double scmol, double ctcCmol, double vPercentual, double moPercentual, double carbono){

        System.out.println("\n------------ TABELA DE VALORES-------------");
        System.out.println("\n          VALOR COLETADO          VALOR IDEAL");
        System.out.println("Fosforo:     "+solo.getFosforo()+"                     "+ valorIdealSolo.getFosforo()+"\n");
        System.out.println("Potássio:    "+solo.getPotassio()+"                     "+ valorIdealSolo.getPotassio()+"\n");
        System.out.println("Cálcio:      "+solo.getCalcio()+"                     "+ valorIdealSolo.getCalcio()+"\n");
        System.out.println("Magnésio:    "+solo.getMagnesio()+"                     "+ valorIdealSolo.getMagnesio()+"\n");
        System.out.println("Enxofre:     "+solo.getEnxofre()+"                     "+ valorIdealSolo.getEnxofre()+"\n");
        System.out.println("Alumínio:    "+solo.getAluminio()+"                      "+ valorIdealSolo.getAluminio()+"\n");
        System.out.println("H+Al:        "+solo.getHal()+"                     "+ valorIdealSolo.getHal()+"\n");
        System.out.println("\n--------------------------------------------\n");
        System.out.println("SCmol:       "+ scmol);
        System.out.println("CTCCmol:     "+ ctcCmol);
        System.out.println("V % Atual:   "+ vPercentual);

        System.out.println("\n--------------------------------------------\n");
        System.out.println("MO %:        "+  moPercentual);
        System.out.println("Carbono %:        "+  carbono);

    }

    public void recebeDadosParaRecuperacaoDoFosforo(Solo solo, double fosforoAAtingir, double eficienciaDoFosforo, double fonteDoFosforo, double precodaToneladaDoFosforo) {
        double quantidadeAplicar = calculoDeQuantidadeFosforoAAplicar(solo.getFosforo(), fosforoAAtingir, eficienciaDoFosforo, fonteDoFosforo);
        double custoDoFosforo = calculaCustoDoFosforo(quantidadeAplicar, precodaToneladaDoFosforo);
        imprimeCorrecaoDoFosforo(quantidadeAplicar, custoDoFosforo);

    }

    private double calculoDeQuantidadeFosforoAAplicar(double fosforoNoSolo, double fosforoAAtingir, double eficiencia, double fonteDeFosforo) {

        eficiencia = eficiencia/100;
        if (eficiencia == 0.00) {
            return 0.00;
        }
        double necessidadeFosforoAAdicionar = necessidadeFosforoAAdicionar(fosforoAAtingir, fosforoNoSolo);
        double p2O5 = transformaNecessidadeEmP2O5(necessidadeFosforoAAdicionar);
        double necessidadeDeP2O5 = necessidadeP2O5(p2O5, eficiencia);
        double quantidadeAAplicar = necessidadeDeP2O5/fonteDeFosforo;
        return quantidadeAAplicar;
    }

    private double necessidadeFosforoAAdicionar(double fosforoAAtingir, double fosforoNoSolo) {
        return fosforoAAtingir - fosforoNoSolo;
    }
    private double transformaNecessidadeEmP2O5 (double necessidadeFosforo) {
        return necessidadeFosforo*2*2.29;
    }

    private double necessidadeP2O5 (double p2O5, double eficiencia) {
        return p2O5/eficiencia*100;
    }

    public double calculaCustoDoFosforo(double fosforoAAplicar, double preco){

        return (fosforoAAplicar/1000) * preco;
    }

    public void imprimeCorrecaoDoFosforo(double fosforoAAplicar, double custoDoFosforo){
        System.out.println("Quantidade de Fosfato a aplicar:           "+fosforoAAplicar+ " kg/hectare");
        System.out.println("O custo é de:                              R$ " +custoDoFosforo+" /ha");
    }

    /*---------------------*/
    public void recebeDadosParaRecuperarPotassio(Solo solo, double ctcCmol, double participacaoDoPotassioDesejadaNaCTC, double fonteDePotassio, double precoDaToneladaDoPotassio) {
        double potassioNoSolo = solo.getPotassio();

        ArrayList<Double> quantidadeAAplicarPotassioEOutrosNutrientes = new ArrayList<Double>();
        quantidadeAAplicarPotassioEOutrosNutrientes = calculoDeQuantidadePotassioAAplicarEOutrosNutrientes(potassioNoSolo, ctcCmol, participacaoDoPotassioDesejadaNaCTC, fonteDePotassio);

        double custoDoPotassio = calculaCustoDoPotassio(quantidadeAAplicarPotassioEOutrosNutrientes.get(0), fonteDePotassio, precoDaToneladaDoPotassio);

        imprimeCorrecaoDoPotassio(quantidadeAAplicarPotassioEOutrosNutrientes, custoDoPotassio);
    }



    public ArrayList<Double> calculoDeQuantidadePotassioAAplicarEOutrosNutrientes(double potassioNoSolo, double ctcCMol, double porcentPotassioDesejado, double fonteDePotassio){
        ArrayList<Double> nutrientes = new ArrayList<Double>();
        ArrayList<Double> potassioENutrientes = new ArrayList<Double>();
        double quantidadeAplicarPotassio = calculaQuantidadeDePotassioAAplicar(potassioNoSolo, ctcCMol, porcentPotassioDesejado, fonteDePotassio);
        potassioENutrientes.add(quantidadeAplicarPotassio);
        nutrientes = verificaNutrientes(fonteDePotassio, quantidadeAplicarPotassio);
        potassioENutrientes.add(nutrientes.get(0));
        potassioENutrientes.add(nutrientes.get(1));

        return potassioENutrientes;
    }

    private double calculaQuantidadeDePotassioAAplicar(double potassioNoSolo, double ctcCMol, double porcentagemPotassioDesejado, double fonteDePotassio) {
        double potassio = potassioNoSolo * porcentagemPotassioDesejado;
        double participacaoExistentedePotassio =  participacaoExistentedoPotassio(potassioNoSolo, ctcCMol);
        double necessidadeDeKaAdicionar = necessidadeDeKAdicionar(potassio, participacaoExistentedePotassio, potassioNoSolo);
        double transformaPotassioEmMgDm3 = transformaCmolCDm3EmKgPorHectare(necessidadeDeKaAdicionar);

        return transformaPotassioEmMgDm3*100/0.85/fonteDePotassio;
    }

    private double participacaoExistentedoPotassio (double potassioNoSolo, double ctcCMol) {
        return potassioNoSolo/ctcCMol*100;
    }

    private double necessidadeDeKAdicionar(double potassio, double participacaoExistenteDePotassio, double potassioNoSolo) {
        return (potassio/participacaoExistenteDePotassio)-potassioNoSolo;
    }

    private double transformaCmolCDm3EmKgPorHectare (double necessidadeDeKAAdicionar) {
        return necessidadeDeKAAdicionar*39.1*10*2*1.2;
    }

    private ArrayList<Double> verificaNutrientes (double fonteDePotassio, double valorDoPotassio) {
        ArrayList<Double> enxofreMagnesio = new ArrayList<Double>();

        int fonte = (int) fonteDePotassio;
        switch (fonte) {
            case 52:
                enxofreMagnesio.add(valorDoPotassio*0.17);
                enxofreMagnesio.add(0.0);
                break;
            case 22:
                enxofreMagnesio.add(valorDoPotassio*0.22);
                enxofreMagnesio.add(valorDoPotassio*0.18);
                break;
            default:
                enxofreMagnesio.add(0.0);
                enxofreMagnesio.add(0.0);
                break;
        }

        return enxofreMagnesio;

    }

    public void imprimeCorrecaoDoPotassio(ArrayList<Double> potassioENutrientes, double custoDoPotassio) {

        System.out.println("\nCusto R$/ha do potassio:   "+ custoDoPotassio);
        System.out.println("\nVeja abaixo a quantidade de outros nutrientes que esta fonte também oferece:\n");
        System.out.println("\nQuantidade a aplicar do potássio  ---      Kg/ha de enxofre       ---          kg/ha de magnésio ");

        potassioENutrientes.forEach(quantidadeNutriente -> {
            System.out.print("          "+ quantidadeNutriente+ "             ");
        });

    }

    public double calculaCustoDoPotassio(double valorDoPotassio, double fonteDoPotassio, double precoDoPotassio) {
        if (fonteDoPotassio != (44.0)){
            return (valorDoPotassio * 2.42) /1000 * precoDoPotassio/2.42;
        }
        return 0.0;
    }

}
