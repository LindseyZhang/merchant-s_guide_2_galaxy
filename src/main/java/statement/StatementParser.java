package statement;

import infocontainer.PriceCenter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class StatementParser {
    protected PriceCenter priceCenter;
    private StatementParser nextHandler = null;
    Pattern pattern;
    Matcher matcher;

    public StatementParser(PriceCenter priceCenter) {
        this.priceCenter = priceCenter;
    }

    public void setNextHandler(StatementParser nextHandler) {
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
