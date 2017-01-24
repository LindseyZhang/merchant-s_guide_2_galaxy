package question;

import infocontainer.PriceCenter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class QuestionHandler {
    private static String DEFAULT_ANSWER = "I have no idea what you are talking about\n";
    private QuestionHandler nextHandler = null;
    protected PriceCenter priceCenter;
    Pattern pattern;
    Matcher matcher;

    protected QuestionHandler(PriceCenter priceCenter) {
        this.priceCenter = priceCenter;
    }

    public void setNextHandler(QuestionHandler nextHandler) {
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
