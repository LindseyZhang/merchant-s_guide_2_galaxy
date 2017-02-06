package util;

import infocontainer.BasicRomanValueInfo;

import java.util.HashMap;
import java.util.Map;

public class SymbolsValidator {
    private Map<String, Integer> allRoman;

    public SymbolsValidator() {
        InitAllRoman();
    }

    public boolean isRomanValid(String roman) {
        if (!BasicRomanValueInfo.isBasicSymbolString(roman)) return false;
        return allRoman.containsKey(roman);
    }

    private void InitAllRoman() {
        allRoman = new HashMap<String, Integer> ();

        String[][] allPos = new String[][]{
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"", "M", "MM", "MMM"}
        };

        for (int i = 0; i <=3999; ++i) {
            StringBuilder strBuilder = new StringBuilder();
            strBuilder.append(allPos[3][i/1000%10]);
            strBuilder.append(allPos[2][i/100%10]);
            strBuilder.append(allPos[1][i/10%10]);
            strBuilder.append(allPos[0][i%10]);
            allRoman.put(strBuilder.toString(), i);
        }
    }
}
