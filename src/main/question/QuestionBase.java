package main.question;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class QuestionBase {
  private static String defaultAnswer = "I have no idea what you are talking about\n";
  private QuestionBase nextHandler;
  Pattern pattern;
  Matcher matcher;

  public void setNextHandler(QuestionBase nextHandler) {
    this.nextHandler = nextHandler;
  }

  public String handleQuestion(String question) {
    if (isThisQuestion(question)) {
      return answerQuestion();
    } 
    if (nextHandler == null) {
      return defaultAnswer;
    }
    return nextHandler.handleQuestion(question);
  }

  public abstract String answerQuestion();

  public boolean isThisQuestion(String question) {
    matcher = pattern.matcher(question);
    return matcher.matches();
  }
}
