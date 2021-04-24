package domain.solo.entidade;

public class Solo {

    private SoloTextura textura;
    private double fosforo;
    private double potassio;
    private double calcio;
    private double magnesio;
    private double enxofre;
    private double aluminio;
    private double hal;

    public Solo(SoloTextura textura, double fosforo, double potassio, double calcio, double magnesio, double enxofre, double aluminio, double hal) {
        this.textura = textura;
        this.fosforo = fosforo;
        this.potassio = potassio;
        this.calcio = calcio;
        this.magnesio = magnesio;
        this.enxofre = enxofre;
        this.aluminio = aluminio;
        this.hal = hal;
    }

    public double getFosforo() {
        return fosforo;
    }

    public double getPotassio() {
        return potassio;
    }

    public double getCalcio() {
        return calcio;
    }

    public double getMagnesio() {
        return magnesio;
    }

    public double getEnxofre() { return enxofre; }

    public double getAluminio() {
        return aluminio;
    }

    public double getHal() {
        return hal;
    }

    public SoloTextura getTextura() {
        return textura;
    }




}
