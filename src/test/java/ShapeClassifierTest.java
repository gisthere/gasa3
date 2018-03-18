import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class ShapeClassifierTest {
    protected String buildString(String shape, String size, String even, String p1, String p2, String p3, String p4, String res) {
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

    protected String buildString(String shape, String size, String even, String p1, String p2, String p3, String p4, String p5, String res) {
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