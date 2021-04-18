package AcoesAposCalcularPotassioAAplicarECusto;

import CorrecaoPotassio.FonteDePotassio;

public class PotassioForneceEnxofre implements AcaoAposCalcularPotassioAAplicarECusto{

    public void executarAcao(FonteDePotassio fonteDePotassio, double quantidadeAAplicar){
        double enxofre = quantidadeAAplicar * fonteDePotassio.valor().get(1);
        System.out.println("Fornece " + enxofre+" de enxofre");
    }
}
