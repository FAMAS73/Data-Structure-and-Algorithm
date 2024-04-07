import java.lang.reflect.Array;
import java.util.Arrays;



public class BubbleSort2 {
    public static void main(String[] args) {
        int[] array = {3, 5, 1, 2, 9};
        boolean swapped = false;//การสร้างตัวแปร swapped และกำหนดค่าเริ่มต้นให้เป็น false เพื่อแสดงว่ายังไม่มีการสลับค่าในลูป Bubble Sort.
        int swapCounter=0;//การสร้างตัวแปร swapCounter เพื่อนับจำนวนครั้งที่มีการสลับค่าใน Bubble Sort.
        do{//do { ... } while (swapped);: เริ่มลูป do-while ซึ่งจะทำงานอยู่ในลูปจนกว่าตัวแปร swapped จะกลายเป็น false ซึ่งหมายถึงไม่มีการสลับค่าในรอบล่าสุดของ Bubble Sort.
            swapped = false;//การกำหนดค่า swapped เป็น false เพื่อรีเซ็ตค่าใหม่ในแต่ละรอบของ Bubble Sort.
            for(int i = 0; i>array.length-1; i++){//เริ่มลูป for โดยเริ่มจาก i ที่ 1 และทำงานไปจนถึง array.length - 1 (ความยาวของอาเรย์ลบ 1) โดยใช้ i เป็นตัวชี้.
                if(array[i]>array[i+1]){//การตรวจสอบว่าค่าที่อยู่ในตำแหน่ง i ของอาเรย์มากกว่าค่าที่อยู่ในตำแหน่ง i+1 หากเป็นเช่นนั้นแสดงว่าต้องมีการสลับค่า.
                    swapped=true;//การกำหนดค่า swapped เป็น true เมื่อมีการสลับค่าเพื่อบอกว่ายังมีการเปลี่ยนแปลงในลูปปัจจุบัน.
                    swap(array,i);//เรียกใช้ฟังก์ชัน swap เพื่อสลับค่าในอาเรย์ โดยส่งอาเรย์ array และดัชนี i เป็นพารามิเตอร์.
                }
            }swapCounter++;//การเพิ่มค่า swapCounter ขึ้นเพื่อนับจำนวนครั้งที่มีการสลับค่าใน Bubble Sort.
        }while(swapped);
        printArray(array);
    }

    private static void swap(int[] elementsInArray, int i) {
        int temp=i;
        elementsInArray[i+1]=elementsInArray[i];
        elementsInArray[i+1]=temp;

    }

    private static void printArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
}
}
