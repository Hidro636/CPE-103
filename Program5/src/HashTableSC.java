
/**
 * A hash table that uses separate chaining as its method of collisions resolution.
 *
 * @author Lucas Robertson
 * @version Program 5
 * @param <T> The type of elements maintained by this table
 */
public class HashTableSC<T> implements HashMetrics, HashTable<T> {

    private int size;
    private HashTableSC.Node[] table;

    private long collisions;
    private int maxCollisions;

    private class Node {

        public Node next;
        public int key;
        public T value;
        public boolean removed;

        public Node(int key, T value) {
            this.key = key;
            this.value = value;
            next = null;
            removed = false;
        }
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

        this.size = 0;
        table = new HashTableSC.Node[PrimeTools.nextPrime(tableSize)];

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
        int index = Math.abs(element.hashCode()) % tableSize();

        boolean contains = false;
        Node current = table[index];
        while (current != null) {
            if (current.value == element) {
                contains = !current.removed;
                break;
            }
            current = current.next;
        }

        if (contains) { //Already contains the element
            return false;
        } else if (table[index] == null || table[index].removed) { //No element at the given position
            table[index] = new Node(index, element);
        } else { //Collision
            current = table[index];
            int curCol = 1;
            collisions++;
            while (current.next != null) {
                collisions++;
                curCol++;
                current = current.next;
                if (current.removed) {
                    Node temp = current.next;
                    current = new Node(index, element);
                    current.next = temp;
                }
            }

            current.next = new Node(index, element);

            if (curCol > maxCollisions) {
                maxCollisions = curCol;
            }
        }

        size++;
        return true;
    }

    @Override
    public boolean contains(T element) {
        int index = Math.abs(element.hashCode()) % tableSize();
        Node current = table[index];
        while (current != null) {
            if (current.value.equals(element)) {
                return !current.removed;
            }
            current = current.next;
        }

        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public double loadFactor() {
        return (double) this.size / (double) tableSize();
    }

    @Override
    public boolean remove(T element) {
        int index = element.hashCode() % tableSize();

        if (!contains(element)) {
            return false;
        } else {
            Node current = table[index];
            while (current.value != element) {
                current = current.next;
            }
            current.removed = true;
            size--;
            return true;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int tableSize() {
        return this.table.length;
    }
}
