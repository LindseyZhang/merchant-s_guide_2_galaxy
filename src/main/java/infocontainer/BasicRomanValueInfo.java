package infocontainer;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class BasicRomanValueInfo {
    private static Map<Character, Integer> symbolValueMap = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public static int getSymbolValue(char symbol) {
        if (isBasicSymbol(symbol)) {
            return symbolValueMap.get(symbol);
        }
        return 0;
    }

    public static boolean isBasicSymbolString(String symbols) {
        for (char symbol : symbols.toCharArray()) {
            if (!isBasicSymbol(symbol)) {
                System.err.println(symbol + " is not a basic symbol");
                return false;
            }
        }
        return true;
    }

    public static boolean isBasicSymbol(char symbol) {
        return symbolValueMap.containsKey(symbol);
    }

    public static boolean firstSymbolSmallerThanSecond(char first, char second) {
        if (isBasicSymbol(first) && isBasicSymbol(second)) {
            return (symbolValueMap.get(first) < symbolValueMap.get(second));
        }
        return false;
    }

    public static int subtractResult(char front, char back) {
        if (!isBasicSymbol(front) || !isBasicSymbol(back)) {
            System.err.println("Not Valid Subtract pair:" + front + back);
            return 0;
        }

        if (firstSymbolSmallerThanSecond(front, back)) {
            return symbolValueMap.get(back) - symbolValueMap.get(front);
        }

        System.err.println("front symbol must smaller than back symbol");
        return 0;
    }

    public static Vector<Vector<Character>> splitSymbolsToElement(char[] symbolsArray) {
        Vector<Vector<Character>> result = new Vector<Vector<Character>>();
        Vector<Character> item = new Vector<Character>();
        for (int i = 0; i < symbolsArray.length; ++i) {
            item.add(symbolsArray[i]);
            if (noSmallerThanRest(i, symbolsArray)) {
                result.add(item);
                item = new Vector<Character>();
            }
        }
        return result;
    }

    private static boolean noSmallerThanRest(int pos, char[] symbolsArray) {
        for (int i = pos + 1; i < symbolsArray.length; ++i) {
            if (firstSymbolSmallerThanSecond(symbolsArray[pos], symbolsArray[i])) {
                return false;
            }
        }
        return true;
    }

}
