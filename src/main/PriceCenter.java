package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class PriceCenter {
    public char NoSymbol = '\0';
    public double NoPrice = '0';
    private Map<String, Character> basicSymbolMap = new HashMap<String, Character>();
    private Map<String, Double> missingSymbolMap = new HashMap<String, Double>();

    public void AddBasicSymbolMap(String object, Character romanPrice) {
        basicSymbolMap.put(object, romanPrice);
    }

    public char GetBasicSymbol(String object) {
        if (basicSymbolMap.containsKey(object)) {
        return basicSymbolMap.get(object);
        } else {
            return NoSymbol;
        }
    }

    public double GetMissingSymbolValue(String key) {
        if (missingSymbolMap.containsKey(key)) {
            return missingSymbolMap.get(key);
        } else {
            return NoPrice;
        }
    }

    public void AddMissingSymbol(String key, double value) {
        missingSymbolMap.put(key, value);
    }

}
