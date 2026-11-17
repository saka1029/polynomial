package saka1029.polynomial;

import java.util.Map;

public class Term {
    final Map<String, Long> vars;
    final long coef;

    Term(Map<String, Long> vars, long coef) {
        this.vars = vars;
        this.coef = coef;
    }

    public static Term of() {
    }
}
