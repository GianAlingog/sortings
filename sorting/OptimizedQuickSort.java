/*
 * @author Gian Alingog
 * 
 * Implementation of the Sort interface as an optimized version of QuickSort.
 * 
 * This optimized version of QuickSort uses the median-of-three pivot selection
 * and tail recursion optimization. It also uses InsertionSort for small partitions.
 */

package sorting;

public class OptimizedQuickSort implements SortAlgorithm {
    // Threshold for switching to InsertionSort
    private static final int THRESHOLD = 10;

    /*
     * Sorts the array using the optimized QuickSort algorithm
     * 
     * @param data[]: the array to be sorted
     * @param n: the number of elements in the array
     */
    public void sort(int[] data, int n) {
        sortR(data, 0, n - 1);

        // Final pass in case small partitions exist
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(data, n);
    }

    /*
     * Recursive method for sorting the array using the optimized QuickSort algorithm
     * 
     * @param data[]: the array to be sorted
     * @param low: the lower bound of the array
     * @param high: the upper bound of the array
     */
    private void sortR(int[] data, int low, int high) {
        while (high - low >= THRESHOLD) {
            int pivotIndex = medianOfThree(data, low, high);
            int pivot = partition(data, low, high, pivotIndex);
            
            // Recur on smaller subarray first (tail recursion optimization)
            if (pivot - low < high - pivot) {
                sortR(data, low, pivot - 1);
                low = pivot + 1;
            } else {
                sortR(data, pivot + 1, high);
                high = pivot - 1;
            }
        }
    }

    /*
     * Selects the median of three elements as the pivot
     * 
     * @param data[]: the array to be sorted
     * @param low: the lower bound of the array
     * @param high: the upper bound of the array
     */
    private int medianOfThree(int[] data, int low, int high) {
        int mid = low + (high - low) / 2;
        if (data[mid] < data[low]) SortingUtility.swap(data, mid, low);
        if (data[high] < data[low]) SortingUtility.swap(data, high, low);
        if (data[high] < data[mid]) SortingUtility.swap(data, high, mid);
        return mid;
        // The median is now at 'mid'
    }

    /*
     * Partitions the array using the pivot
     * 
     * @param data[]: the array to be sorted
     * @param low: the lower bound of the array
     * @param high: the upper bound of the array
     * @param pivotIndex: the index of the pivot
     */
    private int partition(int[] data, int low, int high, int pivotIndex) {
        // Move pivot to end
        int pivot = data[pivotIndex];
        SortingUtility.swap(data, pivotIndex, high);
        int i = low;
        
        for (int j = low; j < high; j++) {
            if (data[j] < pivot) {
                SortingUtility.swap(data, i, j);
                i++;
            }
        }

        // Restore pivot
        SortingUtility.swap(data, i, high);
        return i;
    }
}
