package ss11_stack_queue.bai_tap.convert_array.entity;

import java.util.Arrays;
import java.util.Stack;

public class ConvertArrayUsingStack {
    public static void convertArray(int arr[]) {
        Stack<Integer> stack = new Stack<>();

        for (int num : arr) {
            stack.push(num);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void convertStringArray(String str) {
        Stack<String> wStack = new Stack<>();

        String[] words = str.split(" ");

        for (String s : words) {
            wStack.push(s);
        }

        StringBuilder output = new StringBuilder();
        while (!wStack.isEmpty()) {
            output.append(wStack.pop());
            if (!wStack.isEmpty()) {
                output.append(" ");
            }
        }

        System.out.println(output);
    }
}
