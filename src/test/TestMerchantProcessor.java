package test;

import main.MerchantProcess;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class TestMerchantProcessor {
    @Test
    public void testOutputServicewithAllSituation(){
        String input = "glob is I\n" +
                "prok is V\n" +
                "pish is X\n" +
                "tegj is L\n" +
                "glob glob Silver is 34 Credits\n" +
                "glob prok Gold is 57800 Credits\n" +
                "pish pish Iron is 3910 Credits\n" +
                "how much is pish tegj glob glob ?\n" +
                "how many Credits is glob prok Silver ?\n" +
                "how many Credits is glob prok Gold ?\n" +
                "how many Credits is glob prok Iron ?\n" +
                "how much wood could a woodchuck chuck if a woodchuck could chuck wood ?\n";

        MerchantProcess convetorMain = new MerchantProcess(input);

        String result = convetorMain.getResult();

        System.out.println(result);
        String expectResult = "pish tegj glob glob is 42\n" +
                "glob prok Silver is 68 Credits\n" +
                "glob prok Gold is 57800 Credits\n" +
                "glob prok Iron is 782 Credits\n" +
                "I have no idea what you are talking about\n";

        assertEquals(result, expectResult);
    }
}
