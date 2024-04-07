import java.util.Arrays; import java.util.Random; import java.util.Scanner;
public class LinearSearch {
    public static void main(String[] args) {
        //5 statements
        Scanner sc = new Scanner(System.in);//1
        System.out.print("Enter Array Size : ");//2
        int arraySize = sc.nextInt();//3
        int[] array = new int[arraySize];//4
        ///////////////////////////////////////////////////////////////////////
        Random rnd = new Random();//5
        for (int i = 0; i < arraySize; i++) {
            array[i] = rnd.nextInt(100);
            //System.out.println("The Random Number is " + array[i]);
        }//
        System.out.println(Arrays.toString(array));
        ///////////////////////////////////////////////////////////////////////
        int key=0;
        System.out.print("Enter Search key : ");
        key=sc.nextInt();
        for(int i=0; i<array.length; i++){//เริ่มลูป for โดยใช้ตัวแปร i เป็นตัวชี้ เริ่มต้นที่ 0 และวนลูปไปจนถึงความยาวของอาเรย์ array โดยใช้ array.length เป็นเงื่อนไขในการวนลูป.
            if(key==array[i]){//ในแต่ละรอบของลูป for นี้ เปรียบเทียบค่า key กับค่าใน array ที่ดัชนี i.
                System.out.println("Found "+key+" at position "+i);
            }
        }//ลักษณะของอัลกอริทึม Linear Search คือการค้นหาค่าทีละตำแหน่งในอาเรย์ และหยุดเมื่อพบค่าที่ตรงกับ key หรือเมื่อค้นทุกตำแหน่งในอาเรย์แล้วแล้วไม่พบค่า key ที่คุณกำหนดไว้ การค้นหาแบบเส้นจะใช้เวลาเพิ่มขึ้นเมื่อขนาดของอาเรย์เพิ่มขึ้น แต่มีความง่ายและเข้าใจง่ายในการสร้าง.

        //n=arraySize
        //T(n)= 5+(2n)+3+(3n)
        //    = 8+5n
        //T(5)= 8+(5*5)
        //T(10)=8+(5*10)
        System.out.println(Arrays.toString(array));

    }
}
