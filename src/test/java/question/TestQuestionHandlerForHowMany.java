package question;

import infocontainer.GalaxyRomanInfo;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class TestQuestionHandlerForHowMany {
    @Test
    public void TestAnswerQuestion() {
        String question = "how many Credits is glob prok Silver ?";

        GalaxyRomanInfo galaxyRomanInfo = new GalaxyRomanInfo();
        galaxyRomanInfo.addBasicSymbolMap("prok", 'V');
        galaxyRomanInfo.addBasicSymbolMap("glob", 'I');
        galaxyRomanInfo.addMissingSymbol("Silver", 17.0);

        QuestionHandler questionHandler = new QuestionHandlerForHowManyType(galaxyRomanInfo);
        String answer = questionHandler.handleQuestion(question);
        String expect_result = "glob prok Silver is 68 Credits\n";
        assertEquals(answer, expect_result);
    }
}
