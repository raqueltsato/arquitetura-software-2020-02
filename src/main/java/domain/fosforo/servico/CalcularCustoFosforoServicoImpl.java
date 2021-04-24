package domain.fosforo.servico;

public class CalcularCustoFosforoServicoImpl {
    double precoDaToneladaDoFosforo = 1260.00;

    public double calculaCustoDoFosforo(double fosforoAAplicar){
       double custoDoFosforo = (fosforoAAplicar/1000) * precoDaToneladaDoFosforo;
       imprimeCorrecaoDoFosforo(custoDoFosforo);
       return  custoDoFosforo;
    }

    public void imprimeCorrecaoDoFosforo(double custoDoFosforo) {
        System.out.println("O custo é de: R$ " + custoDoFosforo + " /ha");
    }
}
