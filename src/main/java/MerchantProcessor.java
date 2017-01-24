import infocontainer.PriceCenter;
import question.QuestionHandler;
import question.QuestionHandlerForHowManyType;
import question.QuestionHandlerForHowMuch;
import util.InputParser;

public class MerchantProcessor {
    private PriceCenter priceCenter = new PriceCenter();
    private InputParser inputParser = new InputParser(priceCenter);
    private QuestionHandler questionHandler;

    public MerchantProcessor(String input) {
          inputParser.parseInput(input);
          initQuestionChain(priceCenter);
    }

    public String getResult() {
        String result = "";
        for (String question: inputParser.getQuestions()) {
            result += questionHandler.handleQuestion(question);
        }
        return result;
    }

    private void initQuestionChain(PriceCenter priceCenter) {
        QuestionHandler howMuchQuestion;
        questionHandler = new QuestionHandlerForHowManyType(priceCenter);
        howMuchQuestion = new QuestionHandlerForHowMuch(priceCenter);
        questionHandler.setNextHandler(howMuchQuestion);
    }

}
