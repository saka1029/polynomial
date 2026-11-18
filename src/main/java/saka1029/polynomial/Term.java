package saka1029.polynomial;

import java.util.Map;
import java.util.stream.Collectors;

public class Term {
    final Map<String, Long> vars;
    final long coef;

    Term(Map<String, Long> vars, long coef) {
        this.vars = vars;
        this.coef = coef;
    }

    public static Term of(long coef) {
        return new Term(Map.of(), 0L);
    }

    static Map<String, Long> map() {
        return new LinkedHashMap<>();
    }

    @Override
    public String toString() {
        return "%+d".formatted(coef)
            + vars.entrySet().stream()
            .map(e -> e.getKey() + (e.getValue() == 1L ? "" : "^" + e.getValue()))
            .collect(Collectors.joining());
    }
}
