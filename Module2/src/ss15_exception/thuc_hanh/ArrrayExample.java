package ss15_exception.thuc_hanh;

import java.util.Random;
import java.util.Scanner;

public class ArrrayExample {
    public static void main(String[] args) {
        ArrrayExample example = new ArrrayExample();
        Integer[] arr = example.createRandom();

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap chi so cua mot phan tu bat ky: ");
        int x = Integer.parseInt(sc.nextLine());
        try {
            System.out.println("Gia tri cua phan tu co chi so " + x + " la " + arr[x]);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Chi so vuot qa gioi han mang");
        }

    }

    public Integer[] createRandom() {
        Random rand = new Random();
        Integer[] arr = new Integer[100];
        System.out.println("Danh sach phan tu: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
            System.out.println(arr[i] + " ");
        }
        return arr;
    }
}
