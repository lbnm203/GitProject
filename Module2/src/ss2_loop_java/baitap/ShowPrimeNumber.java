package ss2_loop_java.baitap;
import java.util.Scanner;

public class ShowPrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int number = sc.nextInt();
        int count = 0;
        int n = 2;

        while (count < number) {
            if (isPrime(n)) {
                System.out.print(n + " ");
                count++;
            }
            n++;
        }
    }

    public static boolean isPrime(int number) {
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
