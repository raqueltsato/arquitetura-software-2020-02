package AcoesAposCalcularFosforoAAplicarECusto;

import CorrecaoFosforo.FonteDeFosforo;

public class FosforoForneceCalcio implements  AcaoAposCalcularFosforoAAplicarECusto{
    public void executarAcao(FonteDeFosforo fonteDeFosforo, double quantidadeAAplicar){
        double calcio = quantidadeAAplicar * fonteDeFosforo.valor().get(3);
        System.out.println("Fornece " + calcio+" de calcio");
    }
}