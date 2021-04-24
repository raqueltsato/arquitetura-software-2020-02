package domain.potassio.servico.AcoesAposCalcularPotassioAAplicar;

import domain.potassio.entidade.FonteDePotassio;
import domain.potassio.entidade.NutrientesPotassio;

public class PotassioForneceMagnesio implements AcaoAposCalcularPotassioAAplicar {

    public NutrientesPotassio executarAcao(FonteDePotassio fonteDePotassio, double quantidadeAAplicar, NutrientesPotassio nutrientes){
       nutrientes.setMagnesio(quantidadeAAplicar * fonteDePotassio.valor().get(2));
       System.out.println("Fornece " + nutrientes.getMagnesio()+" de magnesio");
       return nutrientes;
    }
}
