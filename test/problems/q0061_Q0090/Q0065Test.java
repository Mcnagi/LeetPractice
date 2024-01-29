package problems.q0061_Q0090;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class Q0065Test {
    public void testTrue(String input) {
        var q = new Q0065IsNumber();
        var actual = q.isNumber(input);
        Assertions.assertTrue(actual,
                String.format("Expect to be true but got %s with input: %s", actual, input));
    }

    public void testFalse(String input) {
        var q = new Q0065IsNumber();
        var actual = q.isNumber(input);
        Assertions.assertFalse(actual,
                String.format("Expect to be false but got %s with input: %s", actual, input));
    }



    @Test
    public void testInteger() {
        testTrue("123");
        testTrue("-1");
        testTrue("+3");

        testFalse("1 2");
        testFalse(" 12");
        testFalse("++1");
        testFalse("+-2");
        testFalse("-+3");
        testFalse("--4");
        testFalse("+1+");
    }

    @Test
    public void testDecimal() {
        testTrue("1.23");
        testTrue("12.3");
        testTrue("123.");
        testTrue(".123");
        testTrue("-1.0");
        testTrue("+3.");

        // space
        testFalse("1. 2");
        testFalse(" 12.");

        // additional decimal points
        testFalse("12.12.2");
        testFalse(".1212.2");
        testFalse(".12122.");
        testFalse("12..2");
        testFalse("..122");
        testFalse("122..");
        testFalse("122...");
        testFalse(".1.2.2...");

        // sign behind decimal
        testFalse(".-1");

        testFalse("++1.");
        testFalse("+-.2");
        testFalse("-+3.1");
        testFalse("--4.5");
        testFalse("+1.01+");

        testFalse(".");
    }

    @Test
    public void testScientific() {
        testTrue("1e2");
        testTrue("+1E2");
        testTrue("+2E-3");
        testTrue("+4e+5");
        testTrue("-6e+7");
        testTrue("-6.0e+7");
        testTrue("-.6e+7");

        // decimal points in exponent
        testFalse("0.6e0.6");
        testFalse("2e1.2");

        // invalid sign in exponent
        testFalse("2e--3");
        testFalse("12e++2");
        testFalse("23e+-4");
        testFalse("200e-+5");

        // start with e
        testFalse("e1");
        testFalse("e5");
        testFalse(".e1");

        // double e
        testFalse("2ee-3");
        testFalse("2e1e-3");
    }

    @Test
    public void testInvalidChar() {
        testFalse("1ea2");
        testFalse("1c2");
        testFalse("1\n2");
        testFalse("12%");
        testFalse("1,200");
    }


    @Test
    public void testSingleChar() {
        testFalse("+");
        testFalse("-");
        testFalse(".");
        testFalse("e");
        testFalse(" ");
    }

}
