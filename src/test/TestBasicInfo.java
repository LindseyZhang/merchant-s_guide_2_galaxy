package test;

import main.BasicInfo;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.Vector;

public class TestBasicInfo {

    @Test
    public void TestGetSymbolValue() {
        assertEquals(BasicInfo.GetSymbolValue('I'), 1);
        assertEquals(BasicInfo.GetSymbolValue('V'), 5);
        assertEquals(BasicInfo.GetSymbolValue('X'), 10);
        assertEquals(BasicInfo.GetSymbolValue('L'), 50);
        assertEquals(BasicInfo.GetSymbolValue('C'), 100);
        assertEquals(BasicInfo.GetSymbolValue('D'), 500);
        assertEquals(BasicInfo.GetSymbolValue('M'), 1000);
        assertEquals(BasicInfo.GetSymbolValue('T'), 0);
    }

    @Test
    public void TestIsBasicSymbolString() {
        assertTrue(BasicInfo.IsBasicSymbolString("IVXM"));
        assertTrue(BasicInfo.IsBasicSymbolString("MDC"));
        assertTrue(BasicInfo.IsBasicSymbolString("MDCL"));
        assertFalse(BasicInfo.IsBasicSymbolString("IVBM"));
        assertFalse(BasicInfo.IsBasicSymbolString("DAK"));
        assertFalse(BasicInfo.IsBasicSymbolString("0"));
        assertFalse(BasicInfo.IsBasicSymbolString(" "));
    }

    @Test
    public void TestIsBaicSymbol() {
        assertTrue(BasicInfo.IsBasicSymbol('I'));
        assertTrue(BasicInfo.IsBasicSymbol('C'));
        assertFalse(BasicInfo.IsBasicSymbol('B'));
        assertFalse(BasicInfo.IsBasicSymbol('c'));
    }

    @Test
    public void TestFirstSymbolSmallerThanSecond() {
        assertTrue(BasicInfo.FirstSymbolSmallerThanSecond('I', 'V'));
        assertTrue(BasicInfo.FirstSymbolSmallerThanSecond('V', 'X'));
        assertFalse(BasicInfo.FirstSymbolSmallerThanSecond('B', 'M'));
        assertFalse(BasicInfo.FirstSymbolSmallerThanSecond('M', 'D'));
        assertFalse(BasicInfo.FirstSymbolSmallerThanSecond('D', 'v'));
    }

    @Test
    public void TestSubtractResult() {
        assertEquals(BasicInfo.SubtractResult('I', 'V'), 4);
        assertEquals(BasicInfo.SubtractResult('V', 'I'), 0);
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

        assertEquals(BasicInfo.SplitSymbolsToSingleValue("MCMIII".toCharArray()), expect_result);

    }
}
