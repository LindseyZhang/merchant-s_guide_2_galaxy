package statement;

import infocontainer.GalaxyRomanInfo;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestStatementParserForIsSymbol {
    @Test
    public void TestHandleStatement() {
        String statement = "glob is I";
        GalaxyRomanInfo galaxyRomanInfo = new GalaxyRomanInfo();

        assertEquals(galaxyRomanInfo.getBasicSymbol("glob"), galaxyRomanInfo.NoSymbol);

        StatementParser statementBase = new StatementParserForIsSymbol(galaxyRomanInfo);
        statementBase.handleStatement(statement);

        assertEquals(galaxyRomanInfo.getBasicSymbol("glob"), 'I');

        statement = "ha hah is L";
        assertEquals(galaxyRomanInfo.getBasicSymbol("hahah"), galaxyRomanInfo.NoSymbol);
        statementBase.handleStatement(statement);
        assertEquals(galaxyRomanInfo.getBasicSymbol("hahah"), galaxyRomanInfo.NoSymbol);

        statement = "hahaha is LL";
        assertEquals(galaxyRomanInfo.getBasicSymbol("hahah"), galaxyRomanInfo.NoSymbol);
        statementBase.handleStatement(statement);
        assertEquals(galaxyRomanInfo.getBasicSymbol("hahah"), galaxyRomanInfo.NoSymbol);


    }
}
