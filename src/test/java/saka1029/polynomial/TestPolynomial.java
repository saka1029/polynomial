package saka1029.polynomial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Map;

import org.junit.Test;

public class TestPolynomial {

    static Polynomial p(String expr) {
        return Parser.parse(expr);
    }

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
    public void testToSuperString() {
        assertEquals("+2x³+y⁴", Polynomial.of(Term.of(2, "x", 3), Term.of("y", 4)).toSuperString());
    }

    @Test
    public void testMult() {
        Polynomial x1 = Polynomial.of(Term.of("x"), Term.ONE);
        assertEquals("+x^2+2x+1", x1.mult(x1).toString());
        assertEquals(p("x^3-1"), p("x-1").mult(p("x^2+x+1")));
    }

    @Test
    public void testPow() {
        Polynomial x1 = Polynomial.of(Term.of("x"), Term.ONE);
        assertEquals("+1", x1.pow(0L).toString());
        assertEquals("+x+1", x1.pow(1L).toString());
        assertEquals("+x^2+2x+1", x1.pow(2L).toString());
        assertEquals("+x^3+3x^2+3x+1", x1.pow(3L).toString());
        assertEquals("+x^4+4x^3+6x^2+4x+1", x1.pow(4L).toString());
        try {
            x1.pow(-1L);
        } catch (ArithmeticException x) {
            assertEquals("power must be >= 0", x.getMessage());
        }
    }

    @Test
    public void testValue() {
        Polynomial x1 = p("x + 1");
        Map<String, Long> values = Map.of("x", 1L, "y", 2L);
        assertEquals(2L, x1.value(values));
        assertEquals(4L, x1.pow(2).value(values));
        assertEquals(8L, x1.pow(3).value(values));
        assertEquals(11L, p("3x^2 + y^3").value(values));
    }
}
