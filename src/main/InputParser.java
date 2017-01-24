package main;

import main.statement.IsSymbolStatement;
import main.statement.StatementBase;
import main.statement.SumGoodStatement;

import java.util.Vector;

public class InputParser {
    private PriceCenter priceCenter;
    private StatementBase statementHandler;
    Vector<String> questions = new Vector<String>();

    public InputParser(PriceCenter priceCenter) {
        this.priceCenter = priceCenter;
        InitStatementChain(priceCenter);
    }

    public Vector<String> getQuestions() {
        return questions;
    }

    public void ParseInput(String input) {
        String[] inputInLine = input.split("\n");
        for ( int i = 0; i < inputInLine.length; ++i ) {
            if (IsAQuestion(inputInLine[i])) {
               questions.add(inputInLine[i]);
            } else {
                ParseStatement(inputInLine[i]);
            }
        }
    }

    public boolean IsAQuestion(String line) {
       return line.contains("?");
    }

    private boolean IsAStatement(String line) {
        return !IsAQuestion(line);
    }

    private void InitStatementChain(PriceCenter priceCenter) {
        StatementBase sumGoodStatement;
        statementHandler = new IsSymbolStatement(priceCenter);
        sumGoodStatement = new SumGoodStatement(priceCenter);
        statementHandler.setNextHandler(sumGoodStatement);
    }

    private void ParseStatement(String statement) {
        statementHandler.handleStatement(statement);
    }
}
