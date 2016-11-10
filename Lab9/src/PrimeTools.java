
/**
 *
 * @author Lucas Robertson
 * @version Lab 9
 */
public class PrimeTools {

    /**
     *
     * @param value
     * @return
     */
    public static boolean isPrime(int value) {
        int i;
        for (i = 2; i <= value / 2; i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int nextPrime(int value) {
        while (true) {
            if (isPrime(value)) {
                return value;
            }
            value++;
        }
    }
}
