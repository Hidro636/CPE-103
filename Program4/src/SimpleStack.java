
import java.util.NoSuchElementException;

/**
 *
 * @author Lucas Robertson
 * @version Program 4
 * @param <T> The generic type of the stack
 */
public interface SimpleStack<T> {

    /**
     * Returns the element on the top of this stack (but does not remove it).
     *
     * @return the element on the top of this stack
     */
    public T peek() throws NoSuchElementException;

    /**
     * Removes and returns the element on the top of this stack.
     *
     * @return the element on the top of this stack
     *
     */
    public T pop() throws NoSuchElementException;

    /**
     * Adds the specified element to the top of this stack.
     *
     * @param element the element to add to the top of this stack
     */
    public void push(T element);

    /**
     * Returns the number of elements in this stack.
     *
     * @return the number of elements in this stack
     */
    public int size();

}
