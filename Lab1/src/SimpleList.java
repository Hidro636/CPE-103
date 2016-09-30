
/**
 * A simple list interface
 *
 * @author Lucas Robertson
 * @version Lab 1
 */
public interface SimpleList<T> {

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent
     * elements to the right (numerically greater).
     *
     * @param index the index at which the element is to be inserted
     * @param element the element to be inserted
     */
    void add(int index, T element);

    /**
     * Appends the specified element to the end of this list. Allows null
     * elements to be added to the list.
     *
     * @param element the element to be appended to this list
     */
    void add(T element);

    /**
     * Returns the element at the specified position in this list
     *
     * @param index the index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is less than zero or
     * greater than or equal to the size() of the list
     */
     T get(int index) throws IndexOutOfBoundsException;

    /**
     * Removes the element at the specified index in this list. Shifts any
     * subsequent elements to the left (numerically lower).
     *
     * @param index  the index of the element to be removed
     * @return the element previously at the specified position (that was just removed)
     * @throws IndexOutOfBoundsException  if the index is less than zero or greater than or equal to the size() of the list
     */
    T remove(int index) throws IndexOutOfBoundsException;

    /**
     * Returns the number of elements in this list (elements that have been added by the creator/user of the list).
     * 
     * @return the number of elements in this list
     */
    int size();

}
