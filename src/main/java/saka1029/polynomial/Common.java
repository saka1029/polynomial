package saka1029.polynomial;

import java.util.Map;
import java.util.function.BinaryOperator;

public class Common {
    private Common() {}

    public static <K, V> void merge(Map<K, V> left, Map<K, V> right, BinaryOperator<V> merger) {
        for (var e : right.entrySet())
            left.compute(e.getKey(), (k, v) ->
                    v == null ? e.getValue()
                              : merger.apply(v, e.getValue()));
    }

    static String toString(Map<String, Long> vars, long coef) {
        if (coef == 0L)
            return "+0";
        if (vars.size() == 0)
            return "%+d".formatted(coef);
        StringBuilder sb = new StringBuilder();
        sb.append(coef == 1L ? "+" : "%+d".formatted(coef));
        for (var e : vars.entrySet()) {
            sb.append(e.getKey());
            if (e.getValue() > 1L)
                sb.append("^").append(e.getValue());
        }
        return sb.toString();
    }

    public static final int[] SUPER_SCRIPTS = "⁰¹²³⁴⁵⁶⁷⁸⁹".codePoints().toArray();

    public static String superScript(String digits) {
        return new String(digits.chars()
            .map(d -> SUPER_SCRIPTS[Character.digit(d, 10)])
            .toArray(), 0, digits.length());
    }

    static String toSuperString(Map<String, Long> vars, long coef) {
        if (coef == 0L)
            return "+0";
        if (vars.size() == 0)
            return "%+d".formatted(coef);
        StringBuilder sb = new StringBuilder();
        sb.append(coef == 1L ? "+" : "%+d".formatted(coef));
        for (var e : vars.entrySet()) {
            sb.append(e.getKey());
            if (e.getValue() > 1L)
                sb.append(superScript("" + e.getValue()));
        }
        return sb.toString();
    }
}


