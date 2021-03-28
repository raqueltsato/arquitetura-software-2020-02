public enum FonteDePotassio {
    A(58), B(52), C(22), D(44);

    private double valor;

    private FonteDePotassio(double valor){
        this.valor = valor;
    }

    public double getValor() {
        return this.valor;
    }
}
