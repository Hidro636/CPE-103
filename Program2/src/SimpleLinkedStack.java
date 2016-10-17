
import java.util.NoSuchElementException;

/**
 * A stack that implements a linked list
 *
 * @author Lucas Robertson
 * @version Program 2
 * @param <T> The generic type of the stack
 */
public class SimpleLinkedStack<T> implements SimpleStack<T> {

    private int size;
    private Node head;

    public SimpleLinkedStack() {
        this.size = 0;
    }

    @Override
    public T peek() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        return head.value;
    }

    @Override
    public T pop() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        T current = head.value;
        head = head.next;
        size--;
        return current;
    }

    @Override
    public void push(T element) {
        Node current = head;
        head = new Node(element);
        head.next = current;
        size++;
    }

    @Override
    public int size() {
        return this.size;
    }

    private class Node {

        private Node next;
        private final T value;

        public Node(T value) {
            this.value = value;
        }
    }

}
