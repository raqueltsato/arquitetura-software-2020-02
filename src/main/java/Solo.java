public class Solo {


    private String textura;
    private double fosforo;
    private double potassio;
    private double calcio;
    private double magnesio;
    private double enxofre;
    private double aluminio;
    private double hal;

    public double getFosforo() {
        return fosforo;
    }

    public void setFosforo(double fosforo) {
        this.fosforo = fosforo;
    }

    public double getPotassio() {
        return potassio;
    }

    public void setPotassio(double potassio) {
        this.potassio = potassio;
    }

    public double getCalcio() {
        return calcio;
    }

    public void setCalcio(double calcio) {
        this.calcio = calcio;
    }

    public double getMagnesio() {
        return magnesio;
    }

    public void setMagnesio(double magnesio) {
        this.magnesio = magnesio;
    }

    public double getEnxofre() {
        return enxofre;
    }

    public void setEnxofre(double enxofre) {
        this.enxofre = enxofre;
    }

    public double getAluminio() {
        return aluminio;
    }

    public void setAluminio(double aluminio) {
        this.aluminio = aluminio;
    }

    public double getHal() {
        return hal;
    }

    public void setHal(double hal) {
        this.hal = hal;
    }

    public String getTextura() {
        return textura;
    }

    public void setTextura(String textura) {
        this.textura = textura;
    }

    public Solo verificaValorIdeal() {
        Solo ideal = new Solo();
        if (this.textura.equals("1")) {
            ideal.setTextura("1");
            ideal.setFosforo(9);
            ideal.setPotassio(0.35);
            ideal.setCalcio(6.0);
            ideal.setMagnesio(1.5);
            ideal.setEnxofre(9.0);
            ideal.setAluminio(0);
            ideal.setHal(0);
        } else{
            ideal.setTextura("2");
            ideal.setFosforo(9);
            ideal.setPotassio(0.25);
            ideal.setCalcio(4.0);
            ideal.setMagnesio(1.0);
            ideal.setEnxofre(6.0);
            ideal.setAluminio(0);

        }
        return ideal;
    }


}
