package ss11_stack_queue.thuc_hanh.stack_queue_linkedlist;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class MyGenericStack<T> {
    private LinkedList<T> stack;

    public MyGenericStack() {
        stack = new LinkedList<>();
    }

    public void push(T elements) {
        stack.addFirst(elements);
    }

    public T pop() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.removeFirst();
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        if (stack.size() == 0) {
            return true;
        }
        return false;
    }

    static void stackOfStrings() {
        MyGenericStack<String> stack = new MyGenericStack<>();

        stack.push("Five");
        stack.push("Four");
        stack.push("Three");
        stack.push("Two");
        stack.push("One");

        System.out.println("1. size of stack: " + stack.size());

        System.out.println("2. pop elements: ");
        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        System.out.println("3. size of stack before pop: " + stack.size());
    }

    static void stackOfIntergers() {
        MyGenericStack<Integer> stack = new MyGenericStack<>();

        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        System.out.println("1. size of stack: " + stack.size());

        System.out.println("2. pop elements: ");
        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        System.out.println("3. size of stack before pop: " + stack.size());
    }

}
