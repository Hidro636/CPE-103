
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Lucas Robertson
 * @version Lab00
 */
public class Separator {

    static final int MAX = 6;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<Float> floats = new ArrayList<>();

        //Get input
        while (input.hasNext() && integers.size() < MAX && floats.size() < MAX) {
            if (input.hasNextInt()) {
                integers.add(input.nextInt());
                i++;
                System.out.println("Was an int (" + i + ")");
            } else if (input.hasNextFloat()) {
                floats.add(input.nextFloat());
                f++;
                System.out.println("Was a float (" + f + ")");
            } else {
                break;
            }

            input.next();
        }

        //print
        System.out.print("Integers: ");
        for (Integer value : integers) {
            System.out.print(value + " ");
        }

        System.out.print("\nFloats: ");
        for (Float value : floats) {
            System.out.print(value + " ");
        }

    }
}
