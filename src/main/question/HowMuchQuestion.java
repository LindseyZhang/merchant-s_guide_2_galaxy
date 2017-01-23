package main.question;

import java.util.regex.Pattern;

public class HowMuchQuestion extends QuestionBase {
    public HowMuchQuestion() {
        String questin_pattern = "how much is (.*?) ?";
        pattern = Pattern.compile(questin_pattern);
    }

    @Override
    public String answerQuestion() {
        return null;
    }
}
