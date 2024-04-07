public class MaxHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap is full. Cannot insert.");
            return;
        }

        // Insert the new element at the end of the heap
        heap[size] = value;
        size++;

        // Heapify to maintain the max heap property
        heapifyUp();
    }

    private void heapifyUp() {
        int index = size - 1;
        while (index > 0 && heap[index] > heap[parent(index)]) {
            // Swap the current element with its parent
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public int delete() {
        if (size == 0) {
            System.out.println("Heap is empty. Cannot delete.");
            return -1; // Return a sentinel value indicating an error
        }

        // Replace the root with the last element
        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;

        // Heapify to maintain the max heap property
        heapifyDown(0);

        return root;
    }

    private void heapifyDown(int index) {
        int maxIndex = index;
        int leftChild = leftChild(index);
        int rightChild = rightChild(index);

        // Check if left child is larger than the current max
        if (leftChild < size && heap[leftChild] > heap[maxIndex]) {
            maxIndex = leftChild;
        }

        // Check if right child is larger than the current max
        if (rightChild < size && heap[rightChild] > heap[maxIndex]) {
            maxIndex = rightChild;
        }

        // If the max index has changed, swap and continue heapifying down
        if (index != maxIndex) {
            swap(index, maxIndex);
            heapifyDown(maxIndex);
        }
    }

    // Helper methods for calculating parent and child indices
    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
