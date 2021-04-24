package domain.fosforo.servico;

import domain.fosforo.entidade.NutrientesFosforo;
import domain.fosforo.servico.acoesAposCalcularFosforoAAplicar.*;
import domain.fosforo.entidade.FonteDeFosforo;

import java.util.Arrays;
import java.util.List;


public class CalcularFosforoAaplicarServicoImpl {

    private List<AcaoAposCalcularFosforoAAplicar> acaoAposCalcularFosforoAAplicarECusto = Arrays.asList(new FosforoForneceEnxofre(), new FosforoForneceMagnesio(),
            new FosforoForneceCalcio(), new FosforoForneceNitrogenio());
    double fosforoAAtingir = 12;
    double eficienciaDoFosforo = 70;
    private double quantidadeAplicar;
    private NutrientesFosforo nutrientesFosforo = new NutrientesFosforo();

    public double getQuantidadeAplicar() {
        return quantidadeAplicar;
    }
    public NutrientesFosforo getNutrientes() {
        return this.nutrientesFosforo;
    }


    public void calcularFosforo(double  fosforoNoSolo, FonteDeFosforo fonteDoFosforo) {

        double fonteDeFosforo = fonteDoFosforo.valor().get(0);
        quantidadeAplicar = calculoDeQuantidadeFosforoAAplicar(fosforoNoSolo, fosforoAAtingir, eficienciaDoFosforo, fonteDeFosforo);
        imprimeCorrecaoDoFosforo(quantidadeAplicar);

        this.acaoAposCalcularFosforoAAplicarECusto.forEach(acao ->
                nutrientesFosforo = acao.executarAcao(fonteDoFosforo, quantidadeAplicar, nutrientesFosforo));
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

    public void imprimeCorrecaoDoFosforo(double fosforoAAplicar) {
        System.out.println("Quantidade de Fosforo a aplicar: " + fosforoAAplicar + " kg/hectare");
    }
}
