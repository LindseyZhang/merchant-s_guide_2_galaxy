package main.java.util;

import main.java.BasicInfo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Vector;

public class SymbolsValidator {
    private static final int REPEAT_LIMIT = 2;
    private static final int MAX_COMBINE_SYMBOL_SIZE = 2;
    private static final int MAX_SUCCESSION_TIME = 3;
    private char[] symbolsArray;

    public SymbolsValidator() {
    }

    public boolean isRomanValid(String roman) {

        boolean test = BasicInfo.isBasicSymbolString(roman);
        if (!BasicInfo.isBasicSymbolString(roman)) return false;
        symbolsArray = roman.toCharArray();

        return repeatInSuccessionMaxThreeTimesRule()
                && neverRepeatRule()
                && onlyOneSmallSymbolSubstractedFromRule()
                && subtractRule(symbolsArray);
    }

    private boolean repeatInSuccessionMaxThreeTimesRule() {
        char[] targets = {'I', 'X', 'C', 'N'};

        char cur;
        if (symbolsArray.length <= MAX_SUCCESSION_TIME) {
            return true;
        }
        cur = symbolsArray[0];
        int count = 1;

        for (int i = 1; i < symbolsArray.length; ++i) {
            if (!charInTarget(cur, targets)) {
                cur = symbolsArray[i];
                continue;
            }

            if (cur == symbolsArray[i]) {
                ++count;
                if (MAX_SUCCESSION_TIME < count) return false;
            } else {
                cur = symbolsArray[i];
                count = 1;
            }
        }
        return true;
    }

    private boolean neverRepeatRule() {
        char[] targets = {'D', 'L', 'V'};
        Map<Character, Integer> result = new HashMap<Character, Integer>();

        for (int i = 0; i < symbolsArray.length; ++i) {
            if (!charInTarget(symbolsArray[i], targets)) continue;

            if (!result.containsKey(symbolsArray[i])) {
                result.put(symbolsArray[i], 1);
            } else {
                result.put(symbolsArray[i], result.get(symbolsArray[i]) + 1);
                if (result.get(symbolsArray[i]) >= REPEAT_LIMIT) return false;
            }
        }
        return true;
    }

    private boolean charInTarget(char symbol, char[] targets) {
        for (int i = 0; i < targets.length; ++i) {
            if (symbol == targets[i]) return true;
        }
        return false;
    }

    private boolean subtractRule(char[] array) {
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

        return subtractRestrict.isSubtractValidSymbol(array);
    }


    private boolean onlyOneSmallSymbolSubstractedFromRule() {
        Vector<Vector<Character>> symbols = BasicInfo.splitSymbolsToElement(symbolsArray);
        for (Vector<Character> singleValue : symbols) {
            if (singleValue.size() > MAX_COMBINE_SYMBOL_SIZE) {
                return false;
            }
        }
        return true;
    }
}
