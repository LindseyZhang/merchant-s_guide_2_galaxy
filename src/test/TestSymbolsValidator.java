package test;

import main.SymbolsValidator;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;


public class TestSymbolsValidator {
    private SymbolsValidator validator;

    public TestSymbolsValidator() {
        validator = new SymbolsValidator();
    }

  /*  @Test
    public void testGenerateReceiptFromBarcodes() {
        assertTrue(validator.IsIXCMRepeatInSuccessionMaxThreeTimes("hahahaha"));
        assertFalse(validator.IsIXCMRepeatInSuccessionMaxThreeTimes("XXXXVM"));
        assertTrue(validator.IsIXCMRepeatInSuccessionMaxThreeTimes("XXVXM"));
        assertTrue(validator.IsIXCMRepeatInSuccessionMaxThreeTimes("VVVVVXM"));
        assertTrue(validator.IsIXCMRepeatInSuccessionMaxThreeTimes("00013XM"));
        assertTrue(validator.IsIXCMRepeatInSuccessionMaxThreeTimes(""));
    }

    @Test
    public void testDLVCanNeverRepeat() {
        assertFalse(validator.DLVCanNeverRepeat("DDXM"));
        assertFalse(validator.DLVCanNeverRepeat("LLXM"));
        assertFalse(validator.DLVCanNeverRepeat("VVXM"));
        assertTrue(validator.DLVCanNeverRepeat("DLVIMX"));
        assertTrue(validator.DLVCanNeverRepeat("IIMX"));
        assertFalse(validator.DLVCanNeverRepeat("DLVDMX"));
    } */

    @Test
    public void testIsSubtractValid() {
        assertTrue(validator.IsSubtractValid("MIX".toCharArray()));
        assertTrue(validator.IsSubtractValid("XC".toCharArray()));
        assertFalse(validator.IsSubtractValid("XD".toCharArray()));
        assertFalse(validator.IsSubtractValid("MIC".toCharArray()));
        assertFalse(validator.IsSubtractValid("MIV".toCharArray()));
        assertFalse(validator.IsSubtractValid("MIL".toCharArray()));
        assertFalse(validator.IsSubtractValid("MID".toCharArray()));
    }
}
