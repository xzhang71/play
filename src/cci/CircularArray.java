package cci;

import java.util.Iterator;

/**
 * Created by xzhang71 on 7/21/14.
 */
public class CircularArray<T> implements Iterable<T> {
    private T[] buffer;
    private int head;

    public CircularArray(int size) {
        // IMPORTANT
        buffer = (T[]) new Object[size];
    }

    public void rotate(int n) {
        head = (head + n) % buffer.length;
    }

    public T get(int i) {
        if (i < 0 || i >= buffer.length) {
            throw new IndexOutOfBoundsException();
        }
        return buffer[(head + i) % buffer.length];
    }

    public void set(int i, T item) {
        if (i < 0 || i >= buffer.length) {
            throw new IndexOutOfBoundsException();
        }
        buffer[(head + i) % buffer.length] = item;
    }

    public int length() {
        return buffer.length;
    }

    @Override
    public Iterator<T> iterator() {
        return new CircularArrayIterator<>(this);
    }

    public static void main(String[] args) {
        CircularArray<Integer> array = new CircularArray<>(10);
        for (int i = 0; i < array.length(); i++) {
            array.set(i, i);
        }

        array.rotate(5);
        Iterator iter = array.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
    }
}