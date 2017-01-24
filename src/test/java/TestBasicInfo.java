import infocontainer.BasicInfo;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.Vector;

public class TestBasicInfo {

    @Test
    public void TestGetSymbolValue() {
        assertEquals(BasicInfo.getSymbolValue('I'), 1);
        assertEquals(BasicInfo.getSymbolValue('V'), 5);
        assertEquals(BasicInfo.getSymbolValue('X'), 10);
        assertEquals(BasicInfo.getSymbolValue('L'), 50);
        assertEquals(BasicInfo.getSymbolValue('C'), 100);
        assertEquals(BasicInfo.getSymbolValue('D'), 500);
        assertEquals(BasicInfo.getSymbolValue('M'), 1000);
        assertEquals(BasicInfo.getSymbolValue('T'), 0);
    }

    @Test
    public void TestIsBasicSymbolString() {
        assertTrue(BasicInfo.isBasicSymbolString("IVXM"));
        assertTrue(BasicInfo.isBasicSymbolString("MDC"));
        assertTrue(BasicInfo.isBasicSymbolString("MDCL"));
        assertFalse(BasicInfo.isBasicSymbolString("IVBM"));
        assertFalse(BasicInfo.isBasicSymbolString("DAK"));
        assertFalse(BasicInfo.isBasicSymbolString("0"));
        assertFalse(BasicInfo.isBasicSymbolString(" "));
    }

    @Test
    public void TestIsBaicSymbol() {
        assertTrue(BasicInfo.isBasicSymbol('I'));
        assertTrue(BasicInfo.isBasicSymbol('C'));
        assertFalse(BasicInfo.isBasicSymbol('B'));
        assertFalse(BasicInfo.isBasicSymbol('c'));
    }

    @Test
    public void TestFirstSymbolSmallerThanSecond() {
        assertTrue(BasicInfo.firstSymbolSmallerThanSecond('I', 'V'));
        assertTrue(BasicInfo.firstSymbolSmallerThanSecond('V', 'X'));
        assertFalse(BasicInfo.firstSymbolSmallerThanSecond('B', 'M'));
        assertFalse(BasicInfo.firstSymbolSmallerThanSecond('M', 'D'));
        assertFalse(BasicInfo.firstSymbolSmallerThanSecond('D', 'v'));
    }

    @Test
    public void TestSubtractResult() {
        assertEquals(BasicInfo.subtractResult('I', 'V'), 4);
        assertEquals(BasicInfo.subtractResult('V', 'I'), 0);
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

        assertEquals(BasicInfo.splitSymbolsToElement("MCMIII".toCharArray()), expect_result);

    }
}
