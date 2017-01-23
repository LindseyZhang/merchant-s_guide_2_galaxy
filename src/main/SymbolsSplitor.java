package main;

import java.util.Vector;

public class SymbolsSplitor {
    private BasicInfo basicInfo = new BasicInfo();

    public Vector<Vector<Character>> SymbolsSplit(char[] symbolsArray) {
        Vector<Vector<Character>> result = new Vector<Vector<Character>>();
        Vector<Character> item = new Vector<Character>();
        for (int i = 0; i < symbolsArray.length; ++i) {
            item.add(symbolsArray[i]);
            if (NoSmallerThanRest(i,symbolsArray)) {
                result.add(item);
                item = new Vector<Character>();
            }
        }
        return result;
    }

    private boolean NoSmallerThanRest(int pos, char[] symbolsArray) {
        for (int i = pos + 1; i < symbolsArray.length; ++i) {
            if (basicInfo.FirstSymbolSmallerThanSecond(symbolsArray[pos],symbolsArray[i])) {
                return false;
            }
        }
        return true;
    }
}
