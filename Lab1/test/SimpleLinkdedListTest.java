import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit tests for SimpleLinkedList.
 *
 * @author Brian Jones
 * @version Lab 1
 */
public class SimpleLinkdedListTest {
    
    public SimpleLinkdedListTest() {
    }

    @Test
   public void testSize_empty() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
      assertTrue(list.size() == 0);
   }

   @Test(expected=IndexOutOfBoundsException.class)
   public void testAdd_atConstuctionOutOfBounds() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
      list.add(25, null);
   }

   @Test(expected=IndexOutOfBoundsException.class)
   public void testRemove_atConstruction() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
      list.remove(0);
   }

   @Test
   public void testAddSize() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();

      list.add(5);
      list.add(10);
      list.add(15);
      list.add(20);
      assertTrue(listEquals(list, new int[] {5, 10, 15, 20}));
      assertTrue(list.size() == 4);
   }

   private boolean listEquals(SimpleLinkedList<Integer> list, int[] a) {
      if (list.size() != a.length) {
         return false;
      }

      for (int i = 0; i < a.length; i++) {
         if (list.get(i) != a[i]) {
            return false;
         }
      }

      return true;
   }
    
}
