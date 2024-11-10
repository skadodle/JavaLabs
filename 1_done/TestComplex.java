import java.text.DecimalFormat;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import static java.lang.Math.random;

public class TestComplex {
    @Test
    public void testCase1() {
        Complex a = new Complex(3, 4);
        Complex b = new Complex(-5, 1);
        Complex result = new Complex(a);
        result.add(b);
        Assertions.assertEquals(-2, result.getRe());
        Assertions.assertEquals(5, result.getIm());
        result = a;
        result.sub(b);
        Assertions.assertEquals(8, result.getRe());
        Assertions.assertEquals(3, result.getIm());
    }

    @Test
    public void testCase2() {
        DecimalFormat df = new DecimalFormat("#.######");
        Complex c1 = new Complex(4, 4);
        try {
            Assertions.assertEquals(df.format(Math.atan2(c1.getIm(), c1.getRe())), df.format(c1.getArg()), "c1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Complex c2 = new Complex(-5, 8);
        try {
            Assertions.assertEquals(df.format(Math.atan2(c2.getIm(), c2.getRe())), df.format(c2.getArg()), "c2");
        } catch (Exception e) {
            e.printStackTrace();
        }    
    }

    @Test
    public void testCase3() {
        Complex c = new Complex(4, -4);
        Assertions.assertEquals(Math.sqrt(32), c.getMod());
    }
}
