package ss2_loop_java.thuchanh;
import java.util.Scanner;

public class ComputeLoanBank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter money");
        double money = sc.nextFloat();

        System.out.println("Enter interest rate:");
        double interestRate = sc.nextFloat();

        System.out.println("Enter number of months:");
        int month = sc.nextInt();

        double total = 0;

        for (int i = 0; i < month; i++) {
            total += money * (interestRate / 100) / 12 * month;
        }

        System.out.println("Total: " + total);
    }
}
