package main;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubtractRestrict {
    private Map<Character, Set<Character>> subtractFromCharaters = new HashMap<Character, Set<Character>>();
    private Set<Character> neverSubtractCharacters = new HashSet<Character>();
    private BasicInfo basicInfo = new BasicInfo();

    public void addSubtractFromRule(Character symbol, Set<Character> froms) {

  /*      if (!basicInfo.IsBasicSymbol(symbol)) {
            System.out.println("Invalid symbol:" + symbol);
            return;
        }

        for (Character from : froms) {
            if (!basicInfo.IsBasicSymbol(symbol)) {
                System.out.println("Invalid symbol in froms:" + symbol);
                return;
            }
        }  */
        subtractFromCharaters.put(symbol, froms);
    }

    public void addNeverSubtractRule(Character symbol) {
     /*   if (!basicInfo.IsBasicSymbol(symbol)) {
            System.out.println("Invalid symbol:" + symbol);
            return;
        } */
        neverSubtractCharacters.add(symbol);
    }

    public boolean IsSubtractValidSymbol(char[] charArray) {
        for (int i = 0; i < charArray.length-1; ++i) {
            if (!IsSubtract(charArray[i], charArray[i+1])) continue;
            if (!(CheckSubtractedFromRule(charArray[i], charArray[i+1])
                    && CheckNeverSubtractRule(charArray[i]))) {
                return false;
            }
        }
        return true;
    }

    private boolean CheckSubtractedFromRule(char symbol,char from) {
        if (subtractFromCharaters.containsKey(symbol)) {
            Set<Character> validFrom = subtractFromCharaters.get(symbol);
            if (!validFrom.contains(from)) return false;
        }
        return true;
    }

    private boolean CheckNeverSubtractRule(char symbol) {
        if (neverSubtractCharacters.contains(symbol)) {
            return false;
        }
        return true;
    }

    private boolean IsSubtract(char first, char second) {
        return basicInfo.FirstSymbolSmallerThanSecond(first, second);
    }

}
