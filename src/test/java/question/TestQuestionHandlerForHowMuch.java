package question;

import infocontainer.GalaxyRomanInfo;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class TestQuestionHandlerForHowMuch {
    @Test
    public void TestAnswerQuestion() {
        String question = "how much is pish tegj glob glob ?";
        GalaxyRomanInfo galaxyRomanInfo = new GalaxyRomanInfo();
        galaxyRomanInfo.addBasicSymbolMap("pish", 'X');
        galaxyRomanInfo.addBasicSymbolMap("tegj", 'L');
        galaxyRomanInfo.addBasicSymbolMap("glob", 'I');

        QuestionHandler questionHandler = new QuestionHandlerForHowMuch(galaxyRomanInfo);
        String answer = questionHandler.handleQuestion(question);

        String expect_result = "pish tegj glob glob is 42\n";
        assertEquals(answer, expect_result);
    }
}
