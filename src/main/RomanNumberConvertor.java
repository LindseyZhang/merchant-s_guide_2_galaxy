package main;


import java.util.Vector;

public class RomanNumberConvertor {

    public static int RomanNumberToInteger(String roman) {
        SymbolsValidator validator = new SymbolsValidator();
        if (!validator.IsRomanValid(roman)) {
            System.err.println("Invalid Roman : " + roman);
            return 0;
        }

        SymbolsSplitor splitor = new SymbolsSplitor();
        Vector<Vector<Character>> single_values = splitor.SymbolsSplit(roman.toCharArray());

        int result = 0;
        for (Vector<Character> single : single_values) {
            if (1 == single.size()) {
               result += BasicInfo.GetSymbolValue(single.firstElement());
                continue;
            }
            if ( 2 == single.size()) {
                result += BasicInfo.SubtractResult(single.elementAt(0),single.elementAt(1));
            }
        }
        return result;
    }

    public String IntegerToRomanNumber(int number) {
        return null;
    }





}
