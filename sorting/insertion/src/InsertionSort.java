import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class InsertionSort {

    public static void main(String[] args) {
        ///////////////////////////////////////////
       /* Random rand = new Random();
        int[] numbers = new int[10000000];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100000000);
        }*/
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Array Size : ");
        int arraySize = sc.nextInt();
        int[] elementsInArray = new int[arraySize];

        long startTime = System.currentTimeMillis();
        //int[] elementsInArray = {3, 5, 1, 2, 9};
        Random rnd = new Random();

        for (int i = 0; i < arraySize; i++) {
            elementsInArray[i] = rnd.nextInt(100);
            //System.out.println("The Random Number is " + elementsInArray[i]);
        }
        ////////////////////////////////////////////

        printArray("Before: \n",elementsInArray);

        insertionSort(elementsInArray);


        printArray("After: \n",elementsInArray);
        long endTime = System.currentTimeMillis();
        double timeElapsed = endTime - startTime;
        /* … The code being measured ends … */
        System.out.println("\nExecution time in seconds: " + timeElapsed / 1000);

    }

    private static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {// การสร้างลูป for ที่จะวนลูปผ่านอาเรย์ array ตั้งแต่ดัชนีที่ 1 ถึงดัชนีสุดท้ายของอาเรย์ (length - 1) โดย i เริ่มที่ 1 เพราะสมมติว่าสมาชิกดัชนีแรก (ดัชนี 0) ถือเป็นส่วนที่เรียงลำดับแล้วและไม่ต้องเปรียบเทียบ
            int currentValue = array[i];//การรับค่าของสมาชิกที่อยู่ที่ดัชนี i และเก็บไว้ในตัวแปร currentValue

            int j = i - 1;//การสร้างตัวแปร j เพื่อใช้ในการค้นหาสมาชิกที่น้อยกว่า currentValue ในส่วนที่ยังไม่เรียงลำดับของอาเรย์
            while (j >= 0 && array[j] > currentValue) {//เข้าสู่ลูป while โดยที่เงื่อนไขคือ j ต้องมากกว่าหรือเท่ากับ 0 และค่าใน inputArray[j] ต้องมากกว่า currentValue
                array[j + 1] = array[j];//การสลับค่าของ inputArray[j] กับ inputArray[j + 1] เพื่อเคลื่อนย้ายค่าที่มากกว่า currentValue ไปด้านขวา
                j--;//การลดค่า j ลงทีละหนึ่งหน่วยเพื่อค้นหาตำแหน่งที่ถูกต้องให้ currentValue ไปตั้งแต่ตำแหน่งปัจจุบันของ i ย้อนไปทางซ้าย
            }
            array[j + 1] = currentValue;//การกำหนดค่า currentValue ให้กับ inputArray[j + 1] เพื่อเข้าใจว่า currentValue ถูกเสร็จสิ้นการเรียงลำดับที่ตำแหน่งที่ถูกต้องในอาเรย์
        }//โค้ดนี้จะทำซ้ำขั้นตอนเหล่านี้เพื่อเรียงลำดับสมาชิกทั้งหมดในอาเรย์ inputArray จากน้อยไปหามาก ซึ่งจะนำไปสู่อาเรย์ที่เรียงลำดับอย่างถูกต้องที่สุดเมื่อลูปเสร็จสิ้นการทำงาน
    }

    private static void printArray(String a,int[] array) {
        System.out.println(a+Arrays.toString(array));
    }
}