package ss9_testing.bai_tap.next_day_calculator;

public class NextDayCalculator {
    public static String findNextDay(int day, int month, int year) {
        int nextDay = day;
        int nextMonth = month;
        int nextYear = year;

        int daysInMonth = getDaysInMonth(month, year);
        if (day < daysInMonth) {
            nextDay++;
        } else {
            nextDay = 1;
            if (nextMonth == 12) {
                nextMonth = 1;
                nextYear++;
            } else {
                nextMonth++;
            }
        }
        return nextDay + "/" + nextMonth + "/" + nextYear;
    }

    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        return year % 4 == 0;
    }

    public static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 2:
                return isLeapYear(year) ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }
}
