


public class recursiveMethod {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
    private static int factorial(int N) {
        if(N==1){
            return 1;
        }else{
            return N*factorial(N-1);
        }

    }


}