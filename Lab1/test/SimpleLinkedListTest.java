
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lucas Robertson
 * @version Lab 1
 */
public class SimpleLinkedListTest {

    public SimpleLinkedListTest() {
    }

    /**
     * Test of add method, of class SimpleLinkedList.
     */
    @Test
    public void testAdd_int_GenericType() {
        System.out.println("\nTesting add()...");
        int index = 0;
        Object element = 13;
        SimpleLinkedList instance = new SimpleLinkedList();

        instance.add(1);
        instance.add(2);
        instance.add(3);
        instance.add(4);
        instance.add(5);

        System.out.println("Before add:");
        traverseList(instance);

        instance.add(index, element);

        System.out.println("After add (i = 0):");
        traverseList(instance);

        assertEquals(instance.get(0), 13);
        assertEquals(instance.get(1), 1);

    }

    /**
     * Test of add method, of class SimpleLinkedList.
     */
    @Test
    public void testAdd_GenericType() {
        System.out.println("\nTesting add()...");
        Object element = "Node";
        SimpleLinkedList instance = new SimpleLinkedList();

        System.out.println("Before add:");
        traverseList(instance);

        instance.add(element);

        System.out.println("After add:");
        traverseList(instance);

        assertEquals(instance.get(0), element);

    }

    /**
     * Test of get method, of class SimpleLinkedList.
     */
    @Test
    public void testGet() {
        System.out.println("\nTesting get()...");
        int index = 1;
        SimpleLinkedList instance = new SimpleLinkedList();

        instance.add(5);
        instance.add(3);
        instance.add(10);
        instance.add(1);
        System.out.println("List size: " + instance.size());

        Object expResult = 3;
        Object result = instance.get(index);
        assertEquals(expResult, result);

        instance.add(12);
        expResult = 12;
        index = 4;
        result = instance.get(index);
        assertEquals(expResult, result);

    }

    /**
     * Test of remove method, of class SimpleLinkedList.
     */
    @Test
    public void testRemove() {
        System.out.println("\nTesting remove()...");
        int index = 3;
        SimpleLinkedList instance = new SimpleLinkedList();

        instance.add(1);
        instance.add(2);
        instance.add(3);
        instance.add(4);
        instance.add(5);
        instance.add(6);

        System.out.println("Before remove:");
        traverseList(instance);

        Object expResult = 4;
        Object result = instance.remove(index);
        assertEquals(expResult, result);

        System.out.println("After remove (i = 3) :");
        traverseList(instance);

        expResult = 5;
        result = instance.get(index);
        assertEquals(expResult, result);

        instance.remove(0);
        result = instance.get(0);
        expResult = 2;
        assertEquals(expResult, result);

        System.out.println("After remove (i = 0):");
        traverseList(instance);
    }

    /**
     * Test of size method, of class SimpleLinkedList.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        SimpleLinkedList instance = new SimpleLinkedList();

        instance.add(1);
        instance.add(1);
        instance.add(5);

        int expResult = 3;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    private void traverseList(SimpleLinkedList instance) {

        System.out.print("Start <-> ");

        for (int i = 0; i < instance.size(); i++) {
            System.out.print(instance.get(i) + " <-> ");
        }
        System.out.println("End");
    }

}
