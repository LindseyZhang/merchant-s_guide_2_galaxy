package statement;

import infocontainer.PriceCenter;

import java.util.regex.Pattern;

public class StatementParserForIsSymbol extends StatementParser {
    public StatementParserForIsSymbol(PriceCenter priceCenter) {
        super(priceCenter);
        String questin_pattern = "(.*?) is (.*?)";
        pattern = Pattern.compile(questin_pattern);
    }

    @Override
    public void parseStatement(String statement) {
        if (matcher.matches()) {
            char[] symbols = matcher.group(2).toCharArray();
            if (symbols.length >= 1) {
                priceCenter.addBasicSymbolMap(matcher.group(1), symbols[0]);
            }
        }
    }
}
