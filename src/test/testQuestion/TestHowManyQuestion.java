package test.testQuestion;

import main.PriceCenter;
import main.question.HowManyQuestion;
import main.question.QuestionBase;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class TestHowManyQuestion {
    @Test
    public void TestAnswerQuestion() {
        String question = "how many Credits is glob prok Silver ?";

        PriceCenter priceCenter = new PriceCenter();
        priceCenter.AddBasicSymbolMap("prok", 'V');
        priceCenter.AddBasicSymbolMap("glob", 'I');
        priceCenter.AddMissingSymbol("Silver", 17.0);

        QuestionBase questionHandler = new HowManyQuestion(priceCenter);
        String answer = questionHandler.HandleQuestion(question);
        String expect_result = "glob prok Silver is 68 Credits\n";
        assertEquals(answer, expect_result);
    }
}
