import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class ShapeClassifierTest1wise extends ShapeClassifierTest{

    @Test
    @FileParameters("src/test/1wise.csv")
    public void test1wise(String shape, String size, String even, String p1, String p2, String p3, String p4, String res) {
        String str = buildString(shape, size, even, p1, p2, p3, p4, res);
        assertEquals(res, new ShapeClassifier().evaluateGuess(str));
    }

}