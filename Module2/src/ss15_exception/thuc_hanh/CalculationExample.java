package ss15_exception.thuc_hanh;

import java.util.Scanner;

public class CalculationExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap x: ");
        int x = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap y: ");
        int y = Integer.parseInt(sc.nextLine());

        CalculationExample c = new CalculationExample();
        c.calculate(x, y);

    }

    private void calculate(int x, int y) {
        try {
            int a = x + y;
            int b = x - y;
            int c = x * y;
            int d = x / y;
            System.out.println("Tong x + y = " + a);
            System.out.println("Hieu x - y = " + b);
            System.out.println("Tich x * y = " + c);
            System.out.println("Thuong x / y = " + d);
        } catch (NumberFormatException e) {
            System.out.println("Xay ra ngoai le: " + e.getMessage());
        }
    }
}
