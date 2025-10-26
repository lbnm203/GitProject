package ss12_map_tree.bai_tap.practice_using_array_linkedlist.controller;

import ss12_map_tree.bai_tap.practice_using_array_linkedlist.entity.Product;
import ss12_map_tree.bai_tap.practice_using_array_linkedlist.service.ProductManagerLinked;

import java.util.Scanner;

public class LinkedMain {
    public static void main(String[] args) {
        ProductManagerLinked productLinked = new ProductManagerLinked();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("=========MENU========");
            System.out.println("1. Add product");
            System.out.println("2. Remove product");
            System.out.println("3. Edit product");
            System.out.println("4. Show all products");
            System.out.println("5. Search product by Name");
            System.out.println("6. Sort products by Price ascending");
            System.out.println("7. Sort products by Price descending");
            System.out.println("0. Exit");
            System.out.println("======================");

            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Enter ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    while (productLinked.isDuplicateId(id)) {
                        System.out.println("ID is duplicated! Please enter again!");
                        id = Integer.parseInt(sc.nextLine());
                    }
                    System.out.println("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter Price: ");
                    double price = Double.parseDouble(sc.nextLine());

                    productLinked.addProduct(new Product(id, name, price));
                    break;

                case 2:
                    System.out.println("Enter ID you want to remove: ");
                    int deleteID = Integer.parseInt(sc.nextLine());
                    productLinked.deleteProduct(deleteID);
                    break;

                case 3:
                    System.out.println("Enter ID you want to edit: ");
                    int editID = Integer.parseInt(sc.nextLine());
                    System.out.println("Enter new name: ");
                    String newName = sc.nextLine();
                    System.out.println("Enter new price: ");
                    double newPrice = Double.parseDouble(sc.nextLine());
                    productLinked.editProduct(editID, newName, newPrice);
                    break;

                case 4:
                    productLinked.showProducts();
                    break;

                case 5:
                    System.out.println("Enter Name you want to search: ");
                    String searchName = sc.nextLine();
                    productLinked.searchProduct(searchName);
                    break;

                case 6:
                    productLinked.sortProductByPriceASC();
                    break;

                case 7:
                    productLinked.sortProductByPriceDESC();
                    break;
            }
        } while (choice != 0);
    }
}
