package question;

import infocontainer.GalaxyRomanInfo;
import util.RomanNumberConvertor;

import java.util.regex.Pattern;

public class QuestionHandlerForHowManyType extends QuestionHandler {

    public QuestionHandlerForHowManyType(GalaxyRomanInfo galaxyRomanInfo) {
        super(galaxyRomanInfo);
        String questin_pattern = "how many Credits is (.*?) \\?";
        pattern = Pattern.compile(questin_pattern);
    }

    @Override
    public String answerQuestion(String question) {
        if (matcher.matches()) {
            String[] symbols = matcher.group(1).split(" ");

            StringBuilder strBuilder = new StringBuilder();
            String valueSymbol = null;

            for (String symbol : symbols) {
                if (galaxyRomanInfo.NoSymbol != galaxyRomanInfo.getBasicSymbol(symbol)) {
                    strBuilder.append(galaxyRomanInfo.getBasicSymbol(symbol));
                } else {
                    valueSymbol = symbol;
                }
            }

            int total = (int) (RomanNumberConvertor.romanNumberToInteger(strBuilder.toString())
                    * galaxyRomanInfo.getMissingSymbolValue(valueSymbol));
            String result = matcher.group(1) + " is " + total + " Credits\n";
            return result;
        }
        return null;
    }
}
