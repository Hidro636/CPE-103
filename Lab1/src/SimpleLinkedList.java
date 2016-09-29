
/**
 *
 *
 * @author Lucas Robertson
 * @version Lab 1
 */
public class SimpleLinkedList implements SimpleList {

    private int size;
    private Node first;
    private Node last;

    public SimpleLinkedList() {
        this.size = 0;
        this.first = null;
        this.last = null;
    }

    @Override
    public <T> void add(int index, T element) {

    }

    @Override
    public <T> void add(T element) {
        if (size == 0) {
            first = new Node(element);
            last = first;
        } else {
            Node newNode = new Node(element);

            newNode.previous = last;
            last = newNode;
            last.previous.next = newNode;
        }

        size++;

    }

    @Override
    public <T> T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        
        int i = 0;
        Node current = first;
        while(i < index) {
            current = current.next;
        }
        
        return current.element;
    }

    @Override
    public <T> T remove(int index) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    private class Node<E> {

        public E element;
        public Node next;
        public Node previous;

        public Node(E element) {
            this.element = element;
            this.next = null;
            this.previous = null;
        }
    }

}
