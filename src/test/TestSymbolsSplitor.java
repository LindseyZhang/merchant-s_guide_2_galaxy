package test;

import main.SymbolsSplitor;
import org.junit.Test;
import static junit.framework.Assert.assertTrue;

import java.util.Vector;

public class TestSymbolsSplitor {
    @Test
    public void TestSymbolsSplit() {
        String input ="MCMIII";
        Vector<Vector<Character>> expect_output = new Vector<Vector<Character>>();
        Vector<Character> singleValue1 = new Vector<Character>();
        singleValue1.add('M');
        expect_output.add(singleValue1);
        Vector<Character> singleValue2 = new Vector<Character>();
        singleValue2.add('C');
        singleValue2.add('M');
        expect_output.add(singleValue2);
        Vector<Character> singleValue3 = new Vector<Character>();
        singleValue3.add('I');
        expect_output.add(singleValue3);
        Vector<Character> singleValue4 = new Vector<Character>();
        singleValue4.add('I');
        expect_output.add(singleValue4);
        Vector<Character> singleValue5 = new Vector<Character>();
        singleValue5.add('I');
        expect_output.add(singleValue5);

        SymbolsSplitor splitor = new SymbolsSplitor();
        System.out.println(splitor.SymbolsSplit(input.toCharArray()));
        System.out.println(expect_output);
        assertTrue(expect_output.equals(splitor.SymbolsSplit(input.toCharArray())));
    }
}
