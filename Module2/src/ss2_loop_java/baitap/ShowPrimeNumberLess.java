package ss2_loop_java.baitap;

public class ShowPrimeNumberLess {
    public static void main(String[] args) {
        for (int i = 2; i <= 100; i++) {
            if (checkPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static boolean checkPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
