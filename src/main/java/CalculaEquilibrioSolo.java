import java.util.ArrayList;
import java.util.Scanner;

public class CalculaEquilibrioSolo {
    public static Scanner scan = new Scanner(System.in);

    public double calculaSCmol(Solo solo) {
        return solo.getPotassio()+solo.getCalcio()+solo.getMagnesio();
    }

    public double calculaCTCCmol(Solo solo) {
        return calculaSCmol(solo)+solo.getHal();
    }

    public double calculaVPercentual(Solo solo) {
        return 100 * calculaSCmol(solo)/calculaCTCCmol(solo);
    }

    public double calculaMOPercentual(double mo) {
        if (mo > 0) {
            return mo / 10;

        } else {
            return 0.0;
        }
    }

    public double calculaCarbono(double moPercentual) {

        if (moPercentual > 0) {
            return moPercentual / 1.72 * 10;

        } else {
            return 0.0;
        }
    }


    public Solo recebeDadosDoSolo(String textura, double fosforo, double potassio, double calcio, double magnesio, double enxofre, double aluminio, double hAl) {

        Solo solo = new Solo();

        solo.setTextura(textura);

        solo.setFosforo(fosforo);

        solo.setPotassio(potassio);

        solo.setCalcio(calcio);

        solo.setMagnesio(magnesio);

        solo.setEnxofre(enxofre);

        solo.setAluminio(aluminio);

        solo.setHal(hAl);

        return solo;
    }


    public double recebeECalculaMOPercentual(){
        System.out.println("Digite o valor de M.O (g. dm3)");
        double mo = (Double.parseDouble(scan.nextLine()));
        return calculaMOPercentual(mo);
    }


    public void imprimeTabela(Solo solo, Solo valorIdealSolo, double scmol, double ctcCmol, double vPercentual, double moPercentual, double carbono){
        imprimeTextura(solo);
        System.out.println("\n------------ TABELA DE VALORES-------------");
        System.out.println("\n          VALOR COLETADO          VALOR IDEAL");
        System.out.println("Fosforo:     "+solo.getFosforo()+"                     "+ valorIdealSolo.getFosforo()+"\n");
        System.out.println("Potássio:    "+solo.getPotassio()+"                     "+ valorIdealSolo.getPotassio()+"\n");
        System.out.println("Cálcio:      "+solo.getCalcio()+"                     "+ valorIdealSolo.getCalcio()+"\n");
        System.out.println("Magnésio:    "+solo.getMagnesio()+"                     "+ valorIdealSolo.getMagnesio()+"\n");
        System.out.println("Enxofre:     "+solo.getEnxofre()+"                     "+ valorIdealSolo.getEnxofre()+"\n");
        System.out.println("Alumínio:    "+solo.getAluminio()+"                      "+ valorIdealSolo.getAluminio()+"\n");
        System.out.println("H+Al:        "+solo.getHal()+"                     "+ valorIdealSolo.getHal()+"\n");
        System.out.println("\n--------------------------------------------\n");
        System.out.println("SCmol:       "+ scmol);
        System.out.println("CTCCmol:     "+ ctcCmol);
        System.out.println("V % Atual:   "+ vPercentual);

        System.out.println("\n--------------------------------------------\n");
        System.out.println("MO %:        "+  moPercentual);
        System.out.println("MO %:        "+  carbono);

    }

    private void imprimeTextura(Solo solo) {

        if (solo.getTextura().equals("1")) {
            System.out.printf("\n\nSOLO ARGILOSO\n");
        } else {
            System.out.printf("SOLO TEXTURA MÉDIA\n");
        }
    }


    public void recebeDadosParaRecuperacaoDoFosforo(Solo solo) {
        double fosforoAAtingir = recebeTeorDoFosforoAAtingir();
        String fonteDoFosforo = fonteDeFosforo();
        double eficienciaDoFosforo = recebeEficienciaDoFosforo();
        double quantidadeAplicar = calculoDeQuantidadeFosforoAAplicar(solo.getFosforo(), fosforoAAtingir, eficienciaDoFosforo, fonteDoFosforo);
        double precoDaTonelada = recebeValorDaToneladaDoFosforo();
        double custoDoFosforo = calculaCustoDoFosforo(quantidadeAplicar, precoDaTonelada);
        imprimeCorrecaoDoFosforo(quantidadeAplicar, custoDoFosforo);

    }

    public double recebeTeorDoFosforoAAtingir() {
        System.out.println("Digite o teor de fósforo a atingir");
        double fosforoAtingir = (Double.parseDouble(scan.nextLine()));

        return fosforoAtingir;
    }


