
/**
 * A hash table that uses separate chaining as its method of collisions resolution.
 *
 * @author Lucas Robertson
 * @version Program 5
 * @param <T> The type of elements maintained by this table
 */
public class HashTableSC<T> implements HashMetrics, HashTable<T> {

    private int size;
    private int tableSize;
    private T[] table;

    private long collisions;
    private int maxCollisions;

    private class Node {

        private Node next;
    }

    /**
     * Constructs an empty HashTableSC whose size if the first prime number
     * greater than or equal to the specified table size.
     *
     * @param tableSize the desired size of this hash table; if it is not a
     * prime number, the next prime number is used
     * @throws IllegalArgumentException if the specified tableSize is negative
     */
    public HashTableSC(int tableSize) {
        if (tableSize < 0) {
            throw new IllegalArgumentException();
        }

        this.tableSize = tableSize;
        this.size = 0;
        table = (T[]) new Object[tableSize];

        collisions = 0;
        maxCollisions = 0;
    }

    @Override
    public long collisions() {
        return this.collisions;
    }

    @Override
    public int maxCollisions() {
        return this.maxCollisions;
    }

    @Override
    public boolean add(T element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(T element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double loadFactor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(T element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int tableSize() {
        return this.tableSize;
    }
}
