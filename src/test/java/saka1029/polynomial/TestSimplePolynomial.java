package saka1029.polynomial;

import static org.junit.Assert.assertEquals;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import org.junit.Test;

public class TestSimplePolynomial {

    static void add(Map<Map<String, Long>, Long> map, Map<String, Long> v, long p) {
        Objects.requireNonNull(v, "v");
        if (p < 1)
            throw new IndexOutOfBoundsException("p");
        map.compute(v, (x, y) -> y == null ? p : y + p);
    }

    public static Map<Map<String, Long>, Long> pol() {
        return new LinkedHashMap<>();
    }

    public static Map<Map<String, Long>, Long> pol(Map<String, Long> v0, long c0) {
        Map<Map<String, Long>, Long> map = new LinkedHashMap<>();
        add(map, v0, c0);
        return map;
    }

    public static Map<Map<String, Long>, Long> pol(Map<String, Long> v0, long c0, Map<String, Long> v1, long c1) {
        Map<Map<String, Long>, Long> map = new LinkedHashMap<>();
        add(map, v0, c0);
        add(map, v1, c1);
        return map;
    }

    public static Map<Map<String, Long>, Long> pol(Map<String, Long> v0, long c0, Map<String, Long> v1, long c1, Map<String, Long> v2, long c2) {
        Map<Map<String, Long>, Long> map = new LinkedHashMap<>();
        add(map, v0, c0);
        add(map, v1, c1);
        add(map, v2, c2);
        return map;
    }

    public static String string(Map<Map<String, Long>, Long> pol) {
        StringBuilder sb = new StringBuilder();
        for (var e : pol.entrySet()) {
            Map<String, Long> vars = e.getKey();
            long coef = e.getValue();
            if (coef == 0L) {
                sb.append("+0");
                break;
            }
            if (vars.size() == 0) {
                sb.append("%+d".formatted(coef));
                break;
            }
            sb.append(coef == 1L ? "+" : "%+d".formatted(coef));
            for (var v : vars.entrySet()) {
                sb.append(v.getKey());
                if (v.getValue() > 1L)
                    sb.append("^").append(v.getValue());
            }
        }
        return sb.toString();
    }

    static void add(Map<String, Long> map, String v, long p) {
        Objects.requireNonNull(v, "v");
        if (p < 1)
            throw new IndexOutOfBoundsException("p");
        map.compute(v, (x, y) -> y == null ? p : y + p);
    }

    public static Map<String, Long> vars() {
        return new LinkedHashMap<>();
    }

    public static Map<String, Long> vars(String v0, long p0) {
        Map<String, Long> map = vars();
        add(map, v0, p0);
        return map;
    }

    public static Map<String, Long> vars(String v0, long p0, String v1, long p1) {
        Map<String, Long> map = vars();
        add(map, v0, p0);
        add(map, v1, p1);
        return map;
    }

    public static Map<String, Long> vars(String v0, long p0, String v1, long p1, String v2, long p2) {
        Map<String, Long> map = vars();
        add(map, v0, p0);
        add(map, v1, p1);
        add(map, v2, p2);
        return map;
    }

    @Test
    public void testPol() {
        assertEquals(Map.of(Map.of("x", 2L), 1L, Map.of(), 1L), pol(vars("x", 2), 1, vars(), 1));
        assertEquals(Map.of(Map.of("x", 2L), 1L, Map.of(), 4L), pol(vars("x", 2), 1, vars(), 1, vars(), 3));
        assertEquals(Map.of(Map.of("x", 2L), 3L), pol(vars("x", 2), 1, vars("x", 2), 2));
    }

    @Test
    public void testString() {
        assertEquals("+x^2+4", string(pol(vars("x", 2), 1, vars(), 1, vars(), 3)));
        assertEquals("+3x^2", string(pol(vars("x", 2), 1, vars("x", 2), 2)));
        assertEquals("+4x^2y^3+2x+3", string(pol(vars("x", 2, "y", 3), 4, vars("x", 1), 2, vars(), 3)));
    }

    @Test
    public void testVars() {
        assertEquals(Map.of("x", 2L), vars("x", 2));
        assertEquals(Map.of("x", 2L, "y", 3L), vars("x", 2, "y", 3));
        assertEquals(Map.of("x", 6L, "y", 3L), vars("x", 2, "y", 3, "x", 4));
    }
}
