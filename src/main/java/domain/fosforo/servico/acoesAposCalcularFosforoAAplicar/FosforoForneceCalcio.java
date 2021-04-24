package domain.fosforo.servico.acoesAposCalcularFosforoAAplicar;

import domain.fosforo.entidade.FonteDeFosforo;
import domain.fosforo.entidade.NutrientesFosforo;

public class FosforoForneceCalcio implements AcaoAposCalcularFosforoAAplicar {
    public NutrientesFosforo executarAcao(FonteDeFosforo fonteDeFosforo, double quantidadeAAplicar, NutrientesFosforo nutrientes){
        nutrientes.setCalcio(quantidadeAAplicar * fonteDeFosforo.valor().get(3));
        System.out.println("Fornece " + nutrientes.getCalcio()+" de calcio");
        return nutrientes;
    }
}