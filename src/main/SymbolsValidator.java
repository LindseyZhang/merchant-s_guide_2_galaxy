package main;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Vector;

public class SymbolsValidator {
    private static final int RepeatLimit = 2;
    private static final int MaxCombineSymbolSize = 2;
    private static final int MaxSuccessionTime = 3;
    private char[] symbolsArray;

    public SymbolsValidator() {
    }

    public boolean IsRomanValid(String roman) {

        boolean test = BasicInfo.IsBasicSymbolString(roman);
        if (!BasicInfo.IsBasicSymbolString(roman)) return false;
        symbolsArray = roman.toCharArray();

        return RepeatInSuccessionMaxThreeTimesRule()
                && NeverRepeatRule()
                && OnlyOneSmallSymbolSubstractedFromRule()
                && SubtractRule(symbolsArray);
    }

    private boolean RepeatInSuccessionMaxThreeTimesRule() {
        char[] targets = {'I', 'X', 'C', 'N'};

        char cur;
        if (symbolsArray.length <= MaxSuccessionTime) {
            return true;
        }
        cur = symbolsArray[0];
        int count = 1;

        for (int i = 1; i < symbolsArray.length; ++i) {
            if (!CharInTarget(cur, targets)) {
                cur = symbolsArray[i];
                continue;
            }

            if (cur == symbolsArray[i]) {
                ++count;
                if (MaxSuccessionTime < count) return false;
            } else {
                cur = symbolsArray[i];
                count = 1;
            }
        }
        return true;
    }

    private boolean NeverRepeatRule() {
        char[] targets = {'D', 'L', 'V'};
        Map<Character, Integer> result = new HashMap<Character, Integer>();

        for (int i = 0; i < symbolsArray.length; ++i) {
            if (!CharInTarget(symbolsArray[i], targets)) continue;

            if (!result.containsKey(symbolsArray[i])) {
                result.put(symbolsArray[i], 1);
            } else {
                result.put(symbolsArray[i], result.get(symbolsArray[i]) + 1);
                if (result.get(symbolsArray[i]) >= RepeatLimit) return false;
            }
        }
        return true;
    }

    private boolean CharInTarget(char symbol, char[] targets) {
        for (int i = 0; i < targets.length; ++i) {
            if (symbol == targets[i]) return true;
        }
        return false;
    }

    private boolean SubtractRule(char[] array) {
        SubtractRestrict subtractRestrict = new SubtractRestrict();
        subtractRestrict.addSubtractFromRule('I', new HashSet<Character>() {{
            add('V');
            add('X');
        }});

        subtractRestrict.addSubtractFromRule('X', new HashSet<Character>() {{
            add('L');
            add('C');
        }});
        subtractRestrict.addSubtractFromRule('C', new HashSet<Character>() {{
            add('D');
            add('M');
        }});

        subtractRestrict.addNeverSubtractRule('V');
        subtractRestrict.addNeverSubtractRule('L');
        subtractRestrict.addNeverSubtractRule('D');

        return subtractRestrict.IsSubtractValidSymbol(array);
    }


    private boolean OnlyOneSmallSymbolSubstractedFromRule() {
        Vector<Vector<Character>> symbols = BasicInfo.SplitSymbolsToSingleValue(symbolsArray);
        for (Vector<Character> singleValue : symbols) {
            if (singleValue.size() > MaxCombineSymbolSize) {
                return false;
            }
        }
        return true;
    }
}
