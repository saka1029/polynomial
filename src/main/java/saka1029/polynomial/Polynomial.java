package saka1029.polynomial;

import java.util.Map;
import java.util.ArrayList;
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
    
    public Polynomial mult(Polynomial right){
        List<Term> list = new ArrayList<>();
        for (var el : terms.entrySet()) {
            Term l = new Term(el.getKey(), el.getValue());
            for (var er : right.terms.entrySet()) {
                Term r = new Term(er.getKey(), er.getValue());
                list.add(l.mult(r));
            }
        }
        return Polynomial.of(list);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Polynomial p
            && p.terms.equals(terms);
    }

    @Override
    public int hashCode() {
        return terms.hashCode();
    }

    @Override
    public String toString() {
        return terms.entrySet().stream()
            .map(e -> Common.toString(e.getKey(), e.getValue()))
            .collect(Collectors.joining());
    }
}
