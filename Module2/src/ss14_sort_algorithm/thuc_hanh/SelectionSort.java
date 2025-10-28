package ss14_sort_algorithm.thuc_hanh;

public class SelectionSort {
    static int[] arr = {4, 7, 2, 1, 18, 15, 9, 8, 5};

    public static void main(String[] args) {
        for (int j : arr) {
            System.out.print(j + " ");
        }

        System.out.println("\n");
        selectionSort(arr);
        for (int j : arr) {
            System.out.print(j + " ");
        }

        System.out.println("\n");
        selectionSortDesc(arr);
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    public static void selectionSort(int[] arr) {
        int min;
        for (int i = 0; i < arr.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

    public static void selectionSortDesc(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int currentMinIndex = i;
            int currentMin = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (currentMin < arr[j]) {
                    currentMin = arr[j];
                    currentMinIndex = j;
                }
            }

            if (currentMinIndex != i) {
                arr[currentMinIndex] = arr[i];
                arr[i] = currentMin;
            }
        }
    }
}
