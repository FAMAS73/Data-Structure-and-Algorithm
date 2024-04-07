public class ShellSort {
    // Function to perform shell sort
    public static void shellSort(int arr[]) {
        int n = arr.length;

        // Start with a big gap, then reduce the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Do a gapped insertion sort for this gap size.
            // The first gap elements a[0..gap-1] are already in gapped order
            // Keep adding one more element until the entire array is gap sorted
            for (int i = gap; i < n; i++) {
                // Add a[i] to the elements that have been gap sorted
                // save a[i] in temp and make a hole at position i
                int temp = arr[i];

                // Shift earlier gap-sorted elements up until the correct location for a[i] is found
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }

                // Put temp (the original a[i]) in its correct location
                arr[j] = temp;
            }
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
        int arr[] = {12, 34, 54, 2, 3};

        System.out.println("Array before sorting");
        printArray(arr);

        // Performing Shell Sort
        shellSort(arr);

        System.out.println("Array after sorting");
        printArray(arr);
    }
}
    //The time complexity of Shell Sort is not easy to determine precisely and depends on the gap sequence used. The worst-case time complexity for Shell Sort is generally considered to be O(n^2). However, in practice, it often performs better than other O(n^2) algorithms such as Bubble Sort and Insertion Sort. The best-known gap sequence for the average case time complexity is the "Sedgewick" sequence, which leads to O(n^(4/3)) time complexity. Overall, Shell Sort has a time complexity that varies depending on the gap sequence but is generally better than O(n^2) for most cases.