package saka1029.polynomial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class TestPolynomial {

    @Test
    public void testEquals() {
        assertNotEquals(Polynomial.of(Term.of(3, "a", 3)), "3a^3");
        assertNotEquals(Polynomial.of(Term.of(3, "a", 3)), Polynomial.of(Term.of("a", 3).mult(2)));
    }

    @Test
    public void testHashCode() {
        assertEquals(Polynomial.of(Term.of(3, "a", 3)).hashCode(), Polynomial.of(Term.of("a", 3).mult(3)).hashCode());
    }

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
