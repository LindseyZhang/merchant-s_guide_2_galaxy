package test.java.statement;


import main.java.PriceCenter;
import main.java.statement.StatementParserForIsSymbol;
import main.java.statement.StatementBase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestIsSymbolStatement {
    @Test
    public void TestHandleStatement() {
        String question = "glob is I";
        PriceCenter priceCenter = new PriceCenter();

        assertEquals(priceCenter.getBasicSymbol("glob"), priceCenter.NoSymbol);

        StatementBase statementBase = new StatementParserForIsSymbol(priceCenter);
        statementBase.handleStatement(question);

        assertEquals(priceCenter.getBasicSymbol("glob"), 'I');
    }
}
