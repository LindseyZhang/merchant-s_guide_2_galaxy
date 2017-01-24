package main;

import java.util.HashMap;
import java.util.Map;

public class BasicInfo {
    private static Map<Character, Integer> symbolValueMap = new HashMap<Character, Integer>();

    public BasicInfo() {
        InitSymbolValueMap();
    }

    public static int GetSymbolValue(char symbol) {
        if (IsBasicSymbol(symbol)) {
            return symbolValueMap.get(symbol);
        }
        return 0;
    }
    public static boolean IsBasicSymbolString(String symbols) {
        for (char symbol: symbols.toCharArray()) {
            if (!IsBasicSymbol(symbol)) return false;
        }
        return true;
    }

    public static boolean IsBasicSymbol(char symbol) {
        return symbolValueMap.containsKey(symbol);
    }

    public static boolean FirstSymbolSmallerThanSecond (char first, char second){
        if (IsBasicSymbol(first) && IsBasicSymbol(second)) {
            if (symbolValueMap.get(first) < symbolValueMap.get(second)) return true;
        }
        return false;
    }

    public static int SubtractResult(char front, char back) {
        if (IsBasicSymbol(front) && IsBasicSymbol(back)) {
            return (symbolValueMap.get(back) - symbolValueMap.get(front));
        }
        System.err.println("Not Valid Subtract pair:" + front + back);
        return 0;
    }

    private static void InitSymbolValueMap() {
        symbolValueMap.put('I',1);
        symbolValueMap.put('V',5);
        symbolValueMap.put('X',10);
        symbolValueMap.put('L',50);
        symbolValueMap.put('C',100);
        symbolValueMap.put('D',500);
        symbolValueMap.put('M',1000);
    }

}
