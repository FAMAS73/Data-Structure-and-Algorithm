import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Array's size: ");
        int arraySize = 0;
        if(scanner.hasNextInt()){arraySize = scanner.nextInt();}
        int[] array = new int[arraySize];
        System.out.println("Array size is "+arraySize);
        System.out.println("Enter maximum number for random: ");
        int max = 0;max = scanner.nextInt();
        System.out.println("Enter minimum number for random: ");
        int min = 0;min = scanner.nextInt();
        Random random = new Random();
        int randomInt = new Random().nextInt(max-min)+min;
        for(int i=0;i<arraySize;i++){array[i]=randomInt;System.out.println(array[i]);}
    }
}
