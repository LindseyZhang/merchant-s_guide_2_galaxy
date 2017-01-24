package main.java.question;

import main.java.PriceCenter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class QuestionBase {
    private static String DEFAULT_ANSWER = "I have no idea what you are talking about\n";
    private QuestionBase nextHandler = null;
    protected PriceCenter priceCenter;
    Pattern pattern;
    Matcher matcher;

    protected QuestionBase(PriceCenter priceCenter) {
        this.priceCenter = priceCenter;
    }

    public void setNextHandler(QuestionBase nextHandler) {
        this.nextHandler = nextHandler;
    }

    public String handleQuestion(String question) {
        if (isThisQuestion(question)) {
            return answerQuestion(question);
        }
        if (nextHandler == null) {
            return DEFAULT_ANSWER;
        }
        return nextHandler.handleQuestion(question);
    }

    public abstract String answerQuestion(String question);

    public boolean isThisQuestion(String question) {
        matcher = pattern.matcher(question);
        return matcher.matches();
    }
}
