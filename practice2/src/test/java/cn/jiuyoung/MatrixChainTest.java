package cn.jiuyoung;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import cn.jiuyoung.MatrixChain;

/**
 * MatrixChainTest
 * 参数化测试
 */
@RunWith(Parameterized.class)
public class MatrixChainTest {
    private int[] fInput;
    private String fExpect;


    public MatrixChainTest(String arrayString, String fExpect) {
        this.fInput = Stream.of(arrayString.split(","))
                    .mapToInt(Integer::valueOf).toArray();
        this.fExpect = fExpect;
    }

    @Parameters(name="{index}:matrix({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(
            new Object[][] {
                {"3,5,2,1,10",                "((A1(A2A3))A4)"},
                {"2,7,3,6,10",                "(((A1A2)A3)A4)"},
                {"10,3,15,12,7,2",        "(A1(A2(A3(A4A5))))"},
                {"5,2,4,15,20,5",         "(A1(((A2A3)A4)A5))"},
                {"30,35,15,5,10,20,25","((A1(A2A3))((A4A5)A6))"}
            }
        );
    }

    @Test
    public void testMatrixChain() {
        
        assertEquals(this.fExpect, new MatrixChain(this.fInput).optimalParens2String());
    }
}