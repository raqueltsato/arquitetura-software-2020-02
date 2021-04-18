package AcoesAposCalcularFosforoAAplicarECusto;

import CorrecaoFosforo.FonteDeFosforo;

public class FosforoForneceMagnesio implements  AcaoAposCalcularFosforoAAplicarECusto{
    public void executarAcao(FonteDeFosforo fonteDeFosforo, double quantidadeAAplicar){
        double magnesio = quantidadeAAplicar * fonteDeFosforo.valor().get(2);
        System.out.println("Fornece " + magnesio+" de magnesio");
    }
}