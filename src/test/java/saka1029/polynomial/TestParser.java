package saka1029.polynomial;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestParser {

    @Test
    public void testEquals() {
        assertEquals(Polynomial.of(Term.ZERO), Parser.parse("0"));
        assertEquals(Polynomial.of(Term.ONE), Parser.parse("1"));
        assertEquals(Polynomial.of(Term.MINUS_ONE), Parser.parse("-1"));
        assertEquals(Polynomial.of(Term.of(2, "x", 3)), Parser.parse("2x^3"));
        assertEquals(Polynomial.of(Term.of(2, "x", 4)), Parser.parse("2x^3*x"));
        assertEquals(Polynomial.of(Term.of(2, "x", 3).mult("y", 5)), Parser.parse("2x^3*y^3*y^2"));
        assertEquals(Polynomial.of(Term.of(3, "x", 3)), Parser.parse("x  ^  3 + 2  x  ^  3"));
        assertEquals(Polynomial.of(Term.of(1, "x", 3), Term.of(2L)), Parser.parse("+x^3 + 2"));
    }

    @Test
    public void testToString() {
    }




}
