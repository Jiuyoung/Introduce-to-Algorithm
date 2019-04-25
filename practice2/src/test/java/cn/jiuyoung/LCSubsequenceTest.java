package cn.jiuyoung;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * LCSubsequenceTest
 */
@RunWith(Parameterized.class)
public class LCSubsequenceTest {

    private String inputX;
    private String inputY;
    private String expect;


    public LCSubsequenceTest(String inputX, String inputY, String expect) {
        this.inputX = inputX;
        this.inputY = inputY;
        this.expect = expect;
    }
    
    @Parameters(name="{index}:LCSubquence({0}, {1})={2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(
            new Object[][] {
                {"xzyzzyx", "zxyyzxz", "xyzz"},
                {"MAEEEVAKLEKHLMLLRQEYVKLQKKLAETEKRCALLAAQANKESSSESFISRLLAIVAD",
                    "MAEEEVAKLEKHLMLLRQEYVKLQKKLAETEKRCTLLAAQANKENSNESFISRLLAIVAG",
                    "MAEEEVAKLEKHLMLLRQEYVKLQKKLAETEKRCLLAAQANKESESFISRLLAIVA"
                }
            }
        );
    }

    @Test
    public void testLCSubsequence() {
        LCSubsequence lcs = new LCSubsequence(inputX, inputY);
        lcs.execute();
        assertEquals(expect, lcs.getResult());
    }
}