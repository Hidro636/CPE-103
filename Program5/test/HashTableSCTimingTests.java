
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Timing tests for HashTableSC
 *
 * @author Lucas Robertson
 * @version Program 5
 */
public class HashTableSCTimingTests {

    public HashTableSCTimingTests() {
    }

    private String randomString(int length) {
        Random r = new Random(9555);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append((char) (r.nextInt(26) + 97));
        }

        return sb.toString();
    }

    @Test
    public void testAddTime() {
        System.out.println("Timing add()...");
        HashTableSC instance;
        long start, end;
        int[] sizes = new int[]{5000, 10000, 50000, 100000, 1000000, 5000000, 100000000};

        for (int i : sizes) {
            instance = new HashTableSC(i);
            start = System.nanoTime();
            for (int j = 0; j < sizes.length / 2; j++) {
                instance.add(j);
            }
            end = System.nanoTime();
            System.out.println("\t" + i + " elements: " + (end - start) + "ns");
        }
    }
    
    
}
