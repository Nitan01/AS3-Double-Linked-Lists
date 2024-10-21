package application;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;

/**
 * A generic sorted double linked list that uses a provided Comparator to maintain order.
 * It extends the BasicDoubleLinkedList class.
 * @param Nitan Touch
 * @param <T> The data element type
 */

public class BasicDoubleLinkedList<T> implements Iterable<T> {
    protected Node head;
    protected Node tail;
    protected int size;

    /** Constructor to initialize head, tail and size */
    public BasicDoubleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /** Returns the size of the linked list */
    public int getSize() {
        return size;
    }

    /** Adds an element to the end of the list */
    public void addToEnd(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    /** Adds an element to the front of the list */
    public void addToFront(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    /** Returns but does not remove the first element from the list */
    public T getFirst() {
        return (head != null) ? head.data : null;
    }

    /** Returns but does not remove the last element from the list */
    public T getLast() {
        return (tail != null) ? tail.data : null;
    }

    /** Removes the first instance of the targetData from the list */
    public Node remove(T targetData, Comparator<T> comparator) {
        Node current = head;
        while (current != null) {
            if (comparator.compare(current.data, targetData) == 0) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next; // Update head if it's the first element
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev; // Update tail if it's the last element
                }
                size--;
                return current; // Return the removed node
            }
            current = current.next;
        }
        return null; // If not found
    }

    /** Removes and returns the first element from the list */
    public T retrieveFirstElement() {
        if (head == null) return null;
        T data = head.data;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null; // List is empty
        }
        size--;
        return data;
    }

    /** Removes and returns the last element from the list */
    public T retrieveLastElement() {
        if (tail == null) return null;
        T data = tail.data;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null; // List is empty
        }
        size--;
        return data;
    }

    /** Returns an ArrayList of all the items in the list */
    public ArrayList<T> toArrayList() {
        ArrayList<T> list = new ArrayList<>();
        Node current = head;
        while (current != null) {
            list.add(current.data);
            current = current.next;
        }
        return list;
    }

    /** Returns an iterator for the linked list */
    @Override
    public ListIterator<T> iterator() {
        return new DoubleLinkedListIterator();
    }

    /** Inner class Node */
    protected class Node {
        T data;
        Node prev;
        Node next;

        /** Node constructor */
        public Node(T dataNode) {
            this.data = dataNode;
            this.prev = null;
            this.next = null;
        }
    }

    /** Inner class DoubleLinkedListIterator */
    protected class DoubleLinkedListIterator implements ListIterator<T> {
        private Node currentNode;
        private int currentIndex;

        /** Constructor */
        public DoubleLinkedListIterator() {
            currentNode = head;
            currentIndex = 0;
        }

        /** Checks if there is a next element */
        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        /** Returns the next element */
        @Override
        public T next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            T data = currentNode.data;
            currentNode = currentNode.next;
            currentIndex++;
            return data;
        }

        /** Checks if there is a previous element */
        @Override
        public boolean hasPrevious() {
            return currentNode != null && currentNode.prev != null;
        }

        /** Returns the previous element */
        @Override
        public T previous() {
            if (!hasPrevious()) {
                throw new java.util.NoSuchElementException();
            }
            currentNode = currentNode.prev;
            T data = currentNode.data;
            currentIndex--;
            return data;
        }

        // Other ListIterator methods can throw UnsupportedOperationException
        @Override
        public int nextIndex() {
            return currentIndex + 1;
        }

        @Override
        public int previousIndex() {
            return currentIndex - 1;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(T e) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(T e) {
            throw new UnsupportedOperationException();
        }
    }
}