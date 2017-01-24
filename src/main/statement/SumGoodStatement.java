package main.statement;

import main.PriceCenter;
import main.RomanNumberConvertor;

import java.util.regex.Pattern;

public class SumGoodStatement extends StatementBase {
    private RomanNumberConvertor convertor = new RomanNumberConvertor();

    public SumGoodStatement(PriceCenter priceCenter) {
        super(priceCenter);
        String statement_pattern = "(.*?) is ([0-9]+) Credits";
        pattern = Pattern.compile(statement_pattern);
    }

    @Override
    public void ParseStatement(String statement) {
        if (matcher.matches()) {
            String[] symbols = matcher.group(1).split("\\s+");
            double total_value = Double.valueOf(matcher.group(2));

            StringBuilder strBuilder = new StringBuilder();
            String missingSymbol = null;
            for (String symbol : symbols) {
                if (priceCenter.NoSymbol != priceCenter.GetBasicSymbol(symbol)) {
                    strBuilder.append(priceCenter.GetBasicSymbol(symbol));
                } else {
                    missingSymbol = symbol;
                }
            }

            priceCenter.AddMissingSymbol(missingSymbol,
                    total_value / convertor.RomanNumberToInteger(strBuilder.toString()));
        }
    }
}
