package statement;

import infocontainer.GalaxyRomanInfo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class StatementParser {
    protected GalaxyRomanInfo galaxyRomanInfo;
    private StatementParser nextHandler = null;
    Pattern pattern;
    Matcher matcher;

    public StatementParser(GalaxyRomanInfo galaxyRomanInfo) {
        this.galaxyRomanInfo = galaxyRomanInfo;
    }

    public void setNextHandler(StatementParser nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handleStatement(String statement) {
        if (isThisStatement(statement)) {
            parseStatement(statement);
            return;
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
