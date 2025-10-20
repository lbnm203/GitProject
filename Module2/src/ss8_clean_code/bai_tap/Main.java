package ss8_clean_code.bai_tap;

public class Main {
    public static void main(String[] args) {

        // --- Trường hợp 1: Hai người bằng điểm ---
        test("Love-All", TennisGame.getScore("Nadal", "Federer", 0, 0));
        test("Fifteen-All", TennisGame.getScore("Nadal", "Federer", 1, 1));
        test("Thirty-All", TennisGame.getScore("Nadal", "Federer", 2, 2));
        test("Forty-All", TennisGame.getScore("Nadal", "Federer", 3, 3));
        test("Deuce", TennisGame.getScore("Nadal", "Federer", 4, 4));

        // --- Trường hợp 2: Advantage / Win ---
        test("Advantage Nadal", TennisGame.getScore("Nadal", "Federer", 4, 3));
        test("Advantage Federer", TennisGame.getScore("Nadal", "Federer", 3, 4));
        test("Win for Nadal", TennisGame.getScore("Nadal", "Federer", 5, 3));
        test("Win for Federer", TennisGame.getScore("Nadal", "Federer", 3, 5));

        // --- Trường hợp 3: Bình thường ---
        test("Love-Fifteen", TennisGame.getScore("Nadal", "Federer", 0, 1));
        test("Fifteen-Thirty", TennisGame.getScore("Nadal", "Federer", 1, 2));
        test("Thirty-Forty", TennisGame.getScore("Nadal", "Federer", 2, 3));
        test("Forty-Love", TennisGame.getScore("Nadal", "Federer", 3, 0));

        // --- Trường hợp 4: Điểm không hợp lệ ---
        test("Invalid-Invalid", TennisGame.getScore("Nadal", "Federer", 5, -1));
    }

    // Hàm test đơn giản để so sánh kết quả
    private static void test(String expected, String actual) {
        if (expected.equals(actual)) {
            System.out.println("✅ PASSED: " + actual);
        } else {
            System.out.println("❌ FAILED: expected [" + expected + "] but got [" + actual + "]");
        }
    }
}
