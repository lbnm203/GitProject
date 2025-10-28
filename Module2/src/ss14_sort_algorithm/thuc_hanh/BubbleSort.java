package ss14_sort_algorithm.thuc_hanh;

public class BubbleSort {
    static int[] arr = {3, 5, 1, 2, 4, 12, 17, 14, 7, 9};

    public static void bubbleSort(int[] arr) {
        boolean isSorted = true;
        for (int i = 0; i < arr.length - 1 && isSorted; i++) {
            isSorted = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSorted = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println("\n");
        bubbleSort(arr);
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
