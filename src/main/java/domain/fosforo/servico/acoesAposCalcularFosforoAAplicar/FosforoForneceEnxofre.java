package domain.fosforo.servico.acoesAposCalcularFosforoAAplicar;

import CorrecaoFosforo.FonteDeFosforo;
import domain.fosforo.entidade.NutrientesFosforo;

public class FosforoForneceEnxofre implements AcaoAposCalcularFosforoAAplicar {

    public NutrientesFosforo executarAcao(FonteDeFosforo fonteDeFosforo, double quantidadeAAplicar, NutrientesFosforo nutrientes){
       nutrientes.setEnxofre(quantidadeAAplicar * fonteDeFosforo.valor().get(1));
        System.out.println("Fornece " + nutrientes.getEnxofre()+" de enxofre");
        return nutrientes;
    }
}
