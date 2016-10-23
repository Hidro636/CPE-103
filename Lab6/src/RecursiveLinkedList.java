
/**
 * A provided, partially complete, simple, recursive, singly-linked list
 * for CPE 103 Lab 6.
 *
 * @author Hatalsky/Jones (Provided skeleton).
 *
 * Insert you name as the second author below as the person that completed
 * the class.
 *
 * @author Lucas Robertson
 * @version CPE 103 Lab 6
 */
// Class invariants:
//
// The head reference is never null.
// The head node's next field will be null when the list is empty.
// The next field of the last node in the list is always null.
public class RecursiveLinkedList<T> implements SimpleList<T> {

    private class Node {

        public Node next;
        public T e;

        public Node() {
        }

        public Node(Node next, T e) {
            this.next = next;
            this.e = e;
        }
    }

    private Node head;
    private Throwable stackTrace;

    public RecursiveLinkedList() {
        head = new Node();
    }

    @Override
    public void add(T element) {
        head.next = add(head.next, element);
    }

    public void addAlt(T element) {
        addAlt(head, element);
    }

    //Implement these methods ---------------------------------------------------
    @Override
    public void add(int index, T element) {
        stackTrace = new Throwable();

        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }

        add(index, element, head);
    }

    private void add(int index, T element, Node node) {
        stackTrace = new Throwable();

        if (index == 0) {
            node.next = new Node(node.next, element);
        } else if (node.next == null) {
            throw new IndexOutOfBoundsException();
        } else {
            add(index - 1, element, node.next);
        }
    }

    @Override
    public T get(int index) {
        stackTrace = new Throwable();

        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }

        return get(index, head);
    }

    // Private ALTERNATE recursive helper method for public get(index)
    private T get(int index, Node node) {
        stackTrace = new Throwable();

        if (node.next == null) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            return node.next.e;
        } else {
            return get(index - 1, node.next);
        }
    }

    @Override
    public T remove(int index) {
        stackTrace = new Throwable();
        throw new RuntimeException("You must complete this method!");
    }

    //---------------------------------------------------------------------------
    @Override
    public int size() {
        return size(head.next);
    }

    public Throwable stackTrace() {
        return stackTrace;
    }

    // Private recursive helper method for public add(T)
    private Node add(Node node, T e) {
        stackTrace = new Throwable();

        if (node == null) {
            return new Node(null, e);
        } else {
            node.next = add(node.next, e);
        }

        return node;
    }

    // Private ALTERNATE recursive helper method for public add(T)
    private void addAlt(Node node, T e) {
        stackTrace = new Throwable();

        if (node.next == null) {
            node.next = new Node(null, e);
        } else {
            addAlt(node.next, e);
        }
    }

    // Private recursive helper method for public size(int) 
    private int size(Node node) {
        stackTrace = new Throwable();

        if (node == null) {
            return 0;
        }

        return 1 + size(node.next);
    }
}
