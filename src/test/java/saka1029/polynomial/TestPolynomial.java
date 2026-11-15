package saka1029.polynomial;

import org.junit.Test;
import java.util.Map;

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
                c != 0L ? "" : "" + c,
                v.entryset());

        }
    }

    @Test
    public void testCVP() {
    }
}
