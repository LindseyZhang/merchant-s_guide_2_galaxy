package statement;

import infocontainer.GalaxyRomanInfo;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestStatementParserForIsSymbol {
    @Test
    public void TestHandleStatement() {
        String question = "glob is I";
        GalaxyRomanInfo galaxyRomanInfo = new GalaxyRomanInfo();

        assertEquals(galaxyRomanInfo.getBasicSymbol("glob"), galaxyRomanInfo.NoSymbol);

        StatementParser statementBase = new StatementParserForIsSymbol(galaxyRomanInfo);
        statementBase.handleStatement(question);

        assertEquals(galaxyRomanInfo.getBasicSymbol("glob"), 'I');
    }
}
