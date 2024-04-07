import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array={1,2,4,6,8,10,14,16,18,30};//การสร้างอาเรย์ array และกำหนดค่าของอาเรย์ให้เรียงลำดับแล้ว.
        int left=0, right=array.length-1, middle=0;//การสร้างตัวแปร left และ right เพื่อระบุช่วงของอาเรย์ที่จะทำการค้นหา โดย left คือดัชนีเริ่มต้น (0) และ right คือดัชนีสุดท้ายของอาเรย์ (array.length-1) โดย middle จะถูกใช้ในการหาตำแหน่งกลางในช่วงนี้.
        int key=16;//การกำหนดค่า key ที่ต้องการค้นหาในอาเรย์.
        while(left<=right){//เริ่มลูป while โดยที่เงื่อนไขคือ left ต้องน้อยกว่าหรือเท่ากับ right เพื่อให้การค้นหาทำงานไปเรื่อยๆ จนกว่าจะหายไปทั้งหมดในช่วงที่กำหนด.
            middle = (left+right)/2;//คำนวณค่า middle โดยหาค่ากลางของช่วงที่กำหนด นั่นคือ (left + right) / 2.
            if(array[middle]==key){//ตรวจสอบว่าค่าที่อยู่ใน array ที่ดัชนี middle เท่ากับค่า key หากเป็นเช่นนั้นค่า key ถูกพบ และโปรแกรมจะแสดงตำแหน่ง middle.
                System.out.print("Middle = "+middle);break;
            }
            else if(key>array[middle]){//หากค่า key มากกว่าค่าใน array ที่ดัชนี middle แสดงว่าค่า key ต้องอยู่ในช่วงด้านขวาของ middle
                left=middle+1;//ดังนั้น left จะถูกปรับใหม่เป็น middle+1.
            }
            else if(key<array[middle]){//หากค่า key น้อยกว่าค่าใน array ที่ดัชนี middle แสดงว่าค่า key ต้องอยู่ในช่วงด้านซ้ายของ middle
                right =middle-1;//ดังนั้น right จะถูกปรับใหม่เป็น middle-1.
            }
        }//โค้ดนี้จะทำการค้นหาค่า key ในอาเรย์ array ที่เรียงลำดับแล้วโดยใช้วิธีการค้นหาแบบทวิภาค และจะหยุดเมื่อพบค่า key หรือช่วงที่ค้นหาย่อยกันมีความยาวเป็นศูนย์ หากพบค่า key โปรแกรมจะแสดงตำแหน่งที่พบในอาเรย์ มิฉะนั้นจะแสดงว่าค่า key ไม่อยู่ในอาเรย์.

        /*int arraySearch = Arrays.binarySearch(array,key);
        if(arraySearch>=0){
            System.out.println(arraySearch);
        }else{
            System.out.println("Not found");
        }*/
    }
}
