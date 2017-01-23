package main;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Vector;

public class SymbolsValidator {
    private static final int DLVRepeatLimit = 2;
    private BasicInfo basicInfo = new BasicInfo();
    private char[] symbolsArray;


    public SymbolsValidator() {
    }

    public boolean IsRomanValid(String roman) {
        if (!basicInfo.IsBasicSymbolString(roman)) return false;
        symbolsArray = roman.toCharArray();
        return IsIXCMRepeatInSuccessionMaxThreeTimes()
                && DLVCanNeverRepeat()
                && IsOnlyOneSmallSymbolSubstractedFrom()
                && IsSubtractValid(symbolsArray);
    }

    public boolean IsIXCMRepeatInSuccessionMaxThreeTimes(){
        char[] targets = {'I','X','C','N'};

        char cur;
        if (symbolsArray.length <= 3){
            return true;
        }
        cur = symbolsArray[0];
        int count = 1;
        for (int i = 1; i < symbolsArray.length; ++i){
            if (!CharInTarget(cur, targets)) continue;

            if (cur == symbolsArray[i]) {
                ++count;
                if (3 == count) return false;
            } else {
                //TODO They may appear four times if the third and fourth are separated by a smaller value, such as XXXIX
                cur = symbolsArray[i];
                count = 1;
            }
        }
        return true;
    }


    //"D", "L", and "V" can never be repeated.
    public boolean DLVCanNeverRepeat() {
        char[] targets = {'D','L','V'};
        Map<Character,Integer>  result = new HashMap<Character,Integer>();

        for (int i = 0; i < symbolsArray.length; ++i) {
            if (!CharInTarget(symbolsArray[i], targets)) continue;

            if (!result.containsKey(symbolsArray[i])) {
                result.put(symbolsArray[i], 1);
            } else {
                result.put(symbolsArray[i], result.get(symbolsArray[i]) + 1);
                if (result.get(symbolsArray[i]) >= DLVRepeatLimit) return false;
            }
        }
        return true;
    }

    private boolean CharInTarget(char symbol, char[] targets){
        for (int i = 0; i < targets.length; ++i) {
            if (symbol == targets[i]) return true;
        }
        return false;
    }

   public boolean IsSubtractValid (char[] array) {
       SubtractRestrict subtractRestrict = new SubtractRestrict();
       subtractRestrict.addSubtractFromRule('I',
               new HashSet<Character>() {{
                   add('V');
                   add('X');
               }});

       subtractRestrict.addSubtractFromRule('X',
               new HashSet<Character>() {{
                   add('L');
                   add('C');
               }});
       subtractRestrict.addSubtractFromRule('C',
               new HashSet<Character>() {{
                   add('C');
                   add('M');
               }});
       subtractRestrict.addNeverSubtractRule('V');
       subtractRestrict.addNeverSubtractRule('L');
       subtractRestrict.addNeverSubtractRule('D');

       return subtractRestrict.IsSubtractValidSymbol(array);
   }


    private boolean IsOnlyOneSmallSymbolSubstractedFrom() {

        SymbolsSplitor splitor = new SymbolsSplitor();
        Vector<Vector<Character>> symbols = splitor.SymbolsSplit(symbolsArray);
        for (Vector<Character> singleValue: symbols) {
            if (singleValue.size() > 2) {
                return false;
            }
        }
        return true;
    }
}
