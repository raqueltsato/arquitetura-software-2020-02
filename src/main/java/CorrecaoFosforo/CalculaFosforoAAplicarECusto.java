package CorrecaoFosforo;

import AcoesAposCalcularFosforoAAplicarECusto.AcaoAposCalcularFosforoAAplicarECusto;

import java.util.List;


public class CalculaFosforoAAplicarECusto {

    private List<AcaoAposCalcularFosforoAAplicarECusto> acaoAposCalcularFosforoAAplicarECusto;


    public CalculaFosforoAAplicarECusto(List<AcaoAposCalcularFosforoAAplicarECusto> acoesAposCalcularFosforoAAplicarECusto) {
        acaoAposCalcularFosforoAAplicarECusto = acoesAposCalcularFosforoAAplicarECusto;
    }

    public void calcularFosforo(double  fosforoNoSolo, double fosforoAAtingir, double eficienciaDoFosforo, FonteDeFosforo fonteDoFosforo, double precodaToneladaDoFosforo ) {
        double fonteDeFosforo = fonteDoFosforo.valor().get(0);
        double quantidadeAplicar = calculoDeQuantidadeFosforoAAplicar(fosforoNoSolo, fosforoAAtingir, eficienciaDoFosforo, fonteDeFosforo);
        double custoDoFosforo = calculaCustoDoFosforo(quantidadeAplicar, precodaToneladaDoFosforo);
        imprimeCorrecaoDoFosforo(quantidadeAplicar, custoDoFosforo);

        this.acaoAposCalcularFosforoAAplicarECusto.forEach(acao -> acao.executarAcao(fonteDoFosforo, quantidadeAplicar));
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

    public double calculaCustoDoFosforo(double fosforoAAplicar, double preco){ return (fosforoAAplicar/1000) * preco; }

    public void imprimeCorrecaoDoFosforo(double fosforoAAplicar, double custoDoFosforo) {
        System.out.println("Quantidade de Fosforo a aplicar: " + fosforoAAplicar + " kg/hectare");
        System.out.println("O custo é de: R$ " + custoDoFosforo + " /ha");
    }
}
