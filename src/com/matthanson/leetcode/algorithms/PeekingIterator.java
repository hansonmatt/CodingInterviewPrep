package com.matthanson.leetcode.algorithms;

import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 * Created by matthans on 10/18/16.
 */
public class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> i;
    private Integer next;

    public PeekingIterator(Iterator<Integer> iterator) {
        i = iterator;
        if (i != null && i.hasNext()) {
            next = i.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (next == null) {
            throw new NoSuchElementException();
        }

        Integer toReturn = Integer.valueOf(next);

        if (i != null && i.hasNext()) {
            next = i.next();
        } else {
            next = null;
        }

        return toReturn;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}
