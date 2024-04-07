public class QuickSort {
    // Function to perform QuickSort
    public static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            // Find the partition index such that elements smaller than pivot are on the left,
            // and elements greater than pivot are on the right
            int partitionIndex = partition(arr, low, high);

            // Recursively sort the sub-arrays
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    // Function to partition the array and return the partition index
    public static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        // Traverse the array and rearrange elements such that elements less than pivot are on the left
        // and elements greater than pivot are on the right
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // Swap the pivot element with the element at index (i+1)
        swap(arr, i + 1, high);

        // Return the partition index
        return i + 1;
    }

    // Function to swap two elements in an array
    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Utility function to print an array
    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Driver method
    public static void main(String args[]) {
        int arr[] = {12, 4, 5, 6, 7, 3, 1, 15};

        System.out.println("Array before sorting");
        printArray(arr);

        // Performing QuickSort
        quickSort(arr, 0, arr.length - 1);

        System.out.println("Array after sorting");
        printArray(arr);

    }
}
//The average-case time complexity of QuickSort is O(n log n), making it more efficient than some other sorting algorithms. However, in the worst case (when the pivot selection is poor), the time complexity can degrade to O(n^2). The space complexity is O(log n) due to the recursive nature of the algorithm.