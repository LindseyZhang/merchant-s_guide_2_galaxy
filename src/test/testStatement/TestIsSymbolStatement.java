package test.testStatement;


import main.PriceCenter;
import main.statement.IsSymbolStatement;
import main.statement.StatementBase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestIsSymbolStatement {
    @Test
    public void TestHandleStatement() {
        String question = "glob is I";
        PriceCenter priceCenter = new PriceCenter();

        assertEquals(priceCenter.GetBasicSymbol("glob"), priceCenter.NoSymbol);

        StatementBase statementBase = new IsSymbolStatement(priceCenter);
        statementBase.HandleStatement(question);

        assertEquals(priceCenter.GetBasicSymbol("glob"), 'I');
    }
}
