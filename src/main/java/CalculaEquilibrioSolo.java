import java.util.Scanner;

public class CalculaEquilibrioSolo {
    public static Scanner scan = new Scanner(System.in);

    double calculaSCmol(Solo solo) {
        return solo.getPotassio()+solo.getCalcio()+solo.getMagnesio();
    }

    double calculaCTCCmol(Solo solo) {
        return solo.getPotassio()+solo.getCalcio()+solo.getMagnesio()+solo.getHal();
    }

    double calculaVPercentual(Solo solo) {
        return 100 * calculaSCmol(solo)/calculaCTCCmol(solo);
    }

    double calculaMOPercentual(double mo) {
        if (mo > 0) {
            return mo / 10;

        } else {
            return 0.0;
        }
    }

    double calculaCarbono(double moPercentual) {

        if (moPercentual > 0) {
            return moPercentual / 1.72 * 10;

        } else {
            return 0.0;
        }
    }

    public Solo recebeDadosDoSolo() {

        Solo solo = new Solo();
        Solo valorIdealSolo = new Solo();
        String textura;
        double inputTemp;

        System.out.println("Escolha a textura de solo, digitando:");
        System.out.println("1 - para solo argiloso");
        System.out.println("2 - para solo textura média");
        textura = scan.nextLine();
        solo.setTextura(textura);

        System.out.println("\nDigite o valor do fósforo");
        solo.setFosforo(Double.parseDouble(scan.nextLine()));

        System.out.println("\nDigite o valor do potássio");
        solo.setPotassio(Double.parseDouble(scan.nextLine()));

        System.out.println("\nDigite o valor do cálcio");
        solo.setCalcio(Double.parseDouble(scan.nextLine()));

        System.out.println("\nDigite o valor do magnésio");
        solo.setMagnesio(Double.parseDouble(scan.nextLine()));

        System.out.println("\nDigite o valor do enxofre");
        solo.setEnxofre(Double.parseDouble(scan.nextLine()));

        System.out.println("\nDigite o valor do alumínio");
        solo.setAluminio(Double.parseDouble(scan.nextLine()));

        System.out.println("\nDigite o valor do H+Al");
        solo.setHal(Double.parseDouble(scan.nextLine()));

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

    public double quantidadeAplicarFosforo(Solo solo) {
        System.out.println("Digite o teor de fósforo a atingir");
        double fosforoaAtingir = (Double.parseDouble(scan.nextLine()));
        String fonteDeFosforo = fonteDeFosforo();
        double valorDaFonte = getFonteValor(fonteDeFosforo);
        double resultado = calculaQuantidadeFosforoAAplicar(solo, fosforoaAtingir, valorDaFonte);

        return resultado;

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
    private double calculaQuantidadeFosforoAAplicar(Solo solo, double fosforoAAtingir, double valorDaFonte) {
        System.out.println("Digite a eficiência do fósforo em porcentagem");
        double eficiencia = (Double.parseDouble(scan.nextLine()));
        eficiencia = eficiencia/100;
        double primeiroValor = ((((fosforoAAtingir - solo.getFosforo())*2 * 2.29 * 100)/eficiencia)/100)*100;
        double quantidadeAAplicar = primeiroValor/valorDaFonte;

        return quantidadeAAplicar;
    }

    public double getFonteValor(String fonteDeFosforo) {

        FonteDeFosforo fonte = null;
        switch (fonteDeFosforo) {
            case "1":
                fonte = FonteDeFosforo.A;
                break;
            case "2":
                fonte = FonteDeFosforo.B;
                break;
            case "3":
                fonte = FonteDeFosforo.C;
                break;
            case "4":
                fonte = FonteDeFosforo.D;
                break;
            case "5":
                fonte = FonteDeFosforo.E;
                break;
            case "6":
                fonte = FonteDeFosforo.F;
                break;
            case "7":
                fonte = FonteDeFosforo.G;
                break;
            case "8":
                fonte = FonteDeFosforo.H;
                break;
            case "9":
                fonte = FonteDeFosforo.I;
                break;
            case "10":
                fonte = FonteDeFosforo.J;
                break;
            case "11":
                fonte = FonteDeFosforo.K;
                break;
            case "12":
                fonte = FonteDeFosforo.L;
                break;

        }
        return fonte.getValor();
    }

}
