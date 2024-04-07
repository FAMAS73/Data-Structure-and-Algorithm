import java.util.Arrays;

public class TArr {
    int[] arr={0,0,0,0,0};
    TArr (){}
    public void add(int n){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                arr[i]=n;
                break;
            }
            if(i==arr.length-1){
                System.out.println("array full!!");
            }
        }
    }
    public void print(){
        for(int i=0;i<arr.length;i++){
            System.out.println("arr["+i+"]="+arr[i]);
        }
        System.out.println(Arrays.toString(arr));
    }
}
