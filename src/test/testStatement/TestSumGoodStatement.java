package test.testStatement;

import main.PriceCenter;
import main.statement.StatementBase;
import main.statement.SumGoodStatement;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSumGoodStatement {
    @Test
    public void TestHandleStatement() {
        String statement = "glob prok Gold is 57800 Credits";
        PriceCenter priceCenter = new PriceCenter();
        priceCenter.AddBasicSymbolMap("glob", 'I');
        priceCenter.AddBasicSymbolMap("prok", 'V');

        assertEquals((int) priceCenter.GetMissingSymbolValue("Gold"), (int) priceCenter.NoMissingSymbol);

        StatementBase statementBase = new SumGoodStatement(priceCenter);
        statementBase.HandleStatement(statement);

        assertEquals((int) priceCenter.GetMissingSymbolValue("Gold"), (int) 14450.0);
    }
}
