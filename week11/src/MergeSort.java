public class MergeSort {
    // Function to perform MergeSort
    public static void mergeSort(int arr[], int left, int right) {
        if (left < right) {
            // Find the middle point of the array
            int middle = (left + right) / 2;

            // Recursively sort the first and second halves
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);

            // Merge the sorted halves
            merge(arr, left, middle, right);
        }
    }

    // Function to merge two sub-arrays of arr[]
    public static void merge(int arr[], int left, int middle, int right) {
        // Sizes of the two sub-arrays to be merged
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Create temporary arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[middle + 1 + j];

        // Merge the temporary arrays

        // Initial indices of first and second sub-arrays
        int i = 0, j = 0;

        // Initial index of merged sub-array array
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if there are any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if there are any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
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
        int arr[] = {12, 11, 13, 5, 6, 7};

        System.out.println("Array before sorting");
        printArray(arr);

        // Performing MergeSort
        mergeSort(arr, 0, arr.length - 1);

        System.out.println("Array after sorting");
        printArray(arr);
    }
}
//The time complexity of Merge Sort is always O(n log n), making it efficient for large datasets. The space complexity is O(n) due to the additional space required for the temporary arrays during the merging step.