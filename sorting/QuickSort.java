/*
 * @author Gian Alingog
 * 
 * Implementation of the Sort interface as a base version of QuickSort.
 */

package sorting;

public class QuickSort implements SortAlgorithm {
    /*
     * Sorts the array using the base QuickSort algorithm
     * 
     * @param data[]: the array to be sorted
     * @param n: the number of elements in the array
     */
    public void sort(int[] data, int n) {
        sortR(data, 0, n - 1);
    }

    /*
     * Recursive method for sorting the array using the base QuickSort algorithm
     * 
     * @param data[]: the array to be sorted
     * @param low: the lower bound of the array
     * @param high: the upper bound of the array
     */
    private void sortR(int[] data, int low, int high) {
        if (low < high) {
            int pivot = partition(data, low, high);
            sortR(data, low, pivot - 1);
            low = pivot + 1;

            sortR(data, pivot + 1, high);
            high = pivot - 1;

        }
    }

    /*
     * Partitions the array using the pivot
     * 
     * @param data[]: the array to be sorted
     * @param low: the lower bound of the array
     * @param high: the upper bound of the array
     */
    private int partition(int[] data, int low, int high) {
        int pivot = data[high];
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
