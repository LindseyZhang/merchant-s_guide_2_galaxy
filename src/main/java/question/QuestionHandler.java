package question;

import infocontainer.GalaxyRomanInfo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class QuestionHandler {
    private static String DEFAULT_ANSWER = "I have no idea what you are talking about\n";
    private QuestionHandler nextHandler = null;
    protected GalaxyRomanInfo galaxyRomanInfo;
    Pattern pattern;
    Matcher matcher;

    protected QuestionHandler(GalaxyRomanInfo galaxyRomanInfo) {
        this.galaxyRomanInfo = galaxyRomanInfo;
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
