package test;

import main.RomanNumberConvertor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestRomanNumberConvertor {
    @Test
    public void TestRomanNumberToInteger() {
        assertEquals(RomanNumberConvertor.RomanNumberToInteger("MCMIII"), 1903);
        assertEquals(RomanNumberConvertor.RomanNumberToInteger("MCMXLIV"), 1944);
        assertEquals(RomanNumberConvertor.RomanNumberToInteger("I"), 1);
    }
}
