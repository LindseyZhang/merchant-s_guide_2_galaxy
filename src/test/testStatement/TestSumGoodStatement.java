package test.testStatement;

import main.PriceCenter;
import main.statement.StatementBase;
import main.statement.SumGoodStatement;
import org.junit.Test;

public class TestSumGoodStatement {
    @Test
    public void TestHandleStatement() {
        String statement = "glob prok Gold is 57800 Credits";
        PriceCenter priceCenter = new PriceCenter();

        StatementBase statementBase = new SumGoodStatement(priceCenter);
        statementBase.handleStatement(statement);
    }
}
