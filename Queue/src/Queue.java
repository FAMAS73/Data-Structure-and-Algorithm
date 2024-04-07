import java.util.Arrays;

public class Queue {//Queue ซึ่งเป็นโครงสร้างข้อมูลชนิดหนึ่งที่มีการปฏิบัติตามหลักการของ First-In-First-Out (FIFO) หรือ "คนแรกเข้ามา คนแรกออกไป" โดยใช้อาเรย์ a ในการเก็บข้อมูลในคิว (Queue)
    int f = -1;
    int r = -1;//การประกาศตัวแปร f และ r เพื่อเก็บดัชนีแรกและดัชนีสุดท้ายของคิว (Queue) โดยกำหนดค่าเริ่มต้นให้เป็น -1 เพื่อระบุว่าคิวว่าง.
    int[] a = new int[5];//การประกาศอาเรย์ a เพื่อเก็บข้อมูลในคิว โดยกำหนดขนาดอาเรย์ให้เท่ากับ 5 ในตอนแรก.

    Queue() {
    }

    void enqueue(int var1) {//เมทอด enqueue ที่ใช้ในการเพิ่มข้อมูล var1 เข้าคิว โดยเพิ่มดัชนี r และกำหนดค่าในอาเรย์ a ที่ดัชนี r ให้มีค่าเท่ากับ var1 และแสดงข้อมูลที่ถูกเพิ่ม.
        if (this.f < 0 && this.r < 0) {
             ++this.f;
            ++this.r;
        } else {
            ++this.r;
        }

        this.a[this.r] = var1;
        System.out.print("\n\tinsert queue : " + var1);
    }

    void dequeue() {
        System.out.print("\n\tdelete queue :" + this.a[this.f]);
        ++this.f;//เมทอด dequeue ที่ใช้ในการลบข้อมูลออกจากคิว โดยแสดงข้อมูลที่ถูกลบและเพิ่มค่าในดัชนี f เพื่อเคลื่อนไปยังข้อมูลถัดไปในคิว.
    }

    void printQueue() {
        for(int var1 = this.f; var1 <= this.r; ++var1) {
            System.out.println("\nprint queue : " + var1 + " \t = " + this.a[var1]);
        }
    }
    void printArray(){
        System.out.println(Arrays.toString(a));
    }
}//โค้ดนี้ใช้สร้างคลาส Queue ที่รองรับการเพิ่มข้อมูล (enqueue) การลบข้อมูล (dequeue) และการแสดงข้อมูลในคิว โดยใช้แบบ First-In-First-Out (FIFO) ซึ่งหมายถึงข้อมูลที่เพิ่มเข้าคิวก่อนหน้าจะถูกลบออกก่อนเมื่อใช้งานเมทอด dequeue โดยข้อมูลจะถูกเก็บในอาเรย์ a และค่าในตัวแปร f และ r จะถูกเพิ่มหรือลดเพื่อระบุตำแหน่งของข้อมูลในคิว.
