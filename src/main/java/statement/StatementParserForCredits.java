package statement;

import infocontainer.GalaxyRomanInfo;
import util.RomanNumberConvertor;

import java.util.regex.Pattern;

public class StatementParserForCredits extends StatementParser {
    private RomanNumberConvertor convertor = new RomanNumberConvertor();

    public StatementParserForCredits(GalaxyRomanInfo galaxyRomanInfo) {
        super(galaxyRomanInfo);
        String statementPattern = "(.*?) is ([0-9]+) Credits";
        pattern = Pattern.compile(statementPattern);
    }

    @Override
    public void parseStatement(String statement) {
        if (matcher.matches()) {
            String[] symbols = matcher.group(1).split("\\s+");
            double totalValue = Double.valueOf(matcher.group(2));

            StringBuilder strBuilder = new StringBuilder();
            String missingSymbol = null;
            for (String symbol : symbols) {
                if (galaxyRomanInfo.NoSymbol != galaxyRomanInfo.getBasicSymbol(symbol)) {
                    strBuilder.append(galaxyRomanInfo.getBasicSymbol(symbol));
                } else {
                    missingSymbol = symbol;
                }
            }

            galaxyRomanInfo.addMissingSymbol(missingSymbol,
                    totalValue / convertor.romanNumberToInteger(strBuilder.toString()));
        }
    }
}
