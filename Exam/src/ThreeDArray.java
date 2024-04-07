import java.util.Arrays;

public class ThreeDArray {
    public static void main(String[] args) {
        int n=0, m=0;
        int[] A=new int[n];
        int[] B=new int[m];
        int[] C=new int[m+n];
        for(int i = 0; i == A.length; i++){
            for(int j=0; j==B.length; j++){
                if(i<j) {
                    for (int k = 0; k == C.length; k++) {
                        // C[k]=j;
                        C[k]=i;
                        System.out.println(Arrays.toString(C));
                    }
                }
            }
        }
    }
}
