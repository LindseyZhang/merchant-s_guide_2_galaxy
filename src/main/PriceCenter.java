package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class PriceCenter {
    private
    Map<String,Character> prices = new HashMap<String, Character>();

    public void addItemPrice(String object, Character romanPrice) {
            prices.put(object, romanPrice);
    }


    public char getItemPrice(String object) {
        if (prices.containsKey(object)) {
        return prices.get(object);
        } else {
            return ' ';
        }
    }

    public void GeneratePriceInfo(Vector<String> statements) {

    }

}
