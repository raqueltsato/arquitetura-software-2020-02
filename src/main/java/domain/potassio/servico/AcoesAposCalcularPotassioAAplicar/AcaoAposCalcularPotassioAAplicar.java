package domain.potassio.servico.AcoesAposCalcularPotassioAAplicar;

import domain.potassio.entidade.FonteDePotassio;
import domain.potassio.entidade.NutrientesPotassio;

public interface AcaoAposCalcularPotassioAAplicar {
    NutrientesPotassio executarAcao(FonteDePotassio fonteDePotassio, double quantidadeAAplicar, NutrientesPotassio nutrientes);
}
