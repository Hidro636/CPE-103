
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
        if (PrimeTools.isPrime(tableSize)) {
            table = new HashTableSC.Node[tableSize];
        } else {
            table = new HashTableSC.Node[PrimeTools.nextPrime(tableSize)];
        }

        collisions = 0;
        maxCollisions = 1;
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

        if (table[index] == null) {
            table[index] = new Node(index, element);
            size++;
            return true;
        } else {
            Node current = table[index];
            int curCol = 1;
            collisions++;
            while (current != null) {
                if (current.value.equals(element)) {
                    return false;
                } else {
                    current = current.next;
                    collisions++;
                    curCol++;
                }
            }

            current = table[index];
            table[index] = new Node(index, element);
            table[index].next = current;

            if (curCol > maxCollisions) {
                maxCollisions = curCol;
            }
            size++;
            return true;
        }
    }

    @Override
    public boolean contains(T element) {
        int index = Math.abs(element.hashCode()) % tableSize();

        if (table[index] == null) {
            return false;
        } else {
            Node current = table[index];
            while (current != null) {
                if (current.value.equals(element)) {
                    return true;
                } else {
                    current = current.next;
                }
            }
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

        if (table[index] == null) {
            return false;
        } else if (table[index].value.equals(element)) {
            table[index] = table[index].next;
            size--;
            return true;
        } else {
            Node current = table[index];
            while (current.next != null) {
                if (current.next.value.equals(element)) {
                    current.next = current.next.next;
                    size--;
                    return true;
                } else {
                    current = current.next;
                }
            }
        }

        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int tableSize() {
        return this.table.length;
    }

    @Deprecated
    public void _print() {
        for (Node n : table) {
            while (n != null) {
                System.out.print(n.value + "-");
                n = n.next;
            }
            System.out.println("null");
        }

        System.out.println("~~~~~~~~~~~~\n");
    }
}
