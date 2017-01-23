package test;

import main.BasicInfo;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class TestBasicInfo {

    private BasicInfo basicInfo;

    @Before
    public void setUp() throws Exception {
        basicInfo = new BasicInfo();
    }

    @Test
    public void TestIsBaicSymbol() {
        assertTrue(basicInfo.IsBasicSymbol('I'));
        assertTrue(basicInfo.IsBasicSymbol('C'));
        assertFalse(basicInfo.IsBasicSymbol('B'));
        assertFalse(basicInfo.IsBasicSymbol('c'));
    }

    @Test
    public void TestFirstSymbolSmallerThanSecond() {
        assertTrue(basicInfo.FirstSymbolSmallerThanSecond('I', 'V'));
        assertTrue(basicInfo.FirstSymbolSmallerThanSecond('V', 'X'));
        assertFalse(basicInfo.FirstSymbolSmallerThanSecond('B', 'M'));
        assertFalse(basicInfo.FirstSymbolSmallerThanSecond('M', 'D'));
        assertFalse(basicInfo.FirstSymbolSmallerThanSecond('D', 'v'));
    }

}
