package statement;

import infocontainer.PriceCenter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestIsSymbolStatement {
    @Test
    public void TestHandleStatement() {
        String question = "glob is I";
        PriceCenter priceCenter = new PriceCenter();

        assertEquals(priceCenter.getBasicSymbol("glob"), priceCenter.NoSymbol);

        StatementParser statementBase = new StatementParserForIsSymbol(priceCenter);
        statementBase.handleStatement(question);

        assertEquals(priceCenter.getBasicSymbol("glob"), 'I');
    }
}
