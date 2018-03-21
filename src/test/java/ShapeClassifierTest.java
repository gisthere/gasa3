import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class ShapeClassifierTest {

    @Test
    @FileParameters("src/test/1wise.csv")
    public void test1wise(String shape, String size, String even, String p1, String p2, String p3, String p4, String res) {
        String str = buildString(shape, size, even, p1, p2, p3, p4, res);
        assertEquals(res, new ShapeClassifier().evaluateGuess(str));
    }

    @Test
    @FileParameters("src/test/2wise.csv")
    public void test2wise(String shape, String size, String even, String p1, String p2, String p3, String p4, String res) {
        String str = buildString(shape, size, even, p1, p2, p3, p4, res);
        assertEquals(res, new ShapeClassifier().evaluateGuess(str));
    }

    @Test
    @FileParameters("src/test/3wise.csv")
    public void test3wise(String shape, String size, String even, String p1, String p2, String p3, String p4, String res) {
        String str = buildString(shape, size, even, p1, p2, p3, p4, res);
        assertEquals(res, new ShapeClassifier().evaluateGuess(str));
    }

    @Test
    @FileParameters("src/test/manual.csv")
    public void testManual(String shape, String size, String even, String p1, String p2, String p3, String p4, String res) {
        String str = buildString(shape, size, even, p1, p2, p3, p4, res);
        assertEquals(res, new ShapeClassifier().evaluateGuess(str));
    }

    @Test
    @FileParameters("src/test/whitebox.csv")
    public void testWhiteBox(String shape, String size, String even, String p1, String p2, String p3, String p4, String p5, String res) {
        String str = buildString(shape, size, even, p1, p2, p3, p4, p5, res);
        assertEquals(res, new ShapeClassifier().evaluateGuess(str));
    }

    private String buildString(String shape, String size, String even, String p1, String p2, String p3, String p4, String res) {
        StringBuilder sb = new StringBuilder();
        sb.append(shape).append(',');
        sb.append(size).append(',');
        sb.append(even).append(',');
        sb.append(p1).append(',');
        if (!p2.equals("NA")) {
            sb.append(p2).append(',');
        }
        if (!p3.equals("NA")) {
            sb.append(p3).append(',');
        }
        if (!p4.equals("NA")) {
            sb.append(p4).append(',');
        }

        return sb.toString();
    }

    private String buildString(String shape, String size, String even, String p1, String p2, String p3, String p4, String p5, String res) {
        StringBuilder sb = new StringBuilder();
        sb.append(shape).append(',');
        sb.append(size).append(',');
        sb.append(even).append(',');
        sb.append(p1).append(',');
        if (!p2.equals("NA")) {
            sb.append(p2).append(',');
        }
        if (!p3.equals("NA")) {
            sb.append(p3).append(',');
        }
        if (!p4.equals("NA")) {
            sb.append(p4).append(',');
        }
        if (!p5.equals("NA")) {
            sb.append(p4).append(',');
        }

        return sb.toString();
    }
}