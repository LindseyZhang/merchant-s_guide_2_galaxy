package test.java.question;

import main.java.PriceCenter;
import main.java.question.QuestionHandlerForHowMuch;
import main.java.question.QuestionBase;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class TestHowMuchQuestion {
    @Test
    public void TestAnswerQuestion() {
        String question = "how much is pish tegj glob glob ?";
        PriceCenter priceCenter = new PriceCenter();
        priceCenter.addBasicSymbolMap("pish", 'X');
        priceCenter.addBasicSymbolMap("tegj", 'L');
        priceCenter.addBasicSymbolMap("glob", 'I');

        QuestionBase questionHandler = new QuestionHandlerForHowMuch(priceCenter);
        String answer = questionHandler.handleQuestion(question);

        String expect_result = "pish tegj glob glob is 42\n";
        assertEquals(answer, expect_result);
    }
}
