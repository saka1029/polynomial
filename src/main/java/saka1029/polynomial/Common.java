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
}


