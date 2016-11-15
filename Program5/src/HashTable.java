
/**
 *
 * @author Lucas Robertson
 * @version Program 5
 */
public interface HashTable<T> {

    /**
     * Adds the specified element to this table if it is not already present
     *
     * @param element the element to be added to this table
     * @return true if this table did not already contain the specified element
     */
    public boolean add(T element);

    /**
     * Returns true is this table contains the specified element
     *
     * @param element the element whose presence in this table is to be tested
     * @return true if this table contains the specified element
     */
    public boolean contains(T element);

    /**
     * Returns true if this table contains no elements.
     *
     * @return true if this table contains no elements.
     */
    public boolean isEmpty();

    /**
     * Returns the current load factor of the hash table. This is the number of
     * entries in the table divided by the size of the underlying array.
     *
     * @return the current load factor of the hash table.
     */
    public double loadFactor();

    /**
     * Removes the specified element from this table if it is present
     *
     * @param element the key whose entry is to be removed from this table
     * @return true if this table contained the specified element
     */
    public boolean remove(T element);

    /**
     * Returns the number of elements in this table.
     *
     * @return the number of elements in this table
     */
    public int size();

    /**
     * Returns the hash table size. This is the length of the underlying array.
     *
     * @return the hash table size
     */
    public int tableSize();

}
