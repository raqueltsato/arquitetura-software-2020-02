package domain.fosforo.servico.acoesAposCalcularFosforoAAplicar;

import domain.fosforo.entidade.FonteDeFosforo;
import domain.fosforo.entidade.NutrientesFosforo;

public interface AcaoAposCalcularFosforoAAplicar {
    NutrientesFosforo executarAcao(FonteDeFosforo fonteDeFosforo, double quantidadeAAplicar, NutrientesFosforo nutrientes);
}
