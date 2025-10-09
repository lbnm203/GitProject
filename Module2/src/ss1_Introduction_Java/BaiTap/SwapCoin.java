package ss1_Introduction_Java.BaiTap;
import java.util.Scanner;

public class SwapCoin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rate = 23000;

        System.out.println("Enter amount to swap: ");
        float money = sc.nextFloat();

        if (money <= 0) {
            System.out.print("Enter money > 0");
            return;
        }

        System.out.println("money: " + money + " USD -> " + money * rate + " VND");
    }
}
