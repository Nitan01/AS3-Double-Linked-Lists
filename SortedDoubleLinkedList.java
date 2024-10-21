package application;

import java.util.Comparator;
import java.util.ListIterator;

/**
 * A generic sorted double linked list that uses a provided Comparator to maintain order.
 * It extends the BasicDoubleLinkedList class.
 * @param Nitan Touch
 * @param <T> The data element type
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {

    private final Comparator<T> comparator;

    /**
     * Creates an empty list that is associated with the specified comparator.
     *
     * @param compareableObject Comparator to compare data elements
     */
    public SortedDoubleLinkedList(Comparator<T> compareableObject) {
        this.comparator = compareableObject;
    }

    /**
     * Inserts the specified element at the correct position in the sorted list.
     * Notice that we can insert the same element several times.
     * This implementation traverses the list only once to perform the insertion.
     *
     * @param data The data to be added to the list
     */
    public void add(T data) {
        Node newNode = new Node(data); // Use BasicDoubleLinkedList.Node instead of ListNode
        
        if (head == null) { // List is empty
            head = tail = newNode;
        } else {
            Node currentNode = head;
            Node previousNode = null;

            // Traverse the list to find the correct position
            while (currentNode != null && comparator.compare(data, currentNode.data) > 0) {
                previousNode = currentNode;
                currentNode = currentNode.next;
            }

            // Insert at the beginning
            if (previousNode == null) {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            } 
            // Insert at the end
            else if (currentNode == null) {
                previousNode.next = newNode;
                newNode.prev = previousNode;
                tail = newNode;
            } 
            // Insert in the middle
            else {
                newNode.next = currentNode;
                newNode.prev = previousNode;
                previousNode.next = newNode;
                currentNode.prev = newNode;
            }
        }

        size++; // Update size of the list
    }

    /**
     * This operation is invalid for a sorted list.
     *
     * @throws UnsupportedOperationException Always thrown
     */
    @Override
    public void addToEnd(T data) {
        throw new UnsupportedOperationException("Invalid operation for sorted list.");
    }

    /**
     * This operation is invalid for a sorted list.
     *
     * @throws UnsupportedOperationException Always thrown
     */
    @Override
    public void addToFront(T data) {
        throw new UnsupportedOperationException("Invalid operation for sorted list.");
    }

    /**
     * Implements the iterator by calling the super class iterator method.
     *
     * @return An iterator positioned at the head of the list
     */
    @Override
    public ListIterator<T> iterator() {
        return super.iterator(); // Calls the iterator of the BasicDoubleLinkedList
    }

    /**
     * Implements the remove operation by calling the super class remove method.
     *
     * @param data The data element to be removed
     * @param comparator The comparator to determine equality of data elements
     * @return A node containing the data or null
     */
    @Override
    public Node remove(T data, Comparator<T> comparator) {
        return super.remove(data, comparator); // Calls the remove method of the BasicDoubleLinkedList
    }
}