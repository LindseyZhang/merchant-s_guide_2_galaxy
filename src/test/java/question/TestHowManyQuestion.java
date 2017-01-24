package question;

import infocontainer.PriceCenter;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class TestHowManyQuestion {
    @Test
    public void TestAnswerQuestion() {
        String question = "how many Credits is glob prok Silver ?";

        PriceCenter priceCenter = new PriceCenter();
        priceCenter.addBasicSymbolMap("prok", 'V');
        priceCenter.addBasicSymbolMap("glob", 'I');
        priceCenter.addMissingSymbol("Silver", 17.0);

        QuestionHandler questionHandler = new QuestionHandlerForHowManyType(priceCenter);
        String answer = questionHandler.handleQuestion(question);
        String expect_result = "glob prok Silver is 68 Credits\n";
        assertEquals(answer, expect_result);
    }
}
