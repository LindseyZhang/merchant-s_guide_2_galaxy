package test.testQuestion;

import main.PriceCenter;
import main.question.HowManyQuestion;
import main.question.QuestionBase;
import org.junit.Test;

public class TestHowManyQuestion {
    @Test
    public void TestAnswerQuestion() {
        String question = "how many Credits is glob prok Silver ?";
        PriceCenter priceCenter = new PriceCenter();

        QuestionBase questionHandler = new HowManyQuestion(priceCenter);
        questionHandler.handleQuestion(question);
    }
}
