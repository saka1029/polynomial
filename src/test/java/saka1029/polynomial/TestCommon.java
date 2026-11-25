package saka1029.polynomial;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestCommon {

    @Test
    public void testSuperScript() {
        assertEquals("¹²³⁴⁵⁶⁷⁸⁹⁰", Common.superScript("1234567890"));
    }

}
