package util;

import infocontainer.GalaxyRomanInfo;
import statement.StatementParser;
import statement.StatementParserForCredits;
import statement.StatementParserForIsSymbol;

import java.util.Vector;

public class InputParser {
    private GalaxyRomanInfo galaxyRomanInfo;
    private StatementParser statementHandler;
    Vector<String> questions = new Vector<String>();

    public InputParser(GalaxyRomanInfo galaxyRomanInfo) {
        this.galaxyRomanInfo = galaxyRomanInfo;
        initStatementChain(galaxyRomanInfo);
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

    private void initStatementChain(GalaxyRomanInfo galaxyRomanInfo) {
        StatementParser sumGoodStatement;
        statementHandler = new StatementParserForIsSymbol(galaxyRomanInfo);
        sumGoodStatement = new StatementParserForCredits(galaxyRomanInfo);
        statementHandler.setNextHandler(sumGoodStatement);
    }

    private void parseStatement(String statement) {
        statementHandler.handleStatement(statement);
    }
}
