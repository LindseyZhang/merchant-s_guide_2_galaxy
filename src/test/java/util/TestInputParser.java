package util;

import infocontainer.GalaxyRomanInfo;
import org.junit.Before;
import org.junit.Test;

import java.util.Vector;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class TestInputParser {
    private InputParser inputParser;
    private GalaxyRomanInfo galaxyRomanInfo;

    @Before
    public void SetUp() {
        galaxyRomanInfo = new GalaxyRomanInfo();
        inputParser = new InputParser(galaxyRomanInfo);
    }

    @Test
    public void TestIsAQuestion() {
        assertTrue(inputParser.isAQuestion("how much is pish tegj glob glob ?\n"));
        assertFalse(inputParser.isAQuestion("tegj is L\n"));
    }

    @Test
    public void TestParseInput() {
        String input = "tegj is L\n" +
                "how much is pish tegj glob glob ?\n" +
                "how many Credits is glob prok Silver ?\n";
        Vector<String> expect_questions = new Vector<String>();
        expect_questions.add("how much is pish tegj glob glob ?");
        expect_questions.add("how many Credits is glob prok Silver ?");

        inputParser.parseInput(input);
        System.out.println(inputParser.getQuestions());
        assertEquals(expect_questions, inputParser.getQuestions());

        assertEquals('L', galaxyRomanInfo.getBasicSymbol("tegj"));
    }

}
