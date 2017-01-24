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
    public void TestParseInput() {
        String input = "tegj is L\n" +
                "how much is pish tegj glob glob ?\n" +
                "how many Credits is glob prok Silver ?\n";
        Vector<String> expect_questions = new Vector<String>();
        expect_questions.add("how much is pish tegj glob glob ?");
        expect_questions.add("how many Credits is glob prok Silver ?");

        inputParser.ParseInput(input);
        System.out.println(inputParser.GetQuestions());
        assertEquals(expect_questions, inputParser.GetQuestions());

        assertEquals('L', priceCenter.GetBasicSymbol("tegj"));
    }

}
