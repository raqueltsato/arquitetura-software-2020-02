package domain.potassio.servico;

import domain.potassio.entidade.NutrientesPotassio;
import domain.potassio.servico.AcoesAposCalcularPotassioAAplicar.AcaoAposCalcularPotassioAAplicar;
import domain.potassio.entidade.FonteDePotassio;
import domain.potassio.servico.AcoesAposCalcularPotassioAAplicar.PotassioForneceEnxofre;
import domain.potassio.servico.AcoesAposCalcularPotassioAAplicar.PotassioForneceMagnesio;

import java.util.Arrays;
import java.util.List;



public class CalcularPotassioAAplicarServicoImpl {
    private List<AcaoAposCalcularPotassioAAplicar> acaoAposCalcularPotassioAAplicar = Arrays.asList(new PotassioForneceEnxofre(), new PotassioForneceMagnesio());
    double participacaoDoPotassioDesejadaNaCTC = 3.0;
    private NutrientesPotassio nutrientesPotassio = new NutrientesPotassio();
    private double quantidadeAAplicar;

    public double getQuantidadeAplicar() {
        return quantidadeAAplicar;
    }

    public NutrientesPotassio getNutrientes() {
        return this.nutrientesPotassio;
    }

    public void calcularPotassio (double potassioNoSolo, double ctcCmol, FonteDePotassio fonteDoPotassio){
        double fonteDePotassio = fonteDoPotassio.valor().get(0);
        quantidadeAAplicar = calculoDeQuantidadePotassioAAplicar(potassioNoSolo, ctcCmol, participacaoDoPotassioDesejadaNaCTC, fonteDePotassio);
        //imprimeCorrecaoDoPotassio(quantidadeAAplicar);

        this.acaoAposCalcularPotassioAAplicar.forEach(acao ->
                nutrientesPotassio = acao.executarAcao(fonteDoPotassio, quantidadeAAplicar, nutrientesPotassio));
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


    /*public void imprimeCorrecaoDoPotassio(double quantidadeAplicar) {
        System.out.println("\nQuantidade de Potassio a aplicar: "+quantidadeAplicar+" kg/hectare");
    }*/

}
