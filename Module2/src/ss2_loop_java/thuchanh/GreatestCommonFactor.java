package ss2_loop_java.thuchanh;
import java.util.Scanner;

public class GreatestCommonFactor {
    public static void main(String[] args) {
        int a, b;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a: ");
        a = sc.nextInt();

        System.out.println("Enter b: ");
        b = sc.nextInt();

        a = Math.abs(a);
        b = Math.abs(b);

        if (a == 0 || b == 0) {
            System.out.println("No Greatest Common Factor");
            return;
        }

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        System.out.println("Greatest Common Factor: " + a);

    }
}
