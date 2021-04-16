package by.chakun.list.linked;

import lombok.Data;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

@Data
public class CustomLinkedList<T> implements Iterable<T> {

    private Node head;
    private Node last;
    private int size;


    public CustomLinkedList() {
        this.head = null;
        this.last = null;
        this.size = 0;
    }


    @Data
    private class Node {

        private T data;
        private Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }

    }

    public void add(T item) {
        if (Objects.isNull(item)) {
            throw new IllegalArgumentException("Bad item!");
        }

        if (!isEmpty()) {
            Node prev = last;
            last = new Node(item);
            prev.next = last;
        } else {
            last = new Node(item);
            head = last;
        }

        this.size++;
    }

    public boolean remove(T item) {
        if (isEmpty()) {
            throw new IllegalStateException("Can`t remove because list is empty!");
        }

        boolean result = false;
        Node prev = head;
        Node curr = head;

        while (curr.next != null || curr == last) {
            if (curr.data.equals(item)) {
                // remove the last remaining element
                if (size == 1) {
                    head = null;
                    last = null;
                }
                // remove first element
                else if (curr.equals(head)) {
                    head = head.next;
                }
                // remove last element
                else if (curr.equals(last)) {
                    last = prev;
                    last.next = null;
                }
                // remove element
                else {
                    prev.next = curr.next;
                }
                size--;
                result = true;
                break;
            }
            prev = curr;
            curr = prev.next;
        }

        return result;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomLinkedListIterator();
    }


    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (T item : this) {
            s.append(item).append(" ");
        }
        return s.toString();
    }


    /**
     *
     */
    private class CustomLinkedListIterator implements Iterator<T> {

        private Node current = head;

        @Override
        public boolean hasNext() {
            return Objects.nonNull(this.current);
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Next element is not presented!");
            }

            T item = current.getData();
            current = current.getNext();
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove is not supported yet");
        }

    }


}

