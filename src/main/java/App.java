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
        System.out.println("Alumínio:    "+solo.getAluminio()+"                     "+ valorIdealSolo.getAluminio()+"\n");
        System.out.println("H+Al:        "+solo.getHal()+"                     "+ valorIdealSolo.getHal()+"\n");






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


}
