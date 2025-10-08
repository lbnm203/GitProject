package ss1_Introduction_Java.BaiTap;
import java.util.Scanner;


public class ReadNumberToString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number: ");
        int number = sc.nextInt();

        if (number >= 0 && number < 10) {
            switch (number) {
                case 0:
                    System.out.println("zero");
                    break;
                case 1:
                    System.out.println("one");
                    break;
                case 2:
                    System.out.println("two");
                    break;
                case 3:
                    System.out.println("three");
                    break;
                case 4:
                    System.out.println("four");
                    break;
                case 5:
                    System.out.println("five");
                    break;
                case 6:
                    System.out.println("six");
                    break;
                case 7:
                    System.out.println("seven");
                    break;
                case 8:
                    System.out.println("eight");
                    break;
                case 9:
                    System.out.println("nine");
                    break;
            }
        } else if (number < 20) {
            int ones = number % 10;
            switch (ones) {
                case 0:
                    System.out.println("ten");
                    break;
                case 1:
                    System.out.println("eleven");
                    break;
                case 2:
                    System.out.println("twelve");
                    break;
                case 3:
                    System.out.println("thirteen");
                    break;
                case 4:
                    System.out.println("fourteen");
                    break;
                case 5:
                    System.out.println("fifteen");
                    break;
                case 6:
                    System.out.println("sixteen");
                    break;
                case 7:
                    System.out.println("seventeen");
                    break;
                case 8:
                    System.out.println("eighteen");
                    break;
                case 9:
                    System.out.println("nineteen");
                    break;
            }
        } else if (number < 100) {
            int tens = number / 10;
            int ones = number % 10;

            switch (tens) {
                case 2:
                    System.out.println("twenty");
                    break;
                case 3:
                    System.out.println("thirty");
                    break;
                case 4:
                    System.out.println("fourty");
                    break;
                case 5:
                    System.out.println("fifty");
                    break;
                case 6:
                    System.out.println("sixty");
                    break;
                case 7:
                    System.out.println("seventy");
                    break;
                case 8:
                    System.out.println("eighty");
                    break;
                case 9:
                    System.out.println("ninety");
                    break;
            }

            if (ones != 0) {
                switch (ones) {
                    case 1:
                        System.out.println("one");
                        break;
                    case 2:
                        System.out.println("two");
                        break;
                    case 3:
                        System.out.println("three");
                        break;
                    case 4:
                        System.out.println("four");
                        break;
                    case 5:
                        System.out.println("five");
                        break;
                    case 6:
                        System.out.println("six");
                        break;
                    case 7:
                        System.out.println("seven");
                        break;
                    case 8:
                        System.out.println("eight");
                        break;
                    case 9:
                        System.out.println("nine");
                        break;
                }
            }
        } else if (number < 1000) {
            int hundreds = number / 100;
            int remainders = number % 100;

            switch (hundreds) {
                case 1:
                    System.out.println("one hundred");
                    break;
                case 2:
                    System.out.println("two hundred");
                    break;
                case 3:
                    System.out.println("three hundred");
                    break;
                case 4:
                    System.out.println("four hundred");
                    break;
                case 5:
                    System.out.println("five hundred");
                    break;
                case 6:
                    System.out.println("six hundred");
                    break;
                case 7:
                    System.out.println("seven hundred");
                    break;
                case 8:
                    System.out.println("eight hundred");
                    break;
                case 9:
                    System.out.println("nine hundred");
                    break;
            }

            if (remainders != 0) {
                System.out.println(" and ");

                if (remainders < 10) {
                    switch (remainders) {
                        case 1:
                            System.out.println("one");
                            break;
                        case 2:
                            System.out.println("two");
                            break;
                        case 3:
                            System.out.println("three");
                            break;
                        case 4:
                            System.out.println("four");
                            break;
                        case 5:
                            System.out.println("five");
                            break;
                        case 6:
                            System.out.println("six");
                            break;
                        case 7:
                            System.out.println("seven");
                            break;
                        case 8:
                            System.out.println("eight");
                            break;
                        case 9:
                            System.out.println("nine");
                            break;
                    }
                } else if (remainders < 20) {
                    switch (remainders % 10) {
                        case 0:
                            System.out.println("ten");
                            break;
                        case 1:
                            System.out.println("eleven");
                            break;
                        case 2:
                            System.out.println("twelve");
                            break;
                        case 3:
                            System.out.println("thirteen");
                            break;
                        case 4:
                            System.out.println("fourteen");
                            break;
                        case 5:
                            System.out.println("fifteen");
                            break;
                        case 6:
                            System.out.println("sixteen");
                            break;
                        case 7:
                            System.out.println("seventeen");
                            break;
                        case 8:
                            System.out.println("eighteen");
                            break;
                        case 9:
                            System.out.println("nineteen");
                            break;
                    }
                } else {
                    int tens = remainders / 10;
                    int ones = remainders % 10;
                    switch (tens) {
                        case 2:
                            System.out.print("twenty");
                            break;
                        case 3:
                            System.out.print("thirty");
                            break;
                        case 4:
                            System.out.print("forty");
                            break;
                        case 5:
                            System.out.print("fifty");
                            break;
                        case 6:
                            System.out.print("sixty");
                            break;
                        case 7:
                            System.out.print("seventy");
                            break;
                        case 8:
                            System.out.print("eighty");
                            break;
                        case 9:
                            System.out.print("ninety");
                            break;
                    }
                    if (ones != 0) {
                        System.out.print(" ");
                        switch (ones) {
                            case 1:
                                System.out.print("one");
                                break;
                            case 2:
                                System.out.print("two");
                                break;
                            case 3:
                                System.out.print("three");
                                break;
                            case 4:
                                System.out.print("four");
                                break;
                            case 5:
                                System.out.print("five");
                                break;
                            case 6:
                                System.out.print("six");
                                break;
                            case 7:
                                System.out.print("seven");
                                break;
                            case 8:
                                System.out.print("eight");
                                break;
                            case 9:
                                System.out.print("nine");
                                break;
                        }
                    }
                }
            }
        } else {
            System.out.println("out of ability");
        }
        sc.close();
        }
    }
