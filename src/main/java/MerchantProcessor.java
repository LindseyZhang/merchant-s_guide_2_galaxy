package main.java;

import main.java.question.QuestionHandlerForHowManyType;
import main.java.question.QuestionHandlerForHowMuch;
import main.java.question.QuestionBase;
import main.java.util.InputParser;

public class MerchantProcessor {
    private PriceCenter priceCenter = new PriceCenter();
    private InputParser inputParser = new InputParser(priceCenter);
    private QuestionBase questionHandler;

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
        QuestionBase howMuchQuestion;
        questionHandler = new QuestionHandlerForHowManyType(priceCenter);
        howMuchQuestion = new QuestionHandlerForHowMuch(priceCenter);
        questionHandler.setNextHandler(howMuchQuestion);
    }

}
