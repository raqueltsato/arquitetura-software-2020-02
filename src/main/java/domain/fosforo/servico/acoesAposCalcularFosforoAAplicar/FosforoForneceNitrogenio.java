package domain.fosforo.servico.acoesAposCalcularFosforoAAplicar;

import domain.fosforo.entidade.FonteDeFosforo;
import domain.fosforo.entidade.NutrientesFosforo;

public class FosforoForneceNitrogenio implements AcaoAposCalcularFosforoAAplicar {
    public NutrientesFosforo executarAcao(FonteDeFosforo fonteDeFosforo, double quantidadeAAplicar, NutrientesFosforo nutrientes){
        nutrientes.setNitrogenio(quantidadeAAplicar * fonteDeFosforo.valor().get(4));
        System.out.println("Fornece " + nutrientes.getNitrogenio()+" de nitrogenio");
        return nutrientes;
    }
}
