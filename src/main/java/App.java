import domain.fosforo.servico.CalcularCustoFosforoServicoImpl;
import domain.fosforo.servico.CalcularFosforoAaplicarServicoImpl;
import domain.fosforo.entidade.FonteDeFosforo;
import domain.potassio.servico.CalcularCustoPotassioServicoImpl;
import domain.potassio.servico.CalcularPotassioAAplicarServicoImpl;
import domain.potassio.entidade.FonteDePotassio;
import domain.solo.entidade.Solo;
import domain.solo.entidade.SoloTextura;
import domain.solo.servicos.CalcularEquilibrioSoloServicoImpl;
import domain.solo.servicos.SoloVerificarValorIdealServicoImpl;

public class App {

    public static void main(String[] args) {
        Solo solo = new Solo(SoloTextura.CODIG0_ARGILOSO, 8.59, 0.15, 5.76, 1.63, 3.67, 0.0, 5.35 );

        Solo valorIdealSolo = SoloVerificarValorIdealServicoImpl.verificarValorIdeal(solo.getTextura());

        CalcularEquilibrioSoloServicoImpl calculaEquilibrioSolo = new CalcularEquilibrioSoloServicoImpl();

        calculaEquilibrioSolo.imprimeTabela(solo, valorIdealSolo);

        CalcularFosforoAaplicarServicoImpl calculaFosforoAAplicar = new CalcularFosforoAaplicarServicoImpl();
        calculaFosforoAAplicar.calcularFosforo(solo.getFosforo(), FonteDeFosforo.SUPERFOSFATO_SIMPLES);

        CalcularCustoFosforoServicoImpl calcularCustoFosforoServico = new CalcularCustoFosforoServicoImpl();
        calcularCustoFosforoServico.calculaCustoDoFosforo(calculaFosforoAAplicar.getQuantidadeAplicar());

        CalcularPotassioAAplicarServicoImpl calculaPotassioAAplicar = new CalcularPotassioAAplicarServicoImpl();
        calculaPotassioAAplicar.calcularPotassio(solo.getPotassio(), calculaEquilibrioSolo.calculaCTCCmol(solo), FonteDePotassio.SULFATO_DE_POTASSIO_E_MAGNESIO);

        CalcularCustoPotassioServicoImpl calcularCustoPotassioServico = new CalcularCustoPotassioServicoImpl();
        calcularCustoPotassioServico.calculaCustoDoPotassio(calculaPotassioAAplicar.getQuantidadeAplicar());

    }




}
