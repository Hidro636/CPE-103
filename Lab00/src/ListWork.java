
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A class that implements some basic list functionality and helps in testing it
 *
 * @author Lucas Robertson
 * @version Lab00
 */
public class ListWork {

    static final int SIZE = 10;

    public static void main(String[] args) {
        //Initialize
        Scanner input = new Scanner(System.in);
        Integer[] values = new Integer[SIZE];

        //Prompt user for integers and populate values array
        int i = 0;
        while (i < SIZE) {
            try {
                System.out.print("Enter an integer (" + (i + 1) + ") : ");
                values[i] = input.nextInt();
                i++;
            } catch (InputMismatchException ime) {
                System.out.println("Invalid input!");
                input.nextLine();
            }
        }
        input.nextLine();

        //Prompt the user to seach, and do so if they specify
        while (true) {
            System.out.print("Type \"y\" to search, or anything else to finish: ");
            if (input.nextLine().toLowerCase().equals("y")) {
                System.out.print("Enter a search target: ");
                try {
                    int target = input.nextInt();
                    if (search(values, target)) {
                        System.out.println("The array contained the specified value!");
                    } else {
                        System.out.println("The array didn't contain that value, sorry :(");
                    }

                    input.nextLine();
                } catch (InputMismatchException ime) {
                    System.out.println("Input was not an integer!");
                    input.nextLine();
                }
            } else {
                break;
            }
        }

        print(values);

        //close out streams/scanners
        input.close();

    }

    /**
     * Function that searches through a specified array to see if it contains a
     * certain value
     *
     * @param arr The array to search through
     * @param target The value to search for
     * @return A boolean value, true if the given array contains the specified
     * value, false otherwise
     */
    public static <T> boolean search(T[] arr, T target) {
        if (arr == null || arr.length == 0) {
            
            return false;
        }

        for (T item : arr) {
            try {
                if (target.equals(item)) {
                    return true;
                }
            } catch (NullPointerException npe) {
                if(item == null) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * A function that prints the values (using toString()) of all of the
     * members of a given array
     *
     * @param arr The array through which to iterate and print values
     */
    public static <T> void print(T[] arr) {
        for (T item : arr) {
            System.out.println(item.toString());
        }
    }

}
