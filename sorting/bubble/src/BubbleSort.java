import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class BubbleSort {
    public static void main(String[] args) {
//put random values into an empty array of 10
       /* Random rand = new Random();
        int[] elementsInArray = new int[10];

        for (int i = 0; i < elementsInArray.length; i++) {
            elementsInArray[i] = rand.nextInt(10);
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
    //print the array


        printArray("Before: \n",elementsInArray);
        //Sorting algorithm here

        bubbleSort(elementsInArray);



        printArray("After: \n",elementsInArray);
        long endTime = System.currentTimeMillis();
        double timeElapsed = endTime - startTime;
        /* … The code being measured ends … */
        System.out.println("\n\nExecution time in seconds: " + timeElapsed / 1000);
    }
    private static void bubbleSort(int[] elementsInArray) {
        boolean swappedSomething = true;//การสร้างตัวแปร swappedSomething และกำหนดค่าเริ่มต้นให้เป็น true เพื่อให้เริ่มลูป Bubble Sort ทำงาน
        //swap if the next value is less than the value before
        //สลับกันถ้าค่าแรกมากกว่าค่าต่อไปจริงเรื่อยๆ
        while (swappedSomething) {//เริ่มลูป while โดยที่เงื่อนไขคือ swappedSomething ถ้า swappedSomething เป็น false แสดงว่าไม่มีการสลับค่าในรอบล่าสุดและจบการทำงานของ Bubble Sort
            swappedSomething = false;//การกำหนดค่า swappedSomething เป็น false เพื่อรีเซ็ตค่าในแต่ละรอบของ Bubble Sort.
            //ให้ i เปลี่ยนค่า indexไปเรื่อยๆตามลำดับจนถึงตัวก่อนสุดท้าย(indexที่ 0-ตัวก่อนสุดท้าย )
            for (int i = 0; i < elementsInArray.length - 1 ; i++) {//เริ่มลูป for โดยใช้ตัวแปร i เป็นตัวชี้ เริ่มต้นที่ 0 และวนไปจนถึง elementsInArray.length - 1 (ความยาวของอาเรย์ลบ 1)
                //ถ้าจริงให้ทำการสลับตำแหน่งกัน
                if (elementsInArray[i] > elementsInArray[i + 1]) {//ตรวจสอบว่าค่าที่อยู่ในตำแหน่ง i ของอาเรย์มากกว่าค่าที่อยู่ในตำแหน่ง i + 1 หากเป็นเช่นนั้นแสดงว่าต้องมีการสลับค่า.
                    swappedSomething = true;//การกำหนดค่า swappedSomething เป็น true เมื่อมีการสลับค่าเพื่อบอกว่ายังมีการเปลี่ยนแปลงในลูปปัจจุบัน.
                    swapper(i,elementsInArray);//การกำหนดค่า swappedSomething เป็น true เมื่อมีการสลับค่าเพื่อบอกว่ายังมีการเปลี่ยนแปลงในลูปปัจจุบัน.
                }
            }
        }
    }

    private static void swapper(int i, int[] elementsToSwap) {
        int temp = elementsToSwap[i];//การสร้างตัวแปร temp และกำหนดค่าให้เป็นค่าที่ตั้งอยู่ใน elementsToSwap ที่ดัชนี i นั้นคือการบันทึกค่าที่จะถูกสลับไว้ในตัวแปรชั่วคราว temp.
        elementsToSwap[i] = elementsToSwap[i + 1];//การกำหนดค่าใน elementsToSwap ที่ดัชนี i ให้มีค่าเท่ากับค่าใน elementsToSwap ที่ดัชนี i + 1 ซึ่งคือการสลับค่าระหว่างสองตำแหน่ง.
        elementsToSwap[i + 1] = temp;//การกำหนดค่าใน elementsToSwap ที่ดัชนี i + 1 ให้มีค่าเท่ากับค่าในตัวแปรชั่วคราว temp ซึ่งเป็นการสลับค่าที่เป็นค่าเดิมของ elementsToSwap[i] ไปยัง elementsToSwap[i + 1] เพื่อสลับค่าในอาเรย์.v
    }

    private static void printArray(String a ,int[] elementsInArray) {
        System.out.println(a+Arrays.toString(elementsInArray));
    }
}