package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class BasicInfo {
    private static Map<Character, Integer> symbolValueMap = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public static int GetSymbolValue(char symbol) {
        if (IsBasicSymbol(symbol)) {
            return symbolValueMap.get(symbol);
        }
        return 0;
    }

    public static boolean IsBasicSymbolString(String symbols) {
        for (char symbol : symbols.toCharArray()) {
            if (!IsBasicSymbol(symbol)) {
                System.err.println(symbol + " is not a basic symbol");
                return false;
            }
        }
        return true;
    }

    public static boolean IsBasicSymbol(char symbol) {
        return symbolValueMap.containsKey(symbol);
    }

    public static boolean FirstSymbolSmallerThanSecond(char first, char second) {
        if (IsBasicSymbol(first) && IsBasicSymbol(second)) {
            if (symbolValueMap.get(first) < symbolValueMap.get(second)) return true;
        }
        return false;
    }

    public static int SubtractResult(char front, char back) {
        if (!IsBasicSymbol(front) || !IsBasicSymbol(back)) {
            System.err.println("Not Valid Subtract pair:" + front + back);
            return 0;
        }

        int temp = symbolValueMap.get(back) - symbolValueMap.get(front);
        if (temp > 0) {
            return temp;
        } else {
            System.err.println("front symbol must smaller than back symbol");
            return 0;
        }
    }

    public static Vector<Vector<Character>> SplitSymbolsToSingleValue(char[] symbolsArray) {
        Vector<Vector<Character>> result = new Vector<Vector<Character>>();
        Vector<Character> item = new Vector<Character>();
        for (int i = 0; i < symbolsArray.length; ++i) {
            item.add(symbolsArray[i]);
            if (NoSmallerThanRest(i, symbolsArray)) {
                result.add(item);
                item = new Vector<Character>();
            }
        }
        return result;
    }

    private static boolean NoSmallerThanRest(int pos, char[] symbolsArray) {
        for (int i = pos + 1; i < symbolsArray.length; ++i) {
            if (FirstSymbolSmallerThanSecond(symbolsArray[pos], symbolsArray[i])) {
                return false;
            }
        }
        return true;
    }

}
