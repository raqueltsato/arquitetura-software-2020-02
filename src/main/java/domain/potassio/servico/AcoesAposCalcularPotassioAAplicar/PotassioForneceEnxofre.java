package domain.potassio.servico.AcoesAposCalcularPotassioAAplicar;

import domain.potassio.entidade.FonteDePotassio;
import domain.potassio.entidade.NutrientesPotassio;

public class PotassioForneceEnxofre implements AcaoAposCalcularPotassioAAplicar {

    public NutrientesPotassio executarAcao(FonteDePotassio fonteDePotassio, double quantidadeAAplicar, NutrientesPotassio nutrientes){
        nutrientes.setEnxofre(quantidadeAAplicar * fonteDePotassio.valor().get(1));
        System.out.println("Fornece " + nutrientes.getEnxofre()+" de enxofre");
        return nutrientes;
    }
}
