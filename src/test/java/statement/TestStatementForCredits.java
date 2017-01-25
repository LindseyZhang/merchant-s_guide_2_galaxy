package statement;

import infocontainer.GalaxyRomanInfo;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestStatementForCredits {
    @Test
    public void TestHandleStatement() {
        String statement = "glob prok Gold is 57800 Credits";
        GalaxyRomanInfo galaxyRomanInfo = new GalaxyRomanInfo();
        galaxyRomanInfo.addBasicSymbolMap("glob", 'I');
        galaxyRomanInfo.addBasicSymbolMap("prok", 'V');

        assertEquals((int) galaxyRomanInfo.getMissingSymbolValue("Gold"), (int) galaxyRomanInfo.NoMissingSymbol);

        StatementParser statementBase = new StatementParserForCredits(galaxyRomanInfo);
        statementBase.handleStatement(statement);

        assertEquals((int) galaxyRomanInfo.getMissingSymbolValue("Gold"), (int) 14450.0);
    }
}
