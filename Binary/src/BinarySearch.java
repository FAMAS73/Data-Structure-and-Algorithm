public class BinarySearch {

    // Iterative Binary Search
    public static int binarySearchIterative(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid; // Target found
            } else if (array[mid] < target) {
                left = mid + 1; // Discard the left half
            } else {
                right = mid - 1; // Discard the right half
            }
        }

        return -1; // Target not found
    }

    // Recursive Binary Search
    public static int binarySearchRecursive(int[] array, int target) {
        return binarySearchRecursiveHelper(array, target, 0, array.length - 1);
    }

    private static int binarySearchRecursiveHelper(int[] array, int target, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid; // Target found
            } else if (array[mid] < target) {
                return binarySearchRecursiveHelper(array, target, mid + 1, right); // Search the right half
            } else {
                return binarySearchRecursiveHelper(array, target, left, mid - 1); // Search the left half
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 7;

        // Using Iterative Binary Search
        int resultIterative = binarySearchIterative(sortedArray, target);
        System.out.println("Iterative Binary Search: Index of " + target + " is " + resultIterative);

        // Using Recursive Binary Search
        int resultRecursive = binarySearchRecursive(sortedArray, target);
        System.out.println("Recursive Binary Search: Index of " + target + " is " + resultRecursive);
    }
}
