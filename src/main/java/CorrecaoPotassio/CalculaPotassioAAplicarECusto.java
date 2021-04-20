package CorrecaoPotassio;

import AcoesAposCalcularPotassioAAplicarECusto.AcaoAposCalcularPotassioAAplicarECusto;

import java.util.List;

public class CalculaPotassioAAplicarECusto {
    private List<AcaoAposCalcularPotassioAAplicarECusto> acaoAposCalcularPotassioAAplicarECusto;

    public CalculaPotassioAAplicarECusto(List<AcaoAposCalcularPotassioAAplicarECusto> acoesAposCalcularPotassioAAplicarECusto) {
        acaoAposCalcularPotassioAAplicarECusto = acoesAposCalcularPotassioAAplicarECusto ;
    }

    public void calcularPotassio (double potassioNoSolo, double ctcCmol, double participacaoDoPotassioDesejadaNaCTC, FonteDePotassio fonteDoPotassio, double precoDaToneladaDoPotassio){
        double fonteDePotassio = fonteDoPotassio.valor().get(0);
        double quantidadeAAplicar = calculoDeQuantidadePotassioAAplicar(potassioNoSolo, ctcCmol, participacaoDoPotassioDesejadaNaCTC, fonteDePotassio);
        double custoDoPotassio = calculaCustoDoPotassio(quantidadeAAplicar, precoDaToneladaDoPotassio);
        imprimeCorrecaoDoPotassio(quantidadeAAplicar, custoDoPotassio);

        this.acaoAposCalcularPotassioAAplicarECusto.forEach(acao -> acao.executarAcao(fonteDoPotassio, quantidadeAAplicar));
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

}
