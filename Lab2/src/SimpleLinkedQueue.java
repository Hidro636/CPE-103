
import java.util.NoSuchElementException;

/**
 * A class that implements basic queue functionality
 *
 * @author Lucas Robertson
 * @version Lab 2
 * @param <T> The generic type of the queue
 */
public class SimpleLinkedQueue<T> implements SimpleQueue<T> {

    private int size;
    private final Node first;
    private final Node last;

    /**
     * Queue constructor - Initializes first and last with null values and
     * creates their initial relation
     */
    public SimpleLinkedQueue() {
        size = 0;
        first = new Node(null);
        last = new Node(null);

        first.next = last;
        last.previous = first;
    }

    @Override
    public T dequeue() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException("The queue is empty!");
        }

        Node<T> dequeued = first.next;
        dequeued.next.previous = first;
        first.next = dequeued.next;

        size--;

        return dequeued.value;
    }

    @Override
    public void enqueue(T element) {
        Node<T> newNode = new Node<>(element);
        Node<T> previousLast = last.previous;

        newNode.next = last;
        newNode.previous = previousLast;
        previousLast.next = newNode;

        last.previous = newNode;

        size++;
    }

    @Override
    public T peek() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException("The queue is empty!");
        }

        return (T) first.next.value;
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
