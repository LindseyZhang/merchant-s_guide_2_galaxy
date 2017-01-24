package main.statement;

import main.PriceCenter;

import java.util.regex.Pattern;

public class IsSymbolStatement extends StatementBase {
    public IsSymbolStatement(PriceCenter priceCenter) {
        super(priceCenter);
        String questin_pattern = "(.*?) is (.*?)";
        pattern = Pattern.compile(questin_pattern);
    }

    @Override
    public void ParseStatement(String statement) {
        if (matcher.matches()) {
            char[] symbols = matcher.group(2).toCharArray();
            if (symbols.length >=1) {
             priceCenter.AddBasicSymbolMap(matcher.group(1), symbols[0]);
            }
        }
    }
}
