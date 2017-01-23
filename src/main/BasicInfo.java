package main;

import java.util.HashMap;
import java.util.Map;

public class BasicInfo {
    private Map<Character, Integer> symbolValueMap = new HashMap<Character, Integer>();

    public BasicInfo() {
        InitSymbolValueMap();
    }

    public boolean IsBasicSymbolString(String symbols) {
        for (char symbol: symbols.toCharArray()) {
            if (!IsBasicSymbol(symbol)) return false;
        }
        return true;
    }

    public boolean IsBasicSymbol(char symbol) {
        return symbolValueMap.containsKey(symbol);
    }

    public boolean FirstSymbolSmallerThanSecond (char first, char second){
        if (IsBasicSymbol(first) && IsBasicSymbol(second)) {
            if (symbolValueMap.get(first) < symbolValueMap.get(second)) return true;
        }
        return false;
    }

    private void InitSymbolValueMap() {
        symbolValueMap.put('I',1);
        symbolValueMap.put('V',5);
        symbolValueMap.put('X',10);
        symbolValueMap.put('L',50);
        symbolValueMap.put('C',100);
        symbolValueMap.put('D',500);
        symbolValueMap.put('M',1000);
    }

}
