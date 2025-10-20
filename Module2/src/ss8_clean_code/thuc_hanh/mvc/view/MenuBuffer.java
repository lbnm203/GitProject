package ss8_clean_code.thuc_hanh.mvc.view;


import ss8_clean_code.thuc_hanh.mvc.controller.MenuBufferController;
import ss8_clean_code.thuc_hanh.mvc.entity.Dish;

import java.util.Scanner;

public class MenuBuffer {

    private static MenuBufferController menuBufferController = new MenuBufferController();

    public static void menuBuffer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Danh sách món");
        System.out.println("2. Đặt món");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
            Dish[]  dishes = menuBufferController.getMenuBuffer();
            display(dishes);
            break;
        }
    }

    public static void display(Dish[] dishes) {
        for (Dish dish : dishes) {
            System.out.println(dish);
        }
    }
}
