package test.java.statement;

import main.java.PriceCenter;
import main.java.statement.StatementBase;
import main.java.statement.StatementParserForCredits;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSumGoodStatement {
    @Test
    public void TestHandleStatement() {
        String statement = "glob prok Gold is 57800 Credits";
        PriceCenter priceCenter = new PriceCenter();
        priceCenter.addBasicSymbolMap("glob", 'I');
        priceCenter.addBasicSymbolMap("prok", 'V');

        assertEquals((int) priceCenter.getMissingSymbolValue("Gold"), (int) priceCenter.NoMissingSymbol);

        StatementBase statementBase = new StatementParserForCredits(priceCenter);
        statementBase.handleStatement(statement);

        assertEquals((int) priceCenter.getMissingSymbolValue("Gold"), (int) 14450.0);
    }
}
