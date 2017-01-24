package main.question;

import main.BasicInfo;
import main.PriceCenter;
import main.RomanNumberConvertor;

import java.util.regex.Pattern;

public class HowMuchQuestion extends QuestionBase {
    public HowMuchQuestion(PriceCenter priceCenter) {
        super(priceCenter);
        String questin_pattern = "how much is (.*?)\\s\\?";
        pattern = Pattern.compile(questin_pattern);
    }

    @Override
    public String AnswerQuestion(String question) {
        if (matcher.matches()) {
            String[] symbols = matcher.group(1).split(" ");

            StringBuilder strBuilder = new StringBuilder();
            for (String symbol : symbols) {
                if (priceCenter.NoSymbol != priceCenter.GetBasicSymbol(symbol)) {
                    strBuilder.append(priceCenter.GetBasicSymbol(symbol));
                } else {
                    System.err.println("undefined symbol " + symbol);
                }
            }
            return matcher.group(1) + " is "
                    + RomanNumberConvertor.RomanNumberToInteger(strBuilder.toString()) + "\n";
        }
        return null;
    }
}
