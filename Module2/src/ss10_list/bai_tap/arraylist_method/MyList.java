package ss10_list.bai_tap.arraylist_method;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        if (capacity > 0) {
            elements = new Object[capacity];
        } else if (capacity == 0) {
            elements = new Object[DEFAULT_CAPACITY];
        } else {
            throw new IllegalArgumentException("Khong du bo nho: " + capacity);
        }
    }

    public void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = Math.max(minCapacity, elements.length * 2);
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    void add(int index, E element) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (size == elements.length) {
            ensureCapacity(elements.length * 2);
        }

        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }

        elements[index] = element;
        size++;
    }

    public E remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        E data = (E) elements[index];

        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        elements[--size] = null;
        return data;
    }

    int size() {
        return size;
    }

    public MyList<E> clone() {
        MyList<E> newList = new MyList<>(elements.length);
        newList.size = this.size;
        newList.elements = Arrays.copyOf(elements, elements.length);
        return newList;
    }

    public boolean contains(E o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    public boolean add(E e) {
        if (size == elements.length) {
            ensureCapacity(elements.length * 2);
        }
        elements[size++] = e;
        return true;
    }

    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        return (E) elements[index];
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

}
