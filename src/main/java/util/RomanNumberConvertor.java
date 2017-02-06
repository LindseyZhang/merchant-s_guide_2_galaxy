package util;

import infocontainer.BasicRomanValueInfo;

import java.util.Vector;

public class RomanNumberConvertor {

    public static int romanNumberToInteger(String roman) {
        SymbolsValidator validator = new SymbolsValidator();
        if (!validator.isRomanValid(roman)) {
            System.err.println("Invalid Roman : " + roman);
            return 0;
        }

        Vector<Vector<Character>> singleValues = BasicRomanValueInfo.splitSymbolsToElement(roman.toCharArray());

        int result = 0;
        for (Vector<Character> single : singleValues) {
            if (1 == single.size()) {
               result += BasicRomanValueInfo.getSymbolValue(single.firstElement());
                continue;
            }
            if ( 2 == single.size()) {
                result += BasicRomanValueInfo.subtractResult(single.elementAt(0), single.elementAt(1));
            }
        }
        return result;
    }

}
