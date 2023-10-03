import static org.junit.Assert.*;
import org.junit.Test;

public class NewtonTest {
    @Test
    public void testCalculateSquareRoot() {
        assertEquals(0.0, NewtonSquareRoot.calculateSquareRoot(0.0), 1e-6); // Raiz de 0 deve ser 0
        assertEquals(1.0, NewtonSquareRoot.calculateSquareRoot(1.0), 1e-6); // Raiz de 1 deve ser 1
        assertEquals(2.0, NewtonSquareRoot.calculateSquareRoot(4.0), 1e-6); // Raiz de 4 deve ser 2
        assertEquals(3.0, NewtonSquareRoot.calculateSquareRoot(9.0), 1e-6); // Raiz de 9 deve ser 3
        assertEquals(4.0, NewtonSquareRoot.calculateSquareRoot(16.0), 1e-6); // Raiz de 16 deve ser 4
        assertEquals(5.0, NewtonSquareRoot.calculateSquareRoot(25.0), 1e-6); // Raiz de 25 deve ser 5
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateSquareRootNegativeInput() {
        NewtonSquareRoot.calculateSquareRoot(-1.0); // Deve lançar uma exceção para entrada negativa
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("NewtonSquareRootTest");
    }
}
