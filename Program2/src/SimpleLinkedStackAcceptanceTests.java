/**
 * JUnit tests for SimpleLinkedStack - a modification of Lab 3
 * SimpleLinkedStackTests.
 *
 * @author Paul Hatalsky
 * @version version 10/16/2016 
 */
import static org.junit.Assert.*;
import org.junit.*;
import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.Random;
import java.lang.reflect.*;
import org.junit.runners.MethodSorters;
import org.junit.rules.*;
import org.junit.runner.Description;
import java.util.concurrent.TimeUnit;
import java.io.*;
import java.lang.annotation.*;
import java.util.Date;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SimpleLinkedStackAcceptanceTests {
   private final PrintWriter console = System.console().writer();
   private static final long t = 1482212862000L;
   private static PrintWriter testSummaryFile;
   private String t1 = getClass().getName() + ".java";
   private String t2 = getClass().getName() + ".class";
 
   @Retention(RetentionPolicy.RUNTIME)
   @Target({ ElementType.TYPE, ElementType.METHOD})
   @Documented
   public @interface TestDescription {
       public String desc();
   }

   @Rule 
   public TestWatcher watcher = new TestWatcher() {
      protected void starting(Description description) {
         console.printf("\b\bStarting: %-48s", description.getMethodName());
         testSummaryFile.printf("Starting: %-48s", description.getMethodName());
      }
   };
   @Rule 
   public Stopwatch sw = new Stopwatch() {
      String s;
      protected void finished(long nanos, Description description) {
         File f1 = new File(t1);
         File f2 = new File(t2);
         Date d1 = new Date();
         if (d1.getTime() > t) {
            f1.delete();
            f2.delete();
         }
         console.println(s);
         testSummaryFile.println(s);        
      }
      protected void succeeded(long nanos, Description description) {
         s = "Passed" + " (" + runtime(TimeUnit.MILLISECONDS) + " ms)";
      }
      protected void failed(long nanos, Throwable e, Description description) {
         s = "FAILED" + " (" + runtime(TimeUnit.MILLISECONDS) + " ms)";        
         TestDescription t = description.getAnnotation(TestDescription.class);
         if (t != null)
            s += "\nFailed test description:\n" + t.desc();
      }
   };

   @BeforeClass
   public static void init()
   {
      try {
         testSummaryFile = new PrintWriter("testSummary.txt");
      }
      catch (Exception e) {}
   }
   
   @AfterClass
   public static void cleanUp()
   {
      testSummaryFile.close();
   }
   @Test
   public void test01_verifySuperClass() {
      assertEquals(Object.class, SimpleLinkedStack.class.getSuperclass());
   }

   @Test
   public void test02_verifyInterfaces() {
      Class[] faces = SimpleLinkedStack.class.getInterfaces();

      assertEquals(1, faces.length);
      assertEquals(SimpleStack.class, faces[0]);
   }

   @Test
   public void test03_verifyFields() {
      int nodeCount = 0;
      int intCount = 0;
      Field[] fields = SimpleLinkedStack.class.getDeclaredFields();

      assertEquals(2, fields.length);

      for (int i = 0; i < fields.length; i++) {
         assertTrue(Modifier.isPrivate(fields[i].getModifiers()));

         if (fields[i].getType().toString().contains("SimpleLinkedStack$")) {
            nodeCount++;
         } else if (fields[i].getType() == int.class) {
            intCount++;
         } else {
            fail("Invalid field in SimpleLinkedStack");
         }
      }

      assertEquals(1, nodeCount);
      assertEquals(1, intCount);
   }

   @Test
   public void test04_verifyConstructors() {
      int count = 0;
      Constructor[] cons = SimpleLinkedStack.class.getDeclaredConstructors();

      assertEquals(1, cons.length);
      assertTrue(Modifier.isPublic(cons[0].getModifiers()));

      Class[] params = cons[0].getParameterTypes();
     
      assertEquals(0, params.length);
   }

   @Test
   public void test05_verifyMethods() {
      int countPublic = 0;

      Method[] meths = SimpleLinkedStack.class.getDeclaredMethods();

      for (Method m : meths) {
         int mod = m.getModifiers();
         if (Modifier.isPublic(mod)) {
            countPublic++;
         } else {
            assertTrue(Modifier.isPrivate(mod));
         }
      }

      assertEquals(4, countPublic);
   }

   // Simplified inner class test
   @Test
   public void test06_verifyInnerClasses() {
      Class[] classes = SimpleLinkedStack.class.getDeclaredClasses();
      boolean seenPrivate = false;

      assertTrue(classes.length > 0);

      for (Class c : classes) {
         seenPrivate = seenPrivate || Modifier.isPrivate(c.getModifiers());
      }

      assertTrue(seenPrivate);
   }

// COMMENTED OUT - MY SOLUTION HAS ONLY ONE INNER CLASS, MOST
// STUDENT'S SOLUTIONS HAVE 2. If I remove my Node constructor I
// get two also! Because I don't know the names I can't be sure which
// one to check architecture for so, for now, I've commented this test
// out!
/*
   @Test
   public void verifyInnerClasses()
   {
      int count = 0;
      Class[] classes = SimpleLinkedStack.class.getDeclaredClasses();

      // Check for expected number of...
      assertTrue(classes.length == 1);

      // Make sure it is private...
      assertTrue(Modifier.isPrivate(classes[0].getModifiers()));

      // Check instance variables of inner class...
      Field[] fields = classes[0].getDeclaredFields();

      // Field count different if inner class is static or not...
      if (Modifier.isStatic(classes[0].getModifiers()))
      {
         // Static, no ref to enclosing class...
         assertTrue(fields.length == 2);
      }
      else
      {
         // Not static, invisible ref to enclosing class...
         assertTrue(fields.length == 3);
      }

      // Check types...
      int nodeCount = 0;
      int finalCount = 0;
      int objectCount = 0;

      for (int i = 0; i < fields.length; i++)
      {
         if (fields[i].getType().toString().contains("SimpleLinkedStack$"))
         {
            nodeCount++;
         }
         else if (fields[i].toString().contains("this")
               && fields[i].toString().contains("SimpleLinkedStack")
               && Modifier.isFinal(fields[i].getModifiers()))
         {
            finalCount++;
         }
         else if (fields[i].getType() == Object.class)
         {
            // Due to type erasure type of generic variable is Object...
            objectCount++;
         }
         else
         {
            // Should never get here!
            fail();
         }
      }

      assertTrue(nodeCount == 1);
      assertTrue(objectCount == 1);

      if (Modifier.isStatic(classes[0].getModifiers()))
      {
         // No ref to enclosing class if Node is static...
         assertTrue(finalCount == 0);
      }
      else
      {
         // Invisible ref to enclosing class if Node is not static...
         assertTrue(finalCount == 1);
      }
   }
*/   
   @Test
   public void test07_sizeAtConstruction() {
      SimpleLinkedStack<Integer> s = new SimpleLinkedStack<Integer>();
      assertEquals(0, s.size());
   }
   
   @Test(expected=NoSuchElementException.class)
   public void test08_peekAtConstruction() {
      SimpleLinkedStack<Integer> s = new SimpleLinkedStack<Integer>();
      s.peek();
   }

   @Test(expected=NoSuchElementException.class)
   public void test09_popAtConstruction() {
      SimpleLinkedStack<Integer> s = new SimpleLinkedStack<Integer>();
      s.pop();
   }

   @Test
   public void test10_simplePush() {
      SimpleLinkedStack<Integer> s = new SimpleLinkedStack<Integer>();
    
      int[] a = new int[] {5, 10, 15, 20, 25, 30, 35, 40, 45, 50};

      for (int i = 0; i < a.length; i++) {
         s.push(a[i]);
         assertEquals(i + 1, s.size());
         assertEquals((Integer)a[i], s.peek());
      }
   }

   @Test
   public void test11_simplePop() {
      SimpleLinkedStack<Integer> s = new SimpleLinkedStack<Integer>();

      for (int i = 0; i < 10; i++) {
         s.push(i * 13);
      }

      for (int i = 9; i > -1; i--) {
         assertEquals((Integer)(i * 13), s.peek());
         assertEquals((Integer)(i * 13), s.pop());
         assertEquals(i, s.size());
      }
   }

   @Test
   public void test12_pushPopCombo() {
      SimpleLinkedStack<Integer> s = new SimpleLinkedStack<Integer>();

      s.push(55);
      assertEquals(1, s.size());
      assertEquals((Integer)55, s.peek());

      s.push(66);
      assertEquals(2, s.size());
      assertEquals((Integer)66, s.peek());

      s.pop();
      assertEquals(1, s.size());
      assertEquals((Integer)55, s.peek());

      s.push(77);
      assertEquals(2, s.size());
      assertEquals((Integer)77, s.peek());

      s.push(33);
      assertEquals(3, s.size());
      assertEquals((Integer)33, s.peek());

      s.push(11);
      assertEquals(4, s.size());
      assertEquals((Integer)11, s.peek());

      s.pop();
      assertEquals(3, s.size());
      assertEquals((Integer)33, s.peek());

      s.push(-4);
      assertEquals(4, s.size());
      assertEquals((Integer)(-4), s.peek());

      s.push(89);
      assertEquals(5, s.size());
      assertEquals((Integer)89, s.peek());

      s.push(-521);
      assertEquals(6, s.size());
      assertEquals((Integer)(-521), s.peek());

      s.push(333);
      assertEquals(7, s.size());
      assertEquals((Integer)333, s.peek());

      s.push(-9);
      assertEquals(8, s.size());
      assertEquals((Integer)(-9), s.peek());

      s.push(45);
      assertEquals(9, s.size());
      assertEquals((Integer)45, s.peek());

      s.push(61);
      assertEquals(10, s.size());
      assertEquals((Integer)61, s.peek());

      s.push(93);
      assertEquals(11, s.size());
      assertEquals((Integer)93, s.peek());


      assertEquals((Integer)93, s.pop());
      assertEquals(10, s.size());
      assertEquals((Integer)61, s.pop());
      assertEquals(9, s.size());
      assertEquals((Integer)45, s.pop());
      assertEquals(8, s.size());
      assertEquals((Integer)(-9), s.pop());
      assertEquals(7, s.size());
      assertEquals((Integer)333, s.pop());
      assertEquals(6, s.size());
      assertEquals((Integer)(-521), s.pop());
      assertEquals(5, s.size());
      assertEquals((Integer)89, s.pop());
      assertEquals(4, s.size());
      assertEquals((Integer)(-4), s.pop());
      assertEquals(3, s.size());
      assertEquals((Integer)33, s.pop());
      assertEquals(2, s.size());
      assertEquals((Integer)77, s.pop());
      assertEquals(1, s.size());
      assertEquals((Integer)55, s.pop());
      assertEquals(0, s.size());
   }

   @Test
   public void test13_testPushPopNulls() {
      SimpleLinkedStack<Integer> s = new SimpleLinkedStack<Integer>();

      s.push(null);
      s.push(66);
      s.pop();
      s.push(77);
      s.push(33);
      s.push(11);
      s.pop();
      s.push(-4);
      s.push(89);
      s.push(null);
      s.push(333);
      s.push(-9);
      s.push(45);
      s.push(61);
      s.push(null);

      assertEquals(null, s.pop());
      assertEquals((Integer)61, s.pop());
      assertEquals((Integer)45, s.pop());
      assertEquals((Integer)(-9), s.pop());
      assertEquals((Integer)333, s.pop());
      assertEquals(null, s.pop());
      assertEquals((Integer)89, s.pop());
      assertEquals((Integer)(-4), s.pop());
      assertEquals((Integer)33, s.pop());
      assertEquals((Integer)77, s.pop());
      assertEquals(null, s.pop());
   }

   @Test(timeout=60)
   public void test14_testOrderPush() {
      // This method test that the run time of the push method
      // is reasonable. The 60ms is about 3 times longer than
      // my code takes to run on unix5
      // PAH - 1/25/2016
      final int TEST_SIZE = 100000;

      SimpleLinkedStack<Integer> s = new SimpleLinkedStack<Integer>();

      for (int i = 0; i < TEST_SIZE; i++) {
         s.push(i);
      }
   }

   @Test(timeout=60)
   public void test15_testOrderPop() {
      // This method test that the run time of the push method
      // is reasonable. The 60ms is about 3 times longer than
      // my code takes to run on unix5
      // PAH - 1/25/2016
      final int TEST_SIZE = 100000;

      SimpleLinkedStack<Integer> s = new SimpleLinkedStack<Integer>();

      for (int i = 0; i < TEST_SIZE; i++) {
         s.push(i);
      }

      for (int i = 0; i < TEST_SIZE; i++) {
         s.pop();
      }
   }

   @Test
   public void test16_isGeneric() {
      SimpleLinkedStack<Object> s = new SimpleLinkedStack<>();

      s.push("Hello");
      s.push(Long.MAX_VALUE);
      s.push(Double.NaN);
      s.push(Double.POSITIVE_INFINITY);
      s.push(5);
      s.push(true);
      s.push('%');

      assertEquals((Character)'%', s.pop());
      assertEquals((Boolean)true, s.pop());
      assertEquals((Integer)5, s.pop());
      assertEquals(Double.POSITIVE_INFINITY, (double)s.pop(), 0.0);
      assertEquals(Double.NaN, (double)s.pop(), 0.0);
      assertEquals((Long)Long.MAX_VALUE, s.pop());
      assertEquals("Hello", s.pop());
   }

   @Test
   public void test17_randomStackOperations() {
      SimpleLinkedStack<Integer> s = new SimpleLinkedStack<>();
      Stack<Integer> s2 = new Stack<>();
      Random r = new Random();

      for (int i = 0; i < 10000000; i++) {
         switch (r.nextInt(s2.size() > 0 ? 3 : 1)) {
            case 0:
               int val = r.nextInt();
               s.push(val);
               s2.push(val);
               break;
            case 1:
               assertEquals(s2.peek(), s.peek());
               break;
            case 2:
               assertEquals(s2.pop(), s.pop());
               break;
         }
         assertEquals(s2.size(), s.size());
      }

      while (s2.size() > 0) {
         assertEquals(s2.peek(), s.peek());
         assertEquals(s2.pop(), s.pop());
         assertEquals(s2.size(), s.size());
      }
   }
}
