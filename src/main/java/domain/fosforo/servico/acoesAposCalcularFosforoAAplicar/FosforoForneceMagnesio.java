package domain.fosforo.servico.acoesAposCalcularFosforoAAplicar;

import domain.fosforo.entidade.FonteDeFosforo;
import domain.fosforo.entidade.NutrientesFosforo;

public class FosforoForneceMagnesio implements AcaoAposCalcularFosforoAAplicar {
    public NutrientesFosforo executarAcao(FonteDeFosforo fonteDeFosforo, double quantidadeAAplicar, NutrientesFosforo nutrientes){
       nutrientes.setMagnesio(quantidadeAAplicar * fonteDeFosforo.valor().get(2));
        System.out.println("Fornece " + nutrientes.getMagnesio()+" de magnesio");
        return nutrientes;
    }
}