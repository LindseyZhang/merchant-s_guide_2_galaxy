package statement;

import infocontainer.PriceCenter;
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

        StatementParser statementBase = new StatementParserForCredits(priceCenter);
        statementBase.handleStatement(statement);

        assertEquals((int) priceCenter.getMissingSymbolValue("Gold"), (int) 14450.0);
    }
}
