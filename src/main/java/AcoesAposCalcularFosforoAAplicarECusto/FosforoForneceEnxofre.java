package AcoesAposCalcularFosforoAAplicarECusto;

import CorrecaoFosforo.FonteDeFosforo;

public class FosforoForneceEnxofre implements AcaoAposCalcularFosforoAAplicarECusto {

    public void executarAcao(FonteDeFosforo fonteDeFosforo, double quantidadeAAplicar){
        double enxofre = quantidadeAAplicar * fonteDeFosforo.valor().get(1);
        System.out.println("Fornece " + enxofre+" de enxofre");
    }
}