    private String fonteDeFosforo(){
        System.out.println("Digite a fonte de fósforo");
        System.out.println("1 – Superfosfato Simples");
        System.out.println("2 – Superfosfato Triplo");
        System.out.println("3 – MAP");
        System.out.println("4 – DAP");
        System.out.println("5 – Yoorin");
        System.out.println("6 – Fosfato  Arad");
        System.out.println("7 – Fosfato  Gafsa");
        System.out.println("8 – Fosfato  Daoui");
        System.out.println("9 - Fosf.  Patos Minas");
        System.out.println("10 – Escória de Thomas");
        System.out.println("11 – Ácido Fosfórico ");
        System.out.println("12 – Multif.Magnesiano");
        String opcao = scan.nextLine();


        return opcao;
    }

    private double getFonteValor(String fonteDeFosforo) {

        double fonte = 0.0;
        switch (fonteDeFosforo) {
            case "1":
                fonte = FonteDeFosforo.SUPERFOSFATO_SIMPLES.valor();
                break;
            case "2":
                fonte = FonteDeFosforo.SUPERFOSFATO_TRIPLO.valor();
                break;
            case "3":
                fonte = FonteDeFosforo.MAP.valor();
                break;
            case "4":
                fonte = FonteDeFosforo.DAP.valor();
                break;
            case "5":
                fonte = FonteDeFosforo.YOORIN.valor();
                break;
            case "6":
                fonte = FonteDeFosforo.FOSFATO_ARAD.valor();
                break;
            case "7":
                fonte = FonteDeFosforo.FOSFATO_GAFSA.valor();
                break;
            case "8":
                fonte = FonteDeFosforo.FOSFATO_DAOUI.valor();
                break;
            case "9":
                fonte = FonteDeFosforo.FOSF_PATOS_MINAS.valor();
                break;
            case "10":
                fonte = FonteDeFosforo.ESCORIA_DE_THOMAS.valor();
                break;
            case "11":
                fonte = FonteDeFosforo.ACIDO_FOSFORICO.valor();
                break;
            case "12":
                fonte = FonteDeFosforo.MULTIF_MAGNESIANO.valor();
                break;

        }
        return fonte;
    }

    public double recebeEficienciaDoFosforo() {
        System.out.println("Digite a eficiência do fósforo em porcentagem");
        double eficiencia = (Double.parseDouble(scan.nextLine()));

        return eficiencia;
    }

    private double calculoDeQuantidadeFosforoAAplicar(double fosforoNoSolo, double fosforoAAtingir, double eficiencia, String fonteDeFosforo) {
        double valorDaFonte = getFonteValor(fonteDeFosforo);
        eficiencia = eficiencia/100;
        if (eficiencia == 0.00) {
            return 0.00;
        }
        double primeiroValor = ((((fosforoAAtingir - fosforoNoSolo)*2 * 2.29 * 100)/eficiencia)/100)*100;
        double quantidadeAAplicar = primeiroValor/valorDaFonte;

        return quantidadeAAplicar;
    }

    public double recebeValorDaToneladaDoFosforo() {
        System.out.println("Digite o valor da Tonelada do Fósforo");
        double preco = (Double.parseDouble(scan.nextLine()));

        return preco;
    }

    public double calculaCustoDoFosforo(double fosforoAAplicar, double preco){

        return (((fosforoAAplicar*2.42)/1000) * preco) / 2.42;
    }

    public void imprimeCorrecaoDoFosforo(double fosforoAAplicar, double custoDoFosforo){
        System.out.println("Quantidade de Fosfato a aplicar:           "+fosforoAAplicar+ " kg/hectare");
        System.out.println("O custo é de:                              R$ " +custoDoFosforo+" /ha");
    }

/*---------------------*/
public void recebeDadosParaRecuperarPotassio(Solo solo, double ctcCmol) {
    double potassioNoSolo = solo.getPotassio();
    double porcentPotassioDesejado = recebeParticipacaodoPotassioDesejada();
    String fontePotassio = fonteDePotassio();
    double precoDaToneladaDoPotassio = recebeValorDaToneladaDoPotassio();
    ArrayList<Double> quantidadeAAplicarPotassioEOutrosNutrientes = new ArrayList<Double>();
    quantidadeAAplicarPotassioEOutrosNutrientes = calculoDeQuantidadePotassioAAplicar(potassioNoSolo, ctcCmol, porcentPotassioDesejado, fontePotassio);

    double custoDoPotassio = calculaCustoDoPotassio(quantidadeAAplicarPotassioEOutrosNutrientes.get(0), fontePotassio, precoDaToneladaDoPotassio);

    imprimeCorrecaoDoPotassio(quantidadeAAplicarPotassioEOutrosNutrientes, custoDoPotassio);


}

