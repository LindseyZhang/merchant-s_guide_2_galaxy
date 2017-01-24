package test.testStatement;


import main.PriceCenter;
import main.statement.IsSymbolStatement;
import main.statement.StatementBase;
import org.junit.Test;

public class TestIsSymbolStatement {
    @Test
    public void TestHandleStatement() {
        String question = "glob is I";
        PriceCenter priceCenter = new PriceCenter();

        StatementBase statementBase = new IsSymbolStatement(priceCenter);
        statementBase.handleStatement(question);
    }
}
