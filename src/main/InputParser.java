package main;

import main.question.HowManyQuestion;
import main.question.QuestionBase;

import java.util.Vector;

public class InputParser {

    private PriceCenter priceCenter;
    Vector<String> questions = new Vector<String>();
    Vector<String> statements = new Vector<String>();

    public String DealInput(String input) {
        CategoryInput(input);
        priceCenter.GeneratePriceInfo(statements);

        QuestionBase howMuchQuestion,howManyQuestion;
        howManyQuestion = new HowManyQuestion();
        howMuchQuestion = new HowManyQuestion();
        howManyQuestion.setNextHandler(howMuchQuestion);
  //      return "";
    }

    public void CategoryInput(String input) {
        String[] inputInLine = input.split("\n");
        for ( int i = 0; i < inputInLine.length; ++i ) {
            if (IsAQuestion(inputInLine[i])) {
                questions.add(inputInLine[i]);
            } else {
                statements.add(inputInLine[i]);
            }
        }
    }



    public boolean IsAQuestion(String line) {
       return line.contains("?");
    }

    private boolean IsAStatement(String line) {
        return !IsAQuestion(line);
    }

}
