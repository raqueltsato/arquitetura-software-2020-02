package domain.potassio.servico;

public class CalcularCustoPotassioServicoImpl {

    double precoDaToneladaDoPotassio = 2500.00;

    public double calculaCustoDoPotassio(double valorDoPotassio) {
        double custoDoPotassio = valorDoPotassio /1000 * precoDaToneladaDoPotassio;
        imprimeCorrecaoDoPotassio(custoDoPotassio);
        return custoDoPotassio;

    }
    public void imprimeCorrecaoDoPotassio(double custoDoPotassio) {
        System.out.println("Custo do potassio é de: " +custoDoPotassio);
    }
}
