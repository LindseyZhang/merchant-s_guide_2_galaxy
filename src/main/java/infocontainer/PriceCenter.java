package infocontainer;

import java.util.HashMap;
import java.util.Map;

public class PriceCenter {
    public char NoSymbol = '\0';
    public double NoMissingSymbol = '0';
    private Map<String, Character> basicSymbolMap = new HashMap<String, Character>();
    private Map<String, Double> missingSymbolMap = new HashMap<String, Double>();

    public void addBasicSymbolMap(String object, Character romanPrice) {
        basicSymbolMap.put(object, romanPrice);
    }

    public char getBasicSymbol(String object) {
        if (basicSymbolMap.containsKey(object)) {
        return basicSymbolMap.get(object);
        } else {
            return NoSymbol;
        }
    }

    public double getMissingSymbolValue(String key) {
        if (missingSymbolMap.containsKey(key)) {
            return missingSymbolMap.get(key);
        } else {
            return NoMissingSymbol;
        }
    }

    public void addMissingSymbol(String key, double value) {
        missingSymbolMap.put(key, value);
    }

}
