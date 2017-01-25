package infocontainer;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.Vector;

public class TestBasicRomanValueInfo {

    @Test
    public void TestGetSymbolValue() {
        assertEquals(BasicRomanValueInfo.getSymbolValue('I'), 1);
        assertEquals(BasicRomanValueInfo.getSymbolValue('V'), 5);
        assertEquals(BasicRomanValueInfo.getSymbolValue('X'), 10);
        assertEquals(BasicRomanValueInfo.getSymbolValue('L'), 50);
        assertEquals(BasicRomanValueInfo.getSymbolValue('C'), 100);
        assertEquals(BasicRomanValueInfo.getSymbolValue('D'), 500);
        assertEquals(BasicRomanValueInfo.getSymbolValue('M'), 1000);
        assertEquals(BasicRomanValueInfo.getSymbolValue('T'), 0);
    }

    @Test
    public void TestIsBasicSymbolString() {
        assertTrue(BasicRomanValueInfo.isBasicSymbolString("IVXM"));
        assertTrue(BasicRomanValueInfo.isBasicSymbolString("MDC"));
        assertTrue(BasicRomanValueInfo.isBasicSymbolString("MDCL"));
        assertFalse(BasicRomanValueInfo.isBasicSymbolString("IVBM"));
        assertFalse(BasicRomanValueInfo.isBasicSymbolString("DAK"));
        assertFalse(BasicRomanValueInfo.isBasicSymbolString("0"));
        assertFalse(BasicRomanValueInfo.isBasicSymbolString(" "));
    }

    @Test
    public void TestIsBaicSymbol() {
        assertTrue(BasicRomanValueInfo.isBasicSymbol('I'));
        assertTrue(BasicRomanValueInfo.isBasicSymbol('C'));
        assertFalse(BasicRomanValueInfo.isBasicSymbol('B'));
        assertFalse(BasicRomanValueInfo.isBasicSymbol('c'));
    }

    @Test
    public void TestFirstSymbolSmallerThanSecond() {
        assertTrue(BasicRomanValueInfo.firstSymbolSmallerThanSecond('I', 'V'));
        assertTrue(BasicRomanValueInfo.firstSymbolSmallerThanSecond('V', 'X'));
        assertFalse(BasicRomanValueInfo.firstSymbolSmallerThanSecond('B', 'M'));
        assertFalse(BasicRomanValueInfo.firstSymbolSmallerThanSecond('M', 'D'));
        assertFalse(BasicRomanValueInfo.firstSymbolSmallerThanSecond('D', 'v'));
    }

    @Test
    public void TestSubtractResult() {
        assertEquals(BasicRomanValueInfo.subtractResult('I', 'V'), 4);
        assertEquals(BasicRomanValueInfo.subtractResult('V', 'I'), 0);
    }

    @Test
    public void TestSplitSymbolsToSingleValue() {
        Vector<Vector<Character>> expect_result = new Vector<Vector<Character>>();
        Vector<Character> r1 = new Vector<Character>();
        r1.add('M');
        expect_result.add(r1);
        Vector<Character> r2 = new Vector<Character>();
        r2.add('C');
        r2.add('M');
        expect_result.add(r2);
        Vector<Character> r3 = new Vector<Character>();
        r3.add('I');
        expect_result.add(r3);
        expect_result.add(r3);
        expect_result.add(r3);

        assertEquals(BasicRomanValueInfo.splitSymbolsToElement("MCMIII".toCharArray()), expect_result);

    }
}
