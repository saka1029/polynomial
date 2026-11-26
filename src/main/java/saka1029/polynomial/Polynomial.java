package saka1029.polynomial;

import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BinaryOperator;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class Polynomial {

    public static final Polynomial ZERO = Polynomial.of();
    public static final Polynomial ONE = Polynomial.of(Term.ONE);

    final Map<Map<String, Long>, Long> terms;

    Polynomial(Map<Map<String, Long>, Long> terms) {
        this.terms = terms;
    }

    static Map<Map<String, Long>, Long> terms() {
        return new LinkedHashMap<>();
    }

    static <K> void merge(Map<K, Long> map, K key, long value, BinaryOperator<Long> merger) {
        Long oldValue = map.get(key);
        if (oldValue != null)
            value = merger.apply(oldValue, value);
        if (value == 0L)
            map.remove(key);
        else
            map.put(key, value);
    }

    public static Polynomial of(Term... ts) {
        Map<Map<String, Long>, Long> terms = terms();
        for (var e : ts)
            merge(terms, e.vars, e.coef, (a, b) -> a + b);
        return new Polynomial(terms);
    }

    public static Polynomial of(List<Term> ts) {
        return of(ts.toArray(Term[]::new));
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

    public Polynomial pow(long p) {
        if (p < 0L)
            throw new ArithmeticException("power must be >= 0");
        Polynomial result = ONE;
        for (long i = 0; i < p; ++i)
            result = result.mult(this);
        return result;
    }

    public long value(Map<String, Long> values) {
        return terms.entrySet().stream()
            .mapToLong(e -> e.getKey().entrySet().stream()
                .mapToLong(v -> (long)Math.pow(values.get(v.getKey()), v.getValue()))
                .reduce(1L, (a, b) -> a * b) * e.getValue())
            .sum();
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

    public String toSuperString() {
        return terms.entrySet().stream()
            .map(e -> Common.toSuperString(e.getKey(), e.getValue()))
            .collect(Collectors.joining());
    }
}
