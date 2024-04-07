package homeWork;

import java.util.LinkedList;
import java.util.List;

public class StudentListApp {
    public static void main(String[] args) {
        // สร้างแอเรย์เพื่อเก็บข้อมูลนักเรียน
        Student[] studentArray = new Student[2];
        studentArray[0] = new Student("6508185", "Pittawat", "Rithded", 99.9);
        studentArray[1] = new Student("6509999", "John", "Wick", 66.6);
        // ลบนักเรียนด้วยรหัสนักเรียน
        String studentCodeToDelete = "6509999"; // รหัสนักเรียนที่ต้องการลบ
        int indexToDelete = -1;
        for (int i = 0; i < studentArray.length; i++) {
            if (studentArray[i] != null && studentArray[i].getStudentCode().equals(studentCodeToDelete)) {
                indexToDelete = i;
                break; // หากพบนักเรียนที่ต้องการลบให้หยุดการวนลูป
            }
        }
        if (indexToDelete != -1) {
            // ย้ายข้อมูลของนักเรียนที่ต้องการลบไปยังตำแหน่งสุดท้ายของแอเรย์
            studentArray[indexToDelete] = studentArray[studentArray.length - 1];
            // ยกเลิกตำแหน่งสุดท้าย
            studentArray[studentArray.length - 1] = null;
            // แสดงข้อมูลหลังลบ
            System.out.println("\nStudent Array After Deletion:");
            for (Student student : studentArray) {
                if (student != null) {
                    System.out.println(student);
                }
            }
        } else {
            System.out.println("\nStudent not found. Cannot delete.");
        }
        // สร้างลิงค์ลิสต์เพื่อเก็บข้อมูลนักเรียน
        List<Student> studentList = new LinkedList<>();
        studentList.add(new Student("6508185", "Pittawat", "Rithded", 99.9));
        studentList.add(new Student("6509999", "John", "Wick", 66.6));
        deleteStudent(studentList,"6508185");
        // แสดงข้อมูลจากลิงค์ลิสต์
        System.out.println("\nStudent List:");
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
    public static void deleteStudent(List<Student> studentList, String studentCodeToDelete) {
        for (Student student : studentList) {
            if (student.getStudentCode().equals(studentCodeToDelete)) {
                studentList.remove(student);
                break; // หยุดหลังการลบ
            }
        }
    }
}
