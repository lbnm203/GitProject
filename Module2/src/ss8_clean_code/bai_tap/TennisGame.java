package ss8_clean_code.bai_tap;

public class TennisGame {
    public static String getScore(String namePlayer1, String namePlayer2, int scorePlayer1, int scorePlayer2) {
        if (scorePlayer1 == scorePlayer2) {
            return getEqualScore(scorePlayer1);
        } else if (scorePlayer1 >= 4 || scorePlayer2 >= 4) {
            return getAvantageOrWin(scorePlayer1, scorePlayer2, namePlayer1, namePlayer2);
        } else {
            return getNormalScore(scorePlayer1, scorePlayer2);
        }
    }

    private static String getNormalScore(int score1, int score2) {
        return getScoreName(score1) + "-" + getScoreName(score2);
    }

    private static String getScoreName(int score) {
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "Invalid";
        }
    }

    public static String getEqualScore(int score) {
        switch (score) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3:
                return "Forty-All";
            default:
                return "Deuce";
        }
    }

    private static String getAvantageOrWin(int scorePlayer1, int scorePlayer2, String namePlayer1, String namePlayer2) {
        int minusResult = scorePlayer1 - scorePlayer2;
        if (minusResult == 1) return "Advantage " + namePlayer1 ;
        else if (minusResult == -1) return "Advantage " + namePlayer2;
        else if (minusResult >= 2) return "Win for " + namePlayer1;
        return "Win for " + namePlayer2;
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