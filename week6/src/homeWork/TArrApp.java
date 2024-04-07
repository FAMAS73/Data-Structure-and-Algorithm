package homeWork;

public class TArrApp {
    public static void main(String[] args) {
        TArr a1=new TArr(5);
        a1.add(6508185,"Pittawat","Rithded",4.0);
        a1.add(6555556,"John","Wick",3.99);
        a1.print();
        a1.deleteByValue(6508185);
        a1.print();


    }
}
