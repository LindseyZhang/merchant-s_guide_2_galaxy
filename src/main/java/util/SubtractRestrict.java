package util;

import infocontainer.BasicInfo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubtractRestrict {
    private Map<Character, Set<Character>> subtractFromCharaters = new HashMap<Character, Set<Character>>();
    private Set<Character> neverSubtractCharacters = new HashSet<Character>();

    public void addSubtractFromRule(Character symbol, Set<Character> froms) {
        if (!BasicInfo.isBasicSymbol(symbol)) {
            System.out.println("Invalid symbol:" + symbol);
            return;
        }

        for (Character from : froms) {
            if (!BasicInfo.isBasicSymbol(symbol)) {
                System.out.println("Invalid symbol in froms:" + symbol);
                return;
            }
        }  

        subtractFromCharaters.put(symbol, froms);
    }

    public void addNeverSubtractRule(Character symbol) {
        if (!BasicInfo.isBasicSymbol(symbol)) {
            System.out.println("Invalid symbol:" + symbol);
            return;
        } 
        neverSubtractCharacters.add(symbol);
    }

    public boolean isSubtractValidSymbol(char[] charArray) {
        for (int i = 0; i < charArray.length-1; ++i) {
            if (!isSubtract(charArray[i], charArray[i + 1])) continue;
            if (!(checkSubtractedFromRule(charArray[i], charArray[i + 1])
                    && checkNeverSubtractRule(charArray[i]))) {
                return false;
            }
        }
        return true;
    }

    private boolean checkSubtractedFromRule(char symbol, char from) {
        if (subtractFromCharaters.containsKey(symbol)) {
            Set<Character> validFrom = subtractFromCharaters.get(symbol);
            if (!validFrom.contains(from)) return false;
        }
        return true;
    }

    private boolean checkNeverSubtractRule(char symbol) {
        return !neverSubtractCharacters.contains(symbol);
    }

    private boolean isSubtract(char first, char second) {
        return BasicInfo.firstSymbolSmallerThanSecond(first, second);
    }

}
