import java.util.ArrayList;

public class CalculaEquilibrioSolo {

    public double calculaSCmol(Solo solo) {
        return solo.getPotassio()+solo.getCalcio()+solo.getMagnesio();
    }

    public double calculaCTCCmol(Solo solo) {
        return calculaSCmol(solo)+solo.getHal();
    }

    public double calculaVPercentual(Solo solo) {
        return 100 * calculaSCmol(solo)/calculaCTCCmol(solo);
    }

    //Baseado no código disponível em: https://github.com/gabrielcostasilva/sa-soilcorrection/blob/main/src/main/java/edu/utfpr/cp/dacom/sa/soilcorrection/EquilibrioCorrecaoCTC.java
    public double calculaMOPercentual(double mo) {
        if (mo > 0) {
            return mo / 10;
        }
        return 0.0;

    }
    //Baseado no código disponível em: https://github.com/gabrielcostasilva/sa-soilcorrection/blob/main/src/main/java/edu/utfpr/cp/dacom/sa/soilcorrection/EquilibrioCorrecaoCTC.java
    public double calculaCarbono(double moPercentual) {

        if (moPercentual > 0) {
            return moPercentual / 1.72 * 10;
        }
        return 0.0;
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


    public void imprimeTabela(Solo solo, Solo valorIdealSolo, double scmol, double ctcCmol, double vPercentual, double moPercentual, double carbono){

        System.out.println("\n------------ TABELA DE VALORES-------------");
        System.out.println("          VALOR COLETADO          VALOR IDEAL");
        System.out.println("Fosforo:     "+solo.getFosforo()+"                     "+ valorIdealSolo.getFosforo());
        System.out.println("Potássio:    "+solo.getPotassio()+"                     "+ valorIdealSolo.getPotassio());
        System.out.println("Cálcio:      "+solo.getCalcio()+"                     "+ valorIdealSolo.getCalcio());
        System.out.println("Magnésio:    "+solo.getMagnesio()+"                     "+ valorIdealSolo.getMagnesio());
        System.out.println("Enxofre:     "+solo.getEnxofre()+"                     "+ valorIdealSolo.getEnxofre());
        System.out.println("Alumínio:    "+solo.getAluminio()+"                      "+ valorIdealSolo.getAluminio());
        System.out.println("H+Al:        "+solo.getHal()+"                     "+ valorIdealSolo.getHal());

        System.out.println("\nSCmol:       "+ scmol);
        System.out.println("CTCCmol:     "+ ctcCmol);
        System.out.println("V % Atual:   "+ vPercentual);

        System.out.println("\nMO %:        "+  moPercentual);
        System.out.println("Carbono %:        "+  carbono+"\n");

    }

}
