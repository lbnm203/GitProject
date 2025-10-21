package ss9_testing.bai_tap.next_day_calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NextDayCalculatorTest {
    @Test
    @DisplayName("Testing day 1-1-2018")
    public void testNextDay() {
        assertEquals("2/1/2018", NextDayCalculator.findNextDay(1, 1, 2018));
    }

    @Test
    @DisplayName("Testing day 31-1-2018")
    public void testNextDay2() {
        assertEquals("1/2/2018", NextDayCalculator.findNextDay(31, 1, 2018));
    }

    @Test
    @DisplayName("Testing day 30-4-2018")
    public void testNextDay3() {
        assertEquals("1/5/2018", NextDayCalculator.findNextDay(30, 4, 2018));
    }

    @Test
    @DisplayName("Testing day 28-2-2018")
    public void testNextDay4() {
        assertEquals("1/3/2018", NextDayCalculator.findNextDay(28, 2, 2018));
    }

    @Test
    @DisplayName("Testing day 29-2-2020")
    public void testNextDay5() {
        assertEquals("1/3/2020", NextDayCalculator.findNextDay(29, 2, 2020));
    }

    @Test
    @DisplayName("Testing day 31-12-2018")
    public void testNextDay6() {
        assertEquals("1/1/2019", NextDayCalculator.findNextDay(31, 12, 2018));
    }
}
