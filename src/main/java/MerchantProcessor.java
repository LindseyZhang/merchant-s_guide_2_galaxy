import infocontainer.GalaxyRomanInfo;
import question.QuestionHandler;
import question.QuestionHandlerForHowManyType;
import question.QuestionHandlerForHowMuch;
import util.InputParser;

public class MerchantProcessor {
    private GalaxyRomanInfo galaxyRomanInfo = new GalaxyRomanInfo();
    private InputParser inputParser = new InputParser(galaxyRomanInfo);
    private QuestionHandler questionHandler;

    public MerchantProcessor(String input) {
          inputParser.parseInput(input);
          initQuestionChain(galaxyRomanInfo);
    }

    public String getResult() {
        String result = "";
        for (String question: inputParser.getQuestions()) {
            result += questionHandler.handleQuestion(question);
        }
        return result;
    }

    private void initQuestionChain(GalaxyRomanInfo galaxyRomanInfo) {
        QuestionHandler howMuchQuestion;
        questionHandler = new QuestionHandlerForHowManyType(galaxyRomanInfo);
        howMuchQuestion = new QuestionHandlerForHowMuch(galaxyRomanInfo);
        questionHandler.setNextHandler(howMuchQuestion);
    }

}
