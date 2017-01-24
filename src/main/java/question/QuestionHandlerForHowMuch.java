package main.java.question;

import main.java.PriceCenter;
import main.java.util.RomanNumberConvertor;

import java.util.regex.Pattern;

public class QuestionHandlerForHowMuch extends QuestionBase {
    public QuestionHandlerForHowMuch(PriceCenter priceCenter) {
        super(priceCenter);
        String questin_pattern = "how much is (.*?)\\s\\?";
        pattern = Pattern.compile(questin_pattern);
    }

    @Override
    public String answerQuestion(String question) {
        if (matcher.matches()) {
            String[] symbols = matcher.group(1).split(" ");

            StringBuilder strBuilder = new StringBuilder();
            for (String symbol : symbols) {
                if (priceCenter.NoSymbol != priceCenter.getBasicSymbol(symbol)) {
                    strBuilder.append(priceCenter.getBasicSymbol(symbol));
                } else {
                    System.err.println("undefined symbol " + symbol);
                }
            }
            return matcher.group(1) + " is "
                    + RomanNumberConvertor.romanNumberToInteger(strBuilder.toString()) + "\n";
        }
        return null;
    }
}