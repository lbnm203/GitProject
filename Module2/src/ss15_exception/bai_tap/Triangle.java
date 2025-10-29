package ss15_exception.bai_tap;

import java.util.Scanner;

class IllegalTriangleException extends Exception {
    public IllegalTriangleException(String message) {
        super(message);
    }
}

public class Triangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Nhap canh a: ");
            int a = Integer.parseInt(sc.nextLine());
            System.out.print("Nhap canh b: ");
            int b = Integer.parseInt(sc.nextLine());
            System.out.print("Nhap canh c: ");
            int c = Integer.parseInt(sc.nextLine());

            checkValid(a, b, c);

            System.out.println("Tam giac hop le");
        } catch (IllegalTriangleException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }


    }

    public static void checkValid(int a, int b, int c) throws IllegalTriangleException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalTriangleException("Cạnh nhập vào phải là số dương");
        }

        if (a + b <= c || b + c <= a || a + c <= b) {
            throw new IllegalTriangleException("Tổng 2 cạnh phải lớn hơn cạnh còn lại");
        }
    }



}
