package saka1029.polynomial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class TestTerm {

    @Test
    public void testEquals() {
        assertEquals(Term.ZERO, Term.of(0));
        assertEquals(Term.ONE, Term.of(1));
        assertEquals(Term.MINUS_ONE, Term.of(-1));
        assertEquals(Term.of(2, "x", 3), Term.of(2, "x", 3));
        assertEquals(Term.of(2, "x", 4), Term.of(2, "x", 3).mult("x"));
        assertEquals(Term.of(2, "x", 3).mult("y", 5), Term.of(2, "x", 3).mult("y", 3).mult("y", 2));
        assertEquals(Term.of(2, "x", 3).mult("y", 5), Term.of(2, "x", 3).mult(Term.of("y", 2)).mult(Term.of("y", 3)));
        assertEquals(Term.ZERO, Term.of(0, "x", 3));
        assertNotEquals(Term.of(2, "x", 3), "2x^3");
        assertNotEquals(Term.of(2, "x", 3), Term.of(1));
        assertNotEquals(Term.of(2, "x", 3), Term.of(2));
        try {
            Term.of(2, "x", 0);
        } catch (ArithmeticException x) {
            assertEquals("power must be > 0", x.getMessage());
        }
    }

    @Test
    public void testHashCode() {
        assertEquals(Term.of(2, "x", 3).hashCode(), Term.of(2, "x", 1).mult("x", 2).hashCode());
        assertNotEquals(Term.of(2, "x", 3).hashCode(), Term.of(1).hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("+3", Term.of(3).toString());
        assertEquals("+x", Term.of("x").toString());
        assertEquals("+x^2", Term.of("x", 2).toString());
        assertEquals("+3x^2", Term.of(3, "x", 2).toString());
        assertEquals("+12", Term.of(3).mult(4).toString());
        assertEquals("+x^2y", Term.of("x", 2).mult("y").toString());
        assertEquals("+x^2y^2", Term.of("x", 2).mult("y", 2).toString());
        assertEquals("+x^4", Term.of("x", 2).mult("x", 2).toString());
        assertEquals("+0", Term.of("x").mult(Term.of(0)).toString());
        assertEquals("+8x^2y^3", Term.of(8, "x", 2).mult(Term.of("y", 3)).toString());
    }

    @Test
    public void testToSuperString() {
        assertEquals("+8x²y³", Term.of(8, "x", 2).mult(Term.of("y", 3)).toSuperString());
    }
}
