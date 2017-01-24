package util;

import infocontainer.PriceCenter;
import statement.StatementParser;
import statement.StatementParserForCredits;
import statement.StatementParserForIsSymbol;

import java.util.Vector;

public class InputParser {
    private PriceCenter priceCenter;
    private StatementParser statementHandler;
    Vector<String> questions = new Vector<String>();

    public InputParser(PriceCenter priceCenter) {
        this.priceCenter = priceCenter;
        initStatementChain(priceCenter);
    }

    public Vector<String> getQuestions() {
        return questions;
    }

    public void parseInput(String input) {
        String[] inputInLine = input.split("\n");
        for ( int i = 0; i < inputInLine.length; ++i ) {
            if (isAQuestion(inputInLine[i])) {
               questions.add(inputInLine[i]);
            } else {
                parseStatement(inputInLine[i]);
            }
        }
    }

    public boolean isAQuestion(String line) {
       return line.contains("?");
    }

    private boolean isAStatement(String line) {
        return !isAQuestion(line);
    }

    private void initStatementChain(PriceCenter priceCenter) {
        StatementParser sumGoodStatement;
        statementHandler = new StatementParserForIsSymbol(priceCenter);
        sumGoodStatement = new StatementParserForCredits(priceCenter);
        statementHandler.setNextHandler(sumGoodStatement);
    }

    private void parseStatement(String statement) {
        statementHandler.handleStatement(statement);
    }
}
