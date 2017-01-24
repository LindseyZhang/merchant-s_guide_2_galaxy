package main.question;

import main.PriceCenter;
import main.RomanNumberConvertor;

import java.util.regex.Pattern;

public class HowManyQuestion extends QuestionBase {

    public HowManyQuestion(PriceCenter priceCenter) {
        super(priceCenter);
        String questin_pattern = "how many Credits is (.*?) \\?";
        pattern = Pattern.compile(questin_pattern);
    }

    @Override
    public String AnswerQuestion(String question) {
        if (matcher.matches()) {
            String[] symbols = matcher.group(1).split(" ");

            StringBuilder strBuilder = new StringBuilder();
            String valueSymbol = null;

            for (String symbol : symbols) {
                if (priceCenter.NoSymbol != priceCenter.GetBasicSymbol(symbol)) {
                    strBuilder.append(priceCenter.GetBasicSymbol(symbol));
                } else {
                    valueSymbol = symbol;
                }
            }

            int total = (int) (RomanNumberConvertor.RomanNumberToInteger(strBuilder.toString())
                    * priceCenter.GetMissingSymbolValue(valueSymbol));
            String result = matcher.group(1) + " is " + total + " Credits\n";
            return result;
        }
        return null;
    }
}
