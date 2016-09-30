
/**
 *
 * @author Lucas Robertson
 * @version Lab 1
 *
 * @param <T> The generic type of the list
 */
public class SimpleLinkedList<T> implements SimpleList<T> {

    private int size;
    private final Node first;
    private final Node last;

    /**
     * List constructor
     */
    public SimpleLinkedList() {
        size = 0;
        first = new Node(null);
        last = new Node(null);
        first.next = last;
        last.previous = first;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || ((size == 0 && index != 0) || (index >= size && size != 0))) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> current = first.next;
        int i = 0;
        while (i < index) {
            current = current.next;
            i++;
        }

        Node<T> newNode = new Node(element);
        newNode.next = current;
        newNode.previous = current.previous;

        current.previous.next = newNode;
        current.next.previous = newNode;

        size++;
    }

    @Override
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        Node<T> previousLast = last.previous;

        newNode.next = last;
        newNode.previous = previousLast;
        previousLast.next = newNode;

        last.previous = newNode;

        size++;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> current = first.next;
        int i = 0;
        while (i < index) {
            current = current.next;
            i++;
        }

        return current.value;

    }

    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> current = first.next;
        int i = 0;
        while (i < index) {
            current = current.next;
            i++;
        }

        current.previous.next = current.next;
        current.next.previous = current.previous;
        size--;

        return current.value;
    }

    @Override
    public int size() {
        return this.size;
    }

    private class Node<Element> {

        private Element value;
        private Node next;
        private Node previous;

        public Node(Element value) {
            this.value = value;
        }
    }

}
