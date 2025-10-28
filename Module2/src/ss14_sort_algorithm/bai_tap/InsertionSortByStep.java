package ss14_sort_algorithm.bai_tap;

public class InsertionSortByStep {
    static int[] arr = {4, 7, 2, 1, 18, 15, 9, 8, 5};

    public static void main(String[] args) {
        printArray(arr);

        insertSort(arr);
    }

    public static void insertSort(int[] arr) {
        int pos;
        int x;
        boolean isSorted = true;
        for (int i = 1; i < arr.length; i++) {
            x = arr[i];
            pos = i;

            System.out.println("Step " + i + ": insert " + x);
            System.out.println("X = " + x );
            while (pos > 0 && x < arr[pos - 1]) {
                System.out.println("move " + arr[pos - 1] + " to the right");
                arr[pos] = arr[pos - 1];
                pos--;
            }
            arr[pos] = x;


            System.out.println("Result");
            printArray(arr);
            System.out.println("\n");
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
