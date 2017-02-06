package question;

import infocontainer.GalaxyRomanInfo;
import util.RomanNumberConvertor;

import java.util.regex.Pattern;

public class QuestionHandlerForHowMuch extends QuestionHandler {
    public QuestionHandlerForHowMuch(GalaxyRomanInfo galaxyRomanInfo) {
        super(galaxyRomanInfo);
        String questionPattern = "how much is (.*?)\\s\\?";
        pattern = Pattern.compile(questionPattern);
    }

    @Override
    public String answerQuestion(String question) {
        if (matcher.matches()) {
            String[] symbols = matcher.group(1).split(" ");

            StringBuilder strBuilder = new StringBuilder();
            for (String symbol : symbols) {
                if (galaxyRomanInfo.NoSymbol != galaxyRomanInfo.getBasicSymbol(symbol)) {
                    strBuilder.append(galaxyRomanInfo.getBasicSymbol(symbol));
                } else {
                    System.err.println("undefined symbol " + symbol);
                }
            }
            return matcher.group(1) + " is "
                    + RomanNumberConvertor.romanNumberToInteger(strBuilder.toString()) + "\n";
        }
        return "";
    }
}
