package ss9_testing.thuc_hanh.absolute_value;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class AbsoluteNumberCalulatorTest {
    @Test
    void testFindAbsolute() {
        int number = -10;
        int expected = 10;

        int result = AbsoluteNumberCalculator.findAbsolute(number);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testFindAbsolute1() {
        int number = 0;
        int expected = 0;

        int result = AbsoluteNumberCalculator.findAbsolute(number);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testFindAbsolute2() {
        int number = 10;
        int expected = 10;

        int result = AbsoluteNumberCalculator.findAbsolute(number);
        Assertions.assertEquals(expected, result);
    }
}
