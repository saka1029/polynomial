package saka1029.polynomial;

import java.util.LinkedHashMap;
import java.util.Map;

public class TestSimplePolynomial {

    Map<Map<String, Long>, Long> pol() {
        return new LinkedHashMap<>();
    }

    Map<Map<String, Long>, Long> pol(Map<String, Long> v0, long c0) {
        Map<Map<String, Long>, Long> map = new LinkedHashMap<>();
        map.put(v0, c0);
        return map;
    }

    Map<Map<String, Long>, Long> pol(Map<String, Long> v0, long c0, Map<String, Long> v1, long c1) {
        Map<Map<String, Long>, Long> map = new LinkedHashMap<>();
        map.put(v0, c0);
        map.put(v1, c1);
        return map;
    }

    Map<Map<String, Long>, Long> pol(Map<String, Long> v0, long c0, Map<String, Long> v1, long c1, Map<String, Long> v2, long c2) {
        Map<Map<String, Long>, Long> map = new LinkedHashMap<>();
        map.put(v0, c0);
        map.put(v1, c1);
        map.put(v2, c2);
        return map;
    }

    Map<String, Long> vars() {
        return new LinkedHashMap<>();
    }

    Map<String, Long> vars(String v, long p) {
        Map<String, Long> map = vars();
        map.put(v, p);
        return map;
    }

    Map<String, Long> vars(String v0, long p0, String v1, long p1) {
        Map<String, Long> map = vars();
        map.put(v0, p0);
        map.put(v1, p1);
        return map;
    }

    Map<String, Long> vars(String v0, long p0, String v1, long p1, String v2, long p2) {
        Map<String, Long> map = vars();
        map.put(v0, p0);
        map.put(v1, p1);
        map.put(v2, p2);
        return map;
    }
}
