package ss1_Introduction_Java;
import java.util.Scanner;


public class IntroJava {
    public static void main(String[] args) {
        System.out.print("Enter a number: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int result = num * num;

        System.out.println("result: " + result);
    }
}
