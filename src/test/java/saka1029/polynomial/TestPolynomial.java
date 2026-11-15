package saka1029.polynomial;

import org.junit.Test;
import java.util.Map;
import java.util.stream.Collectors;

public class TestPolynomial {

    public static class CVP {
        public final long c;
        public final Map<String, Integer> v;
        CVP(long c, Map<String,Integer> v) {
            this.c = c;
            this.v = v;
        }
        public String toString() {
            return "%s%s".formatted(
                c != 1L ? "" : "" + c,
                v.entryset().stream()
                .map(e -> e.getKey()
                    e.getValue() == 1L ? "" : "^" + e.getValue())
                .collect(Collectors.joining();

        }
    }

    @Test
    public void testCVP() {
    }
}
