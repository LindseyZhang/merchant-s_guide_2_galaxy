package test;

import main.InputParser;
import main.PriceCenter;
import org.junit.Before;
import org.junit.Test;

import java.util.Vector;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class TestInputParser {
    private InputParser inputParser;
    private PriceCenter priceCenter;
    @Before
    public void SetUp() {
        priceCenter = new PriceCenter();
        inputParser = new InputParser(priceCenter);
    }
    @Test
    public void TestIsAQuestion() {
        assertTrue(inputParser.IsAQuestion("how much is pish tegj glob glob ?\n"));
        assertFalse(inputParser.IsAQuestion("tegj is L\n"));
    }

    @Test
    public void TestCategoryInput() {
        String input = "tegj is L\n" +
                "glob glob Silver is 34 Credits\n" +
                "how much is pish tegj glob glob ?\n" +
                "how many Credits is glob prok Silver ?\n";
        Vector<String> expect_questions = new Vector<String>();
        expect_questions.add("how much is pish tegj glob glob ?");
        expect_questions.add("how many Credits is glob prok Silver ?");

        /*ector<String> expect_statement = new Vector<String>();
        expect_statement.add("tegj is L");
        expect_statement.add("glob glob Silver is 34 Credits");*/

        inputParser.ParseInput(input);
        System.out.println(inputParser.getQuestions());
        assertEquals(expect_questions, inputParser.getQuestions());
    }

}
