package main;

import main.question.HowManyQuestion;
import main.question.HowMuchQuestion;
import main.question.QuestionBase;

public class MerchantProcess {
    private PriceCenter priceCenter = new PriceCenter();
    private InputParser inputParser = new InputParser(priceCenter);
    private QuestionBase questionHandler;

    public MerchantProcess(String input) {
          InitFromInput(input);
          InitQuestionChain(priceCenter);
    }

    public String getResult() {
        String result = "";
        for (String question: inputParser.getQuestions()) {
            result += questionHandler.handleQuestion(question);
        }
        return result;
    }

    private void InitQuestionChain(PriceCenter priceCenter) {
        QuestionBase howMuchQuestion;
        questionHandler = new HowManyQuestion(priceCenter);
        howMuchQuestion = new HowMuchQuestion(priceCenter);
        questionHandler.setNextHandler(howMuchQuestion);
    }

    private void InitFromInput(String input) {
        inputParser.ParseInput(input);
    }

}
