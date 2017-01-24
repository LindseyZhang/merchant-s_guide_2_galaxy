package main.java.util;

import main.java.BasicInfo;

import java.util.Vector;

public class RomanNumberConvertor {

    public static int romanNumberToInteger(String roman) {
        SymbolsValidator validator = new SymbolsValidator();
        if (!validator.isRomanValid(roman)) {
            System.err.println("Invalid Roman : " + roman);
            return 0;
        }

        Vector<Vector<Character>> single_values = BasicInfo.splitSymbolsToElement(roman.toCharArray());

        int result = 0;
        for (Vector<Character> single : single_values) {
            if (1 == single.size()) {
               result += BasicInfo.getSymbolValue(single.firstElement());
                continue;
            }
            if ( 2 == single.size()) {
                result += BasicInfo.subtractResult(single.elementAt(0), single.elementAt(1));
            }
        }
        return result;
    }

}
