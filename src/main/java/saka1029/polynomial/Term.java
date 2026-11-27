package saka1029.polynomial;

import java.util.Map;
import java.util.Objects;
import java.util.LinkedHashMap;

public class Term {
     public static final Term ZERO = of(0L);
     public static final Term ONE = of(1L);
     public static final Term MINUS_ONE = of(-1L);

    final Map<String, Long> vars;
    final long coef;

    Term(Map<String, Long> vars, long coef) {
        this.vars = vars;
        this.coef = coef;
    }

    static Map<String, Long> vars() {
        return new LinkedHashMap<>();
    }

    static Map<String, Long> vars(Map<String, Long> vars) {
        return new LinkedHashMap<>(vars);
    }
    
    static void checkPower(long p) {
        if (p <= 0L)
            throw new ArithmeticException("power must be > 0");
    }

    public static Term of(long coef) {
        return new Term(vars(), coef);
    }

    public Term mult(long c) {
        Map<String, Long> nvars = vars(vars);
        return new Term(nvars, coef * c);
    }

    public Term mult(String v, long p) {
        if (coef == 0L)
            return ZERO;
        checkPower(p);
        Map<String, Long> nvars = vars(vars);
        nvars.merge(v, p, (a, b) -> a + b);
        return new Term(nvars, coef);
    }

    public Term mult(Term t) {
        long c = coef * t.coef;
        if (c == 0L)
            return ZERO;
        Map<String, Long> nvars = vars(vars);
        Common.merge(nvars, t.vars, (a, b) -> a + b);
        Term result = new Term(nvars, c);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Term t
            && t.coef == coef
            && t.vars.equals(vars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coef, vars);
    }

    @Override
    public String toString() {
        return Common.toString(vars, coef);
    }

    public String toSuperString() {
        return Common.toSuperString(vars, coef);
    }
}
