package saka1029.polynomial;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import static saka1029.polynomial.Common.*;

public class TestParser {

    @Test
    public void testEquals() {
        assertEquals(Polynomial.of(Term.ZERO), parse("0"));
        assertEquals(Polynomial.of(Term.ONE), parse("1"));
        assertEquals(Polynomial.of(Term.MINUS_ONE), parse("-1"));
        assertEquals(Polynomial.of(Term.of(2, "x", 3)), parse("2x^3"));
        assertEquals(Polynomial.of(Term.of(2, "x", 4)), parse("2x^3*x"));
        assertEquals(Polynomial.of(Term.of(2, "x", 3).mult("y", 5)), parse("2x^3*y^3*y^2"));
        assertEquals(Polynomial.of(Term.of(3, "x", 3)), parse("x  ^  3 + 2  x  ^  3"));
    }

    @Test
    public void testToString() {
    }




}
