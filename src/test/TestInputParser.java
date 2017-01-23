package test;

import main.InputParser;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class TestInputParser {
    private InputParser inputParser;
    @Before
    public void SetUp() {
        inputParser = new InputParser();
    }
    @Test
    public void TestIsAQuestion() {
        assertTrue(inputParser.IsAQuestion("how much is pish tegj glob glob ?\n"));
        assertFalse(inputParser.IsAQuestion("tegj is L\n"));
    }

}
