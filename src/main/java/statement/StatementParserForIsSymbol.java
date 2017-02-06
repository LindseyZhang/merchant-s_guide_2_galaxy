package statement;

import infocontainer.BasicRomanValueInfo;
import infocontainer.GalaxyRomanInfo;

import java.util.regex.Pattern;

public class StatementParserForIsSymbol extends StatementParser {
    public StatementParserForIsSymbol(GalaxyRomanInfo galaxyRomanInfo) {
        super(galaxyRomanInfo);
        String statementPattern = "([a-zA-Z]*?) is ([a-zA-Z])";
        pattern = Pattern.compile(statementPattern);
    }

    @Override
    public void parseStatement(String statement) {
        if (matcher.matches()) {
            char[] symbols = matcher.group(2).toCharArray();
            if (symbols.length >= 1) {
                if (BasicRomanValueInfo.isBasicSymbol(symbols[0])) {
                    galaxyRomanInfo.addBasicSymbolMap(matcher.group(1), symbols[0]);
                } else {
                    System.out.println( symbols[0] + " not a valid Symbol");
                }
            }
        }
    }
}
