import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class SelectionSortAlgorithm {
    public static void main(String[] args) {
        //int[] elementsInArray = {3, 5, 1, 2, 9};
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Array Size : ");
        int arraySize = sc.nextInt();
        int[] elementsInArray = new int[arraySize];
        long startTime = System.currentTimeMillis();
        Random rnd = new Random();

        for (int i = 0; i < arraySize; i++) {
            elementsInArray[i] = rnd.nextInt(100);
            //System.out.println("The Random Number is " + elementsInArray[i]);
        }
        System.out.println("Before: \n"+Arrays.toString(elementsInArray));
        selectionSort(elementsInArray);//send the array to selectionSort()>>>swap()
        System.out.println("After: \n"+Arrays.toString(elementsInArray));
        long endTime = System.currentTimeMillis();
        double timeElapsed = endTime - startTime;
        /* … The code being measured ends … */
        System.out.println("Execution time in seconds: " + timeElapsed / 1000);

    }
    private static void selectionSort(int[] arrayFromMain) {
        int length = arrayFromMain.length;//การสร้างตัวแปร length เพื่อเก็บความยาวของอาเรย์ arrayFromMain.

        for(int i=0; i<length - 1; i++){//เริ่มลูป for โดยใช้ตัวแปร i เป็นตัวชี้ เริ่มต้นที่ 0 และวนไปจนถึง length - 1 โดยลูปนี้จะเริ่มจากตำแหน่งแรกและเลื่อนไปทีละตำแหน่งในอาเรย์ arrayFromMain.
            int min = arrayFromMain[i];//การกำหนดค่าในตัวแปร min ให้มีค่าเท่ากับค่าใน arrayFromMain ที่ดัชนี i เริ่มต้น.
            int indexOfMin = i;//การกำหนดค่าในตัวแปร indexOfMin ให้เป็นค่าของ i เริ่มต้น.
            for(int j=i+1; j<length; j++){//เริ่มลูป for อีกครั้งในการค้นหาค่าที่น้อยที่สุด โดยใช้ตัวแปร j เป็นตัวชี้ เริ่มต้นที่ตำแหน่งที่ i+1 และวนไปจนถึง length - 1.
                if(arrayFromMain[j]<min) {//การเปรียบเทียบค่าใน arrayFromMain ที่ดัชนี j กับค่า min ที่เป็นค่าที่น้อยที่สุดที่เจอในรอบที่แล้ว.
                    min = arrayFromMain[j];//หากค่าใน arrayFromMain[j] น้อยกว่า min จะกำหนดค่าให้ min เป็นค่าใน arrayFromMain[j] นั้น.
                    indexOfMin = j;//การกำหนดค่าใน indexOfMin ให้เป็นค่าของ j เพื่อบันทึกดัชนีของค่าที่น้อยที่สุด.
                }
            }
            swapper(arrayFromMain, i, indexOfMin);//เรียกใช้ฟังก์ชัน swapper เพื่อสลับค่าใน arrayFromMain ระหว่างตำแหน่ง i และ indexOfMin เพื่อนำค่าที่น้อยที่สุดมาวางในตำแหน่งปัจจุบันของลูป.
        }//Selection Sort ซึ่งเป็นวิธีการเรียงลำดับที่ค่อนข้างง่ายและมีประสิทธิภาพสำหรับอาเรย์ขนาดเล็ก.
    }
    private static void swapper(int[] elementsToSwap, int a, int b) {
        int temp = elementsToSwap[a];
        elementsToSwap[a] = elementsToSwap[b];
        elementsToSwap[b] = temp;
    }
}
