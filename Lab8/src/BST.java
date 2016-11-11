
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Provided BST class skeleton for students to complete. This class makes use of
 * Object Oriented structural recursion to solve the problem.
 *
 * Original Revision:
 *
 * @author Hatalsky/Jones
 * @version Lab 8
 *
 * Completed By:
 * @author Lucas Robertson
 * @param <T> The generic, comparable type of the binary search tree
 */
public class BST<T extends Comparable<? super T>> {
    // Instance variables for BST class.
    // These are the only ones allowed!

    private final BSTNode<T> EMPTY_NODE = new EmptyNode();
    private BSTNode<T> root = EMPTY_NODE;
    private int size;

    // Polymorphic BST node type!
    private interface BSTNode<T> {

        public BSTNode<T> insert(T element);

        public BSTNode<T> remove(T element);

        public boolean contains(T element);

        public T minimum(T minimum);

        public T maximum(T maximum);

        public int treeHeight(int max, int height);

        public long internalPathLength(int depth);

        public void toSortedList(List<T> list);

        /**
         * Determines if the given node has children and whether they are a
         * right or left child
         *
         * @return 0 if the given node has no children, -1 if the node only has
         * a left child, 1 if the node only has a right child, and 2 if the node
         * has both a left and right child
         */
        public int childrenStatus();

        public void _print();
    }

    ////////////////////////////////////////////////////////////////////////////
    // BST class methods...
    //
    /**
     * Inserts an element into the BST. If the element is already in the BST,
     * the element being inserted is discarded.
     *
     * @param element The element to insert into the BST
     *
     * @throws IllegalArgumentException if the element is null
     */
    public void insert(T element) {
        if (element == null) {
            throw new IllegalArgumentException();
        }

        root = root.insert(element);
    }

    /**
     * Removes an element from the BST
     *
     * @param element The element to remove from the BST
     *
     * @throws NoSuchElementException if the element does not exist in the BST
     */
    public void remove(T element) {
        root = root.remove(element);
        size--;
    }

    /**
     * Determines whether or not an element is in the BST.
     *
     * @param element the element to search for in the BST
     *
     * @return true if the element is in the BST, false otherwise
     */
    public boolean contains(T element) {
        if (element == null) {
            return false;
        }

        return root.contains(element);
    }

    /**
     * Finds the minimum element in the BST.
     *
     * @return the minimum element in the BST
     *
     * @throws NoSuchElementException if the BST is empty
     */
    public T minimum() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        return root.minimum(((Node) root).element);
    }

    /**
     * Finds the maximum element in the BST.
     *
     * @return the maximum element in the BST
     *
     * @throws NoSuchElementException if the BST is empty
     */
    public T maximum() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        return root.maximum(((Node) root).element);
    }

    /**
     * Takes the elements in the BST and places them in ascending order into the
     * list.
     *
     * @param list the list in which you will place elements
     */
    public void toSortedList(List<T> list) {
        root.toSortedList(list);
    }

    public int size() {
        return size;
    }

    /**
     * Returns the height of the BST
     *
     * @return the height of the BST
     */
    public int treeHeight() {
        return root.treeHeight(-1, -1);
    }

    /**
     * Returns the internal path length of the BST, which is a general measure
     * for the efficiency of the tree's structure
     *
     * @return The sum of all nodes' depths within the BST
     */
    public long internalPathLength() {
        return root.internalPathLength(0);
    }

    public void _print() {
        root._print();
        System.out.println();
    }

    ////////////////////////////////////////////////////////////////////////////
    // private EmptyNode class...
    //
    private class EmptyNode implements BSTNode<T> {
        // No instance variables needed or allowed!

        public BSTNode<T> insert(T element) {
            size++;
            return new Node(element);
        }

        public boolean contains(T element) {
            return false;
        }

        public T minimum(T element) {
            return element;
        }

        public T maximum(T element) {
            return element;
        }

        public void toSortedList(List<T> list) {
            return;
        }

        @Override
        public BSTNode<T> remove(T element) {
            throw new NoSuchElementException();
        }

        @Override
        public int treeHeight(int max, int height) {
            if (height > max) {
                return height;
            } else {
                return max;
            }
        }

        @Override
        public long internalPathLength(int depth) {
            return depth - 1;
        }

        @Override
        public int childrenStatus() {
            return 0;
        }

        public void _print() {

        }
    }

    ////////////////////////////////////////////////////////////////////////////
    // private Node class...
    //
    private class Node implements BSTNode<T> {
        // These are the only instance variables needed and the only ones
        // allowed!

        T element;
        BSTNode<T> left, right;

        public Node(T element) {
            this.element = element;
            this.left = EMPTY_NODE;
            this.right = EMPTY_NODE;
        }

        // You may (and probably want to) write constructor(s)
        public BSTNode<T> insert(T element) {
            if (this.element.compareTo(element) < 0) {
                right = right.insert(element);
            } else if (this.element.compareTo(element) > 0) {
                left = left.insert(element);
            }

            return this;
        }

        public boolean contains(T element) {
            if (this.element.compareTo(element) == 0) {
                return true;
            } else if (this.element.compareTo(element) > 0) {
                return left.contains(element);
            } else {
                return right.contains(element);
            }
        }

        public T minimum(T element) {
            return left.minimum(this.element);
        }

        public T maximum(T element) {
            return right.maximum(this.element);
        }

        public void toSortedList(List<T> list) {
            left.toSortedList(list);
            list.add(element);
            right.toSortedList(list);
        }

        @Override
        public BSTNode<T> remove(T element) {
            if (this.element.compareTo(element) == 0) {
                if (left == EMPTY_NODE && right == EMPTY_NODE) {
                    return EMPTY_NODE;
                } else if (left != EMPTY_NODE && right != EMPTY_NODE) {
                    this.element = right.minimum(this.element);
                    right = right.remove(this.element);
                } else if (left == EMPTY_NODE && right != EMPTY_NODE) {
                    return right;
                } else {
                    return left;
                }

            } else if (this.element.compareTo(element) > 0) {
                left = left.remove(element);
            } else {
                right = right.remove(element);
            }
            return this;
        }

        @Override
        public int treeHeight(int max, int height) {
            max = left.treeHeight(max, height + 1);
            max = right.treeHeight(max, height + 1);

            return max;
        }

        @Override
        public long internalPathLength(int depth) {
            int sum = 0;

            if (left != EMPTY_NODE) {
                sum += left.internalPathLength(depth + 1);
            }

            if (right != EMPTY_NODE) {
                sum += right.internalPathLength(depth + 1);
            }

            return depth + sum;
        }

        @Override
        public int childrenStatus() {
            if (left == EMPTY_NODE && right == EMPTY_NODE) {
                return 0;
            } else if (left != EMPTY_NODE && right != EMPTY_NODE) {
                return 2;
            } else if (left == EMPTY_NODE && right != EMPTY_NODE) {
                return 1;
            } else if (left != EMPTY_NODE && right == EMPTY_NODE) {
                return -1;
            } else {
                System.out.println("Fuck");
                return 11111;
            }
        }

        public void _print() {
            left._print();
            right._print();
            System.out.print(this.element + " ");

        }

    }
}
