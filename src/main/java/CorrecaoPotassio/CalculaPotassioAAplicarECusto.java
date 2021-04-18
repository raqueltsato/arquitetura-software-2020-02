package CorrecaoPotassio;

import AcoesAposCalcularPotassioAAplicarECusto.AcaoAposCalcularPotassioAAplicarECusto;

import java.util.ArrayList;
import java.util.List;

public class CalculaPotassioAAplicarECusto {
    private List<AcaoAposCalcularPotassioAAplicarECusto> acaoAposCalcularPotassioAAplicarECusto;

    public CalculaPotassioAAplicarECusto(List<AcaoAposCalcularPotassioAAplicarECusto> acoesAposCalcularPotassioAAplicarECusto) {
        acaoAposCalcularPotassioAAplicarECusto = acoesAposCalcularPotassioAAplicarECusto ;
    }

    public void calcularPotassio (double potassioNoSolo, double ctcCmol, double participacaoDoPotassioDesejadaNaCTC, FonteDePotassio fonteDoPotassio, double precoDaToneladaDoPotassio){
        //ArrayList<Double> quantidadeAAplicarPotassioEOutrosNutrientes = new ArrayList<Double>();
        double fonteDePotassio = fonteDoPotassio.valor().get(0);
        double quantidadeAAplicar = calculoDeQuantidadePotassioAAplicar(potassioNoSolo, ctcCmol, participacaoDoPotassioDesejadaNaCTC, fonteDePotassio);
        double custoDoPotassio = calculaCustoDoPotassio(quantidadeAAplicar, precoDaToneladaDoPotassio);
        imprimeCorrecaoDoPotassio(quantidadeAAplicar, custoDoPotassio);

        this.acaoAposCalcularPotassioAAplicarECusto.forEach(acao -> acao.executarAcao(fonteDoPotassio, quantidadeAAplicar));
        //quantidadeAAplicarPotassioEOutrosNutrientes = calculoDeQuantidadePotassioAAplicarEOutrosNutrientes(potassioNoSolo, ctcCmol, participacaoDoPotassioDesejadaNaCTC, fonteDePotassio);
        //double custoDoPotassio = calculaCustoDoPotassio(quantidadeAAplicarPotassioEOutrosNutrientes.get(0), fonteDePotassio, precoDaToneladaDoPotassio);
        //imprimeCorrecaoDoPotassio(quantidadeAAplicarPotassioEOutrosNutrientes, custoDoPotassio);
    }

    public double calculoDeQuantidadePotassioAAplicar(double potassioNoSolo, double ctcCMol, double porcentagemPotassioDesejado, double fonteDePotassio){
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
    public double calculaCustoDoPotassio(double valorDoPotassio, double precoDoPotassio) {
        return valorDoPotassio /1000 * precoDoPotassio;

    }

    public void imprimeCorrecaoDoPotassio(double quantidadeAplicar, double custoDoPotassio) {
        System.out.println("\nQuantidade de Potassio a aplicar: "+quantidadeAplicar+" kg/hectare");
        System.out.println("Custo do potassio é de: " +custoDoPotassio);
    }

    /*public ArrayList<Double> calculoDeQuantidadePotassioAAplicarEOutrosNutrientes(double potassioNoSolo, double ctcCMol, double porcentPotassioDesejado, double fonteDePotassio){
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
    }*/

    /*private ArrayList<Double> verificaNutrientes (double fonteDePotassio, double valorDoPotassio) {
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

    */


}
