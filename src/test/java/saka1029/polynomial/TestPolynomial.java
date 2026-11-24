package saka1029.polynomial;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestPolynomial {

    @Test
    public void testToString() {
        assertEquals("+2x^3+y^4", Polynomial.of(Term.of(2, "x", 3), Term.of("y", 4)).toString());
    }

    @Test
    public void testMult() {
        Polynomial x1 = Polynomial.of(Term.of("x"), Term.ONE);
        assertEquals("+x^2+2x+1", x1.mult(x1).toString());

    }
}
