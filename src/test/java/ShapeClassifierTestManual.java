import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class ShapeClassifierTestManual extends ShapeClassifierTest{

    @Test
    @FileParameters("src/test/manual.csv")
    public void testManual(String shape, String size, String even, String p1, String p2, String p3, String p4, String res) {
        String str = buildString(shape, size, even, p1, p2, p3, p4, res);
        assertEquals(res, new ShapeClassifier().evaluateGuess(str));
    }
}