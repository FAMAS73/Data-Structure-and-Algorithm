public class HashingTechnique {
    public static void main(String[] args) {
        int[] array={12,45,67,89,34,23,78,56,90,54};
        int h=0, key=78;
        h=key%array.length;
        array[h]=key;
    }
}
