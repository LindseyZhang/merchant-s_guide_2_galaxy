package main.question;

import java.util.regex.Pattern;

public class HowManyQuestion extends QuestionBase {
    public HowManyQuestion() {
        String questin_pattern = "how many Credits is (.*?) ?";
        pattern = Pattern.compile(questin_pattern);
    }

    @Override
    public String answerQuestion() {
      //matcher = 
        return null;
    }
}
