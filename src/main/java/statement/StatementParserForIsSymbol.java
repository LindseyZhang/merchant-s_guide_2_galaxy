package statement;

import infocontainer.GalaxyRomanInfo;

import java.util.regex.Pattern;

public class StatementParserForIsSymbol extends StatementParser {
    public StatementParserForIsSymbol(GalaxyRomanInfo galaxyRomanInfo) {
        super(galaxyRomanInfo);
        String questin_pattern = "(.*?) is (.*?)";
        pattern = Pattern.compile(questin_pattern);
    }

    @Override
    public void parseStatement(String statement) {
        if (matcher.matches()) {
            char[] symbols = matcher.group(2).toCharArray();
            if (symbols.length >= 1) {
                galaxyRomanInfo.addBasicSymbolMap(matcher.group(1), symbols[0]);
            }
        }
    }
}
