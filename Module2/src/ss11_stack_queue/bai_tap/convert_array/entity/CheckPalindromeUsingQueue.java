package ss11_stack_queue.bai_tap.convert_array.entity;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CheckPalindromeUsingQueue {
    public static boolean checkPalindrome(String str) {
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        str = str.replaceAll("\\s+","").toLowerCase();

        for (char c : str.toCharArray()) {
            queue.add(c);
            stack.push(c);
        }

        while (!queue.isEmpty()) {
            if (queue.remove() != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}
