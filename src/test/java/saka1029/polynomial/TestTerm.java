package saka1029.polynomial;

import static org.junit.Assert.assertEquals;

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
    }

    @Test
    public void testToString() {
        assertEquals("+3", Term.of(3).toString());
        assertEquals("+x^2", Term.of("x", 2).toString());
        assertEquals("+3x^2", Term.of(3, "x", 2).toString());
        assertEquals("+12", Term.of(3).mult(4).toString());
        assertEquals("+x^2y", Term.of("x", 2).mult("y").toString());
        assertEquals("+x^2y^2", Term.of("x", 2).mult("y", 2).toString());
        assertEquals("+x^4", Term.of("x", 2).mult("x", 2).toString());
        assertEquals("+8x^2y^3", Term.of(8, "x", 2).mult(Term.of("y", 3)).toString());
    }




}
