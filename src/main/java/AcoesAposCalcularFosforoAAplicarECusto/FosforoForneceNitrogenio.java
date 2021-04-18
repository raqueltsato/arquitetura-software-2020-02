package AcoesAposCalcularFosforoAAplicarECusto;

import CorrecaoFosforo.FonteDeFosforo;

public class FosforoForneceNitrogenio implements  AcaoAposCalcularFosforoAAplicarECusto{
    public void executarAcao(FonteDeFosforo fonteDeFosforo, double quantidadeAAplicar){
        double nitrogenio = quantidadeAAplicar * fonteDeFosforo.valor().get(4);
        System.out.println("Fornece " + nitrogenio+" de nitrogenio");
    }
}
