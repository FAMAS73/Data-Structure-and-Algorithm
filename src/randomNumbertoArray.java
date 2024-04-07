import java.util.Random;
import java.util.Scanner;

public class randomNumbertoArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Array Size : ");
        int arraySize = sc.nextInt();
        int[] array = new int[arraySize];
        /* … The code being measured starts … */
        long startTime = System.currentTimeMillis();
        Random rnd = new Random();

        for (int i = 0; i < arraySize; i++) {
            array[i] = rnd.nextInt(100);
            System.out.println("The Random Number is " + array[i]);
        }

        long endTime = System.currentTimeMillis();

        double timeElapsed = endTime - startTime;
        /* … The code being measured ends … */
        System.out.println("Execution time in seconds: " + timeElapsed / 1000);



    }
}
