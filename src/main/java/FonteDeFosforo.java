public enum FonteDeFosforo {
    A(18), B(41), C(48), D(45), E(18), F(33), G(29), H(32), I(24), J(18.5), K(52), L(18);

    private double valor;

    private FonteDeFosforo(double valor){
        this.valor = valor;
    }

    public double getValor() {
        return this.valor;
    }
}
