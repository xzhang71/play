package cci;

import java.util.Iterator;

/**
 * Created by xzhang71 on 7/21/14.
 */
public class CircularArrayIterator<E> implements Iterator<E> {

    private CircularArray<E> circularArray;
    // IMPORTANT
    private int current = -1;

    public CircularArrayIterator(CircularArray circularArray) {
        this.circularArray = circularArray;
    }

    @Override
    public boolean hasNext() {
        return current < circularArray.length() - 1;
    }

    @Override
    public E next() {
        current++;
        return circularArray.get(current);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
