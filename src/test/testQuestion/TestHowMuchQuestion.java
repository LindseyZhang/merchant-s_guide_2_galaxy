package test.testQuestion;

import main.PriceCenter;
import main.question.HowMuchQuestion;
import main.question.QuestionBase;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class TestHowMuchQuestion {
    @Test
    public void TestAnswerQuestion() {
        String question = "how much is pish tegj glob glob ?";
        PriceCenter priceCenter = new PriceCenter();
        priceCenter.AddBasicSymbolMap("pish", 'X');
        priceCenter.AddBasicSymbolMap("tegj", 'L');
        priceCenter.AddBasicSymbolMap("glob", 'I');

        QuestionBase questionHandler = new HowMuchQuestion(priceCenter);
        String answer = questionHandler.HandleQuestion(question);

        String expect_result = "pish tegj glob glob is 42";
        assertEquals(answer, expect_result);
    }
}
