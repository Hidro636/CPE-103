
import java.util.NoSuchElementException;

/**
 * A simple interface that specifies the functionality for a queue-based data
 * structure
 *
 * @author Lucas Robertson
 * @version Program 3
 * @param <T> The generic type of the queue
 */
public interface SimpleQueue<T> {

    /**
     * Removes and returns the element at the front of this queue.
     *
     * @return the element that was removed from the front of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    public T dequeue() throws NoSuchElementException;

    /**
     * Adds the specified element to the end of this queue
     *
     * @param element the element to add to the end of this queue
     */
    public void enqueue(T element);

    /**
     * Returns the element at the front of this queue (but does not remove it).
     *
     * @return The element at the front of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    public T peek() throws NoSuchElementException;

    /**
     * Returns the number of elements in this queue.
     *
     * @return the number of elements in this queue
     */
    public int size();

}
