package homeWork;
class Student {
    private String studentCode;
    private String name;
    private String surname;
    private double grade;
    private boolean isDeleted; // เพิ่มตัวแปรในการระบุสถานะการลบ

    public Student(String studentCode, String name, String surname, double grade) {
        this.studentCode = studentCode;
        this.name = name;
        this.surname = surname;
        this.grade = grade;
        this.isDeleted = false; // เริ่มต้นเป็น false (ไม่ถูกลบ)
    }

    // เพิ่มเมธอดเพื่อรับค่าสถานะการลบ
    public boolean isDeleted() {
        return isDeleted;
    }

    // เพิ่มเมธอดเพื่อตั้งค่าสถานะการลบ
    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public String toString() {
        if (isDeleted) {
            return "Student [studentCode=" + studentCode + ", name=" + name + ", surname=" + surname + ", grade=" + grade + ", Status=Deleted]";
        } else {
            return "Student [studentCode=" + studentCode + ", name=" + name + ", surname=" + surname + ", grade=" + grade + ", Status=Active]";
        }
    }

    public String getStudentCode() {
        return studentCode;
    }
}
