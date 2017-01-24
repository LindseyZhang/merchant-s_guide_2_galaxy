package main.java.statement;

import main.java.PriceCenter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class StatementBase {
    protected PriceCenter priceCenter;
    private StatementBase nextHandler = null;
    Pattern pattern;
    Matcher matcher;

    public StatementBase(PriceCenter priceCenter) {
        this.priceCenter = priceCenter;
    }

    public void setNextHandler(StatementBase nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handleStatement(String statement) {
        if (isThisStatement(statement)) {
            parseStatement(statement);
        }
        if (nextHandler != null) {
            nextHandler.handleStatement(statement);
        }
    }

    public abstract void parseStatement(String statement);

    public boolean isThisStatement(String statement) {
        matcher = pattern.matcher(statement);
        return matcher.matches();
    }
}
