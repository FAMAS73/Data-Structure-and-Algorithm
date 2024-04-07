import java.util.Arrays;

public class HashingSearch {
    public static void main(String[] args) {
        int[] array = {5,12,6,20,30,25,26};//การสร้างอาเรย์ array และกำหนดค่าของอาเรย์.
        int h=0, key=0;//การสร้างตัวแปร h และ key เพื่อใช้ในการคำนวณและเก็บค่า.
        //h(key) = key%array.length
        key=5;//กำหนดค่า key เป็น 5 เพื่อทำการค้นหาค่า 5 ในอาเรย์ array.
        h=key%array.length;//คำนวณค่าแฮช h โดยใช้สูตร h(key) = key % array.length เพื่อหาตำแหน่งที่คาดว่าค่า key จะอยู่ในอาเรย์ array.
        array[h]=key;//การกำหนดค่า key ลงในตำแหน่งที่คำนวณได้จากการแฮช h นั่นคือในอาเรย์ array ในตำแหน่ง h.
        //bigO=
        //t=time(unit)
        //T(n)= t = 3
        //BigO = O(c) ...//c=constant
        System.out.println(Arrays.toString(array));
    }
}
