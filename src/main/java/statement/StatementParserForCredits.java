package main.java.statement;

import main.java.PriceCenter;
import main.java.util.RomanNumberConvertor;

import java.util.regex.Pattern;

public class StatementParserForCredits extends StatementBase {
    private RomanNumberConvertor convertor = new RomanNumberConvertor();

    public StatementParserForCredits(PriceCenter priceCenter) {
        super(priceCenter);
        String statement_pattern = "(.*?) is ([0-9]+) Credits";
        pattern = Pattern.compile(statement_pattern);
    }

    @Override
    public void parseStatement(String statement) {
        if (matcher.matches()) {
            String[] symbols = matcher.group(1).split("\\s+");
            double total_value = Double.valueOf(matcher.group(2));

            StringBuilder strBuilder = new StringBuilder();
            String missingSymbol = null;
            for (String symbol : symbols) {
                if (priceCenter.NoSymbol != priceCenter.getBasicSymbol(symbol)) {
                    strBuilder.append(priceCenter.getBasicSymbol(symbol));
                } else {
                    missingSymbol = symbol;
                }
            }

            priceCenter.addMissingSymbol(missingSymbol,
                    total_value / convertor.romanNumberToInteger(strBuilder.toString()));
        }
    }
}
