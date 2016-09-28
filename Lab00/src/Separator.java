
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

        int i = 0;
        int f = 0;
        //Get input
        while (input.hasNext() && i < MAX && f < MAX) {
            if (input.hasNextInt()) {
                integers.add(input.nextInt());
                i++;
                System.out.println("Was an int (" + i + ")");
            } else if (input.hasNextFloat()) {
                floats.add(input.nextFloat());
                f++;
                System.out.println("Was a float (" + f + ")");
            } else {

            }

            input.nextLine();
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
