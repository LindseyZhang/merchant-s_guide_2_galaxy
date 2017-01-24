package main.question;

import main.PriceCenter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class QuestionBase {
    private static String defaultAnswer = "I have no idea what you are talking about\n";
    private QuestionBase nextHandler = null;
    protected PriceCenter priceCenter;
    Pattern pattern;
    Matcher matcher;

    protected QuestionBase(PriceCenter priceCenter) {
        this.priceCenter = priceCenter;
    }

    public void SetNextHandler(QuestionBase nextHandler) {
        this.nextHandler = nextHandler;
    }

    public String HandleQuestion(String question) {
        if (IsThisQuestion(question)) {
            return AnswerQuestion(question);
        }
        if (nextHandler == null) {
            return defaultAnswer;
        }
        return nextHandler.HandleQuestion(question);
    }

    public abstract String AnswerQuestion(String question);

    public boolean IsThisQuestion(String question) {
        matcher = pattern.matcher(question);
        return matcher.matches();
    }
}
