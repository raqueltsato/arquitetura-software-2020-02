package AcoesAposCalcularPotassioAAplicarECusto;

import CorrecaoPotassio.FonteDePotassio;

public class PotassioForneceMagnesio implements AcaoAposCalcularPotassioAAplicarECusto{

    public void executarAcao(FonteDePotassio fonteDePotassio, double quantidadeAAplicar){
        double magnesio = quantidadeAAplicar * fonteDePotassio.valor().get(2);
        System.out.println("Fornece " + magnesio+" de magnesio");
    }
}
