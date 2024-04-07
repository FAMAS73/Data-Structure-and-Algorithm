package homeWork;

import java.util.Arrays;

/*1.เขียนโปรแกรมสร้างแอเรย์ และลิงค์ลิสต์ เก็บข้อมูลออปเจคของนักเรียน โดย
        ข้อมูลนักเรียนประกอบด้วย  student_code, name, surname, grade
        2.ส่งรหัสโปรแกรม ผลรันเทสต์ โดยทดสอบเพิ่มลบข้อมูล
        3. อธิบายเปรียบเทียบทั้งสองวิธีโดยการอธิบายสรุปมาพอสังเขป*/
public class TArr {
    int[] intArr;
    String[] stringNameArr;
    String[] stringSurArr;
    double[] doublesArr;
    int size;
    public TArr(int size) {
        intArr = new int[size];
        stringNameArr = new String[size];
        stringSurArr = new String[size];
        doublesArr = new double[size];
        this.size = 0;

    }
    public void add(int n, String name,String surname, double grade){

        for (int i = 0; i < intArr.length; i++) {
            if (intArr[i] == 0) {
                intArr[i] = n;
                stringNameArr[i] = name;
                stringSurArr[i] = surname;
                doublesArr[i] = grade;
                break;
            }
        }
    }
    public void print(){

        System.out.println(Arrays.toString(intArr));
        System.out.println(Arrays.toString(stringNameArr));
        System.out.println(Arrays.toString(stringSurArr));
        System.out.println(Arrays.toString(doublesArr));

    }
    public void deleteByValue(int valueToDelete) {
        int indexToDelete = -1;

        // Find the index of the element with the specified valueToDelete
        for (int i = 0; i < size; i++) {
            if (intArr[i] == valueToDelete) {
                indexToDelete = i;
                break;
            }
        }

        if (indexToDelete != -1) {
            // Shift elements to the left to remove the element at the specified index
            for (int i = indexToDelete; i < size - 1; i++) {
                intArr[i] = intArr[i + 1];
                stringNameArr[i] = stringNameArr[i + 1];
                stringSurArr[i] = stringSurArr[i + 1];
                doublesArr[i] = doublesArr[i + 1];
            }

            // Clear the last element and decrease the size
            intArr[size - 1] = 0;
            stringNameArr[size - 1] = null;
            stringSurArr[size - 1] = null;
            doublesArr[size - 1] = 0.0;
            size--;
        } else {
            System.out.println("Element not found. Cannot delete.");
        }
    }
}
