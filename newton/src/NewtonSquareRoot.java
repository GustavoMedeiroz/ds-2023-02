public class NewtonSquareRoot {
    public static double calculateSquareRoot(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("Não é possível calcular a raiz quadrada de um número negativo.");
        }

        double guess = x;
        double epsilon = 1e-15; // Valor de tolerância para a precisão da aproximação

        while (Math.abs(guess * guess - x) > epsilon * x) {
            guess = (x / guess + guess) / 2.0;
        }

        return guess;
    }

    @Override
    public String toString() {
        return "NewtonSquareRoot []";
    }
}