    public double recebeParticipacaodoPotassioDesejada() {
        System.out.println("Digite a participação do potassio na CTC desejada");
        double potassioDesejado = (Double.parseDouble(scan.nextLine()));
        return potassioDesejado;
    }

    private String fonteDePotassio(){
        System.out.println("Digite a fonte de potássio");
        System.out.println("1 – Cloreto de Potássio");
        System.out.println("2 - Sulfato de Potássio");
        System.out.println("3 – Sulf.Potássio/Mag.");
        System.out.println("4 – Nitrato de Potássio");
        String opcao = scan.nextLine();


        return opcao;
    }
    private double recebeValorDaToneladaDoPotassio(){
        System.out.println("Digite o preço do potássio:");
        double precoDoPotassio = (Double.parseDouble(scan.nextLine()));

        return precoDoPotassio;
    }

    public ArrayList<Double> calculoDeQuantidadePotassioAAplicar(double potassioNoSolo, double ctcCMol, double porcentPotassioDesejado, String fontePotassio){
        ArrayList<Double> nutrientes = new ArrayList<Double>();
        ArrayList<Double> potassioENutrientes = new ArrayList<Double>();
        double valorDaFonte = getFonteValorPotassio(fontePotassio);
        double potassio = potassioNoSolo * porcentPotassioDesejado;
        double resultado1 = potassioNoSolo/ctcCMol*100;
        double primeiroResultadoDoCalculo = ((potassio/resultado1)-potassioNoSolo)*39.1*10*2*1.2*100;
        double quantidadeAplicarPotassio = primeiroResultadoDoCalculo/0.85/100*100/valorDaFonte;
        potassioENutrientes.add(quantidadeAplicarPotassio);
        nutrientes = verificaNutrientes(fontePotassio, quantidadeAplicarPotassio);
        potassioENutrientes.add(nutrientes.get(0));
        potassioENutrientes.add(nutrientes.get(1));

        return potassioENutrientes;
    }

    private ArrayList<Double> verificaNutrientes (String fontePotassio, double valorDoPotassio) {
        ArrayList<Double> enxofreMagnesio = new ArrayList<Double>();

        switch (fontePotassio) {
            case "2":
                enxofreMagnesio.add(valorDoPotassio*0.17);
                enxofreMagnesio.add(0.0);
                break;
            case "3":
                enxofreMagnesio.add(valorDoPotassio*0.22);
                enxofreMagnesio.add(valorDoPotassio*0.18);
                break;
            default:
                enxofreMagnesio.add(0.0);
                enxofreMagnesio.add(0.0);
                break;
        }

        return enxofreMagnesio;

    }


    private double getFonteValorPotassio(String fonteDePotassio) {

        double fonte = 0.0;
        switch (fonteDePotassio) {
            case "1":
                fonte = FonteDePotassio.CLORETO_DE_POTASSIO.valor();
                break;
            case "2":
                fonte = FonteDePotassio.SULFATO_DE_POTASSIO.valor();
                break;
            case "3":
                fonte = FonteDePotassio.SULFATO_DE_POTASSIO_E_MAGNESIO.valor();
                break;
            case "4":
                fonte = FonteDePotassio.NITRATO_DE_POTASSIO.valor();
                break;

        }
        return fonte;
    }

    public void imprimeCorrecaoDoPotassio(ArrayList<Double> potassioENutrientes, double custoDoPotassio) {

        System.out.println("Quantidade a aplicar de potassio:   "+ potassioENutrientes.get(0));
        System.out.println("Custo R$/ha do potassio:   "+ custoDoPotassio);
        if (potassioENutrientes.get(1) != 0.0) {
            System.out.println("\nEssa fonte oferece "+ potassioENutrientes.get(1) + " kg/ha de enxofre");
        }
        if (potassioENutrientes.get(2) != 0.0) {
            System.out.println("Essa fonte oferece "+ potassioENutrientes.get(2) + " kg/ha de magnésio\n");
        }

    }

    public double calculaCustoDoPotassio(double valorDoPotassio, String fonteDoPotassio, double precoDoPotassio) {
        if (!fonteDoPotassio.equals("4")){
            return (valorDoPotassio * 2.42) /1000 * precoDoPotassio/2.42;
        }
        return 0.0;
    }
}
