package com.walker.algorithm.list;

import java.util.LinkedList;

/**
 * Created by walker on 2017/3/19.
 */
public class SimpleLinkedList<E> {

    private Element<E> head;


    /**
     * 静态内部类
     * @param <E>
     */
    private static class Element<E> {
        private E value;
        private Element<E> next;

        public Element(E value) {
            this.value = value;
        }

    }

    public static void main(String[] args) {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Element<E> current = head;
        while (current != null) {
            sb.append(current.value).append(",");
            current = current.next;
        }
        sb.deleteCharAt(sb.lastIndexOf(",")).append("]");
        return sb.toString();
    }

    public void add(E value) {
        if (head == null) {
            head = new Element(value);
        }else {
            Element<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Element<E>(value);
        }
    }


}
