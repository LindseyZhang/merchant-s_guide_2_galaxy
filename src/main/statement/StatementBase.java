package main.statement;

import main.PriceCenter;

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

    public void SetNextHandler(StatementBase nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void HandleStatement(String statement) {
        if (IsThisStatement(statement)) {
            ParseStatement(statement);
        }
        if (nextHandler != null) {
            nextHandler.HandleStatement(statement);
        }
    }

    public abstract void ParseStatement(String statement);

    public boolean IsThisStatement(String statement) {
        matcher = pattern.matcher(statement);
        return matcher.matches();
    }
}
