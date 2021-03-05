import java.util.Scanner;

public class App {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Solo solo = new Solo();
        Solo valorIdealSolo = new Solo();
        String textura;
        double inputTemp;

        System.out.println("Escolha a textura de solo, digitando:");
        System.out.println("1 - para solo argiloso");
        System.out.println("2 - para solo textura média");
        textura = scan.nextLine();
        imprimeTextura(textura);
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

        valorIdealSolo = solo.verificaValorIdeal();

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
        System.out.println("SCmol:       "+ scmolCalc(solo));
        System.out.println("CTCCmol:     "+ ctcCmolCalc(solo));
        System.out.println("V % Atual:   "+ vAtualCalc(solo));

        System.out.println("\n--------------------------------------------\n");
        System.out.println("\n-------------- APÓS CORREÇÃO---------------");
        System.out.println("Fósforo após correção:        "+  fosforoAposCorrecao());
        System.out.println("\n--------------------------------------------\n");
        System.out.println("Potássio após correção:       "+  potassioAposCorrecao(solo));





    }

    private static void imprimeTextura(String textura) {

        if (textura.equals("1") ) {
            System.out.printf("SOLO ARGILOSO\n");
        } else if(textura.equals("2") ) {
            System.out.printf("SOLO TEXTURA MÉDIA\n");
        } else {
            System.out.printf("Você deve escolher 1 ou 2\n");
            return;
        }
    }

    private static double scmolCalc(Solo solo) {
        return solo.getPotassio()+solo.getCalcio()+solo.getMagnesio();
    }

    private static double ctcCmolCalc(Solo solo) {
        return solo.getPotassio()+solo.getCalcio()+solo.getMagnesio()+solo.getHal();
    }

    private static double vAtualCalc(Solo solo) {
        return 100 * scmolCalc(solo)/ctcCmolCalc(solo);
    }

    private static double fosforoAposCorrecao() {
        double valorDesejadoFosforo;
        System.out.println("Digite o teor de fósforo a atingir:");
        valorDesejadoFosforo = (Double.parseDouble(scan.nextLine()));
        return valorDesejadoFosforo;
    }

    private static double potassioAposCorrecao(Solo solo) {
        if (solo.getPotassio()> 0.5) {
            return solo.getPotassio();
        } else {
            if (potassioDesejado(solo) < 0.01) {
                return solo.getPotassio();
            } else {
                return solo.getPotassio()+potassioDesejado(solo);
            }
        }
    }

    private static double potassioDesejado (Solo solo) {
        double valorDesejado;
        System.out.println("Digite o valor do potassio desejado para a correção de solo:");
        valorDesejado = (Double.parseDouble(scan.nextLine()));
        return (solo.getPotassio()*valorDesejado)/(solo.getPotassio()/ctcCmolCalc(solo)*100) - solo.getPotassio();
    }


}
