package test.java;

import main.java.util.SymbolsValidator;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;


public class TestSymbolsValidator {
    private SymbolsValidator validator;

    public TestSymbolsValidator() {
        validator = new SymbolsValidator();
    }

    @Test
    public void testIsRomanValid() {
        assertTrue(validator.isRomanValid("MCMIII"));
        assertTrue(validator.isRomanValid("MIV"));
        assertTrue(validator.isRomanValid("CD"));
        assertFalse(validator.isRomanValid("MIIII"));
        assertTrue(validator.isRomanValid("MCCCXC"));
        assertFalse(validator.isRomanValid("DM"));

        assertFalse(validator.isRomanValid("DD"));

        assertFalse(validator.isRomanValid("IIM"));
        assertTrue(validator.isRomanValid("VI"));
        assertFalse(validator.isRomanValid("VX"));
    }
 
 /*   @Test
    public void TestRepeatInSuccessionMaxThreeTimesRule() {
        assertTrue(validator.RepeatInSuccessionMaxThreeTimesRule("hahahaha"));
        assertFalse(validator.RepeatInSuccessionMaxThreeTimesRule("XXXXVM"));
        assertTrue(validator.RepeatInSuccessionMaxThreeTimesRule("XXVXM"));
        assertTrue(validator.RepeatInSuccessionMaxThreeTimesRule("VVVVVXM"));
        assertTrue(validator.RepeatInSuccessionMaxThreeTimesRule("00013XM"));
        assertTrue(validator.RepeatInSuccessionMaxThreeTimesRule(""));
    }

    @Test
    public void TestNeverRepeatRule() {
        assertFalse(validator.NeverRepeatRule("DDXM"));
        assertFalse(validator.NeverRepeatRule("LLXM"));
        assertFalse(validator.NeverRepeatRule("VVXM"));
        assertTrue(validator.NeverRepeatRule("DLVIMX"));
        assertTrue(validator.NeverRepeatRule("IIMX"));
        assertFalse(validator.NeverRepeatRule("DLVDMX"));
    }

    @Test
    public void TestIsSubtractValid() {
        assertTrue(validator.SubtractRule("MIX".toCharArray()));
        assertTrue(validator.SubtractRule("XC".toCharArray()));
        assertFalse(validator.SubtractRule("XD".toCharArray()));
        assertFalse(validator.SubtractRule("MIC".toCharArray()));
        assertFalse(validator.SubtractRule("MIV".toCharArray()));
        assertFalse(validator.SubtractRule("MIL".toCharArray()));
        assertFalse(validator.SubtractRule("MID".toCharArray()));
    } */
}
