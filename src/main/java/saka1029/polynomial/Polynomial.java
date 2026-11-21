package saka1029.polynomial;

import java.util.Map;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class Polynomial {
    final Map<Map<String, Long>, Long> terms;

    Polynomial(Map<Map<String, Long>, Long> terms) {
        this.terms = terms;
    }

    static Map<Map<String, Long>, Long> terms() {
        return new LinkedHashMap<>();
    }

    public static Polynomial of(Term... ts) {
        Map<Map<String, Long>, Long> terms = terms();
        for (var e : ts)
            terms.merge(e.vars, e.coef, (a, b) -> a + b);
        return new Polynomial(terms);
    }

    public static Polynomial of(List<Term> ts) {
        Map<Map<String, Long>, Long> terms = terms();
        for (var e : ts)
            terms.merge(e.vars, e.coef, (a, b) -> a + b);
        return new Polynomial(terms);
    }

    @Override
    public String toString() {
        return terms.entrySet().stream()
            .map(e -> Common.toString(e.getKey(), e.getValue()))
            .collect(Collectors.joining());
    }
}
