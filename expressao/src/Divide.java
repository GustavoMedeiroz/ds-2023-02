public class Divide implements Expressao {
    private Expressao expressao1;
    private Expressao expressao2;

    public Divide(Expressao expressao1, Expressao expressao2) {
        this.expressao1 = expressao1;
        this.expressao2 = expressao2;
    }

    @Override
    public float valor() {
        float valor2 = expressao2.valor();
        if (valor2 != 0) {
            return expressao1.valor() / valor2;
        } else {
            throw new ArithmeticException("Divisão por zero");
        }
    }
}