/*
 * @author Gian Alingog
 * 
 * Implementation of the Sort interface as a hybrid sorting algorithm.
 * 
 * This hybrid sorting algorithm uses different sorting algorithms based on
 * the states and flags passed to it. The flags and states are as follows:
 * - SMALL: Use InsertionSort
 * - STABLE: Use MergeSort
 * - LOW_MEMORY: Use OptimizedQuickSort
 * - IN_PLACE: Use HeapSort
 * - NEAR_SORTED: Use InsertionSort
 * - DEFAULT: Use MergeSort
 */

package sorting;

public class HybridSort {
    /*
     * Sorts the array using different sorting algorithms based on the flags and states.
     * 
     * @param data[]: the array to be sorted
     * @param n: the number of elements in the array
     * @param flags[]: the flags to be used
     */
    public void sort(int[] data, int n, boolean[] flags) {
        // SMALL
        if (n <= 10) {
            InsertionSort insertionSort = new InsertionSort();
            insertionSort.sort(data, n);
        }

        // STABLE
        else if (flags[HybridFlags.STABLE.ordinal()]) {
            MergeSort mergeSort = new MergeSort();
            mergeSort.sort(data, n);
        }

        // LOW_MEMORY
        else if (flags[HybridFlags.LOW_MEMORY.ordinal()]) {
            OptimizedQuickSort optimizedQuickSort = new OptimizedQuickSort();
            optimizedQuickSort.sort(data, n);
        }

        // IN_PLACE
        else if (flags[HybridFlags.IN_PLACE.ordinal()]) {
            HeapSort heapSort = new HeapSort();
            heapSort.sort(data, n); 
        }

        // NEAR_SORTED
        else if (SortingUtility.isNearSorted(data, n, 0.25d)) {
            InsertionSort insertionSort = new InsertionSort();
            insertionSort.sort(data, n);
        }

        // DEFAULT
        else {
            MergeSort mergeSort = new MergeSort();
            mergeSort.sort(data, n);
        }
    }
}
