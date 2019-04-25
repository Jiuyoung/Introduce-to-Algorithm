package cn.jiuyoung;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * LCSubstringTest
 * 默认采用加入等号的条件，结果是最后一个满足LCS的子串
 */
@RunWith(Parameterized.class)
public class LCSubstringTest {

    private String inputX;
    private String inputY;
    private String expect;

    public LCSubstringTest(String inputX, String inputY, String expect) {
        this.inputX = inputX;
        this.inputY = inputY;
        this.expect = expect;
    }

    @Parameters(name="case {index} : LCSubstring({0}, {1})={2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(
            new Object[][] {
                {"xzyzzyx", "zxyyzxz", "yz"},
                {"MAEEEVAKLEKHLMLLRQEYVKLQKKLAETEKRCALLAAQANKESSSESFISRLLAIVAD",
                    "MAEEEVAKLEKHLMLLRQEYVKLQKKLAETEKRCTLLAAQANKENSNESFISRLLAIVAG",
                    "MAEEEVAKLEKHLMLLRQEYVKLQKKLAETEKRC"
                }
            }
        );
    }

    @Test
    public void testLCString() {
        LCSubstring lcs = new LCSubstring(inputX, inputY);
        lcs.execute();
        assertEquals(expect, lcs.getResult());
    }
}