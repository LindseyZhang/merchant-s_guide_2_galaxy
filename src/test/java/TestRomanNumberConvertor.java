package test.java;

import main.java.util.RomanNumberConvertor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestRomanNumberConvertor {
    @Test
    public void TestRomanNumberToInteger() {
        assertEquals(RomanNumberConvertor.romanNumberToInteger("MCMIII"), 1903);
        assertEquals(RomanNumberConvertor.romanNumberToInteger("MCMXLIV"), 1944);
        assertEquals(RomanNumberConvertor.romanNumberToInteger("I"), 1);
    }
}
