package ss11_stack_queue.bai_tap.convert_array.entity;

import java.util.Stack;

public class ConvertDicimalToBinary {
    public static String convertToBinary(int num) {
        Stack<Integer> stack = new Stack<>();

        while (num > 0) {
            stack.push(num % 2);
            num /= 2;
        }

        StringBuilder binary = new StringBuilder();
        while (!stack.isEmpty()) {
            binary.append(stack.pop());
        }

        if (binary.length() == 0) {
            binary.append("0");
        }

        return binary.toString();
        }
}
