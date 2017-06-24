package com.walker.algorithm.reverse;

import sun.awt.image.ImageWatched;

/**
 * Created by walker on 2017/3/19.
 */
public class LinkedList<T> {
    private T element;
    private LinkedList<T> next;

    public LinkedList(T element, LinkedList<T> next) {
        this.element = element;
        this.next = next;
    }

    public T getElement(){
        return element;
    }

    public LinkedList<T> getNext() {
        return next;
    }

    public LinkedList<T> reverse(LinkedList<T> origin) {
        if (origin.getNext() == null) {
            return origin;
        }
        final LinkedList<T> nextList = origin.next;
        origin.next = null;
        final LinkedList<T> nextListReversed = reverse(nextList);
        nextListReversed.next = origin;
        return nextListReversed;
    }
}
