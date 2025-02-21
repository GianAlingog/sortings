/*
 * @author Gian Alingog
 * 
 * Implementation of the Sort interface as a SelectionSort.
 * 
 * This SelectionSort algorithm "selects" the largest element
 * in the unsorted portion of the array and swaps it with the
 * last element in the unsorted portion of the array. Once all
 * elements have been "selected," the array will be sorted.
 */

package sorting;

public class SelectionSort implements SortAlgorithm {
    /* 
     * Sorts the array using the SelectionSort algorithm 
     * 
     * @param data[]: the array to be sorted
     * @param n: the number of elements in the array
     */
    public void sort(int[] data, int n) {
        // Swap max elements to the end of the array in each iteration
        for (int i = n - 1; i >= 0; i--) {
            int maxIndex = findMaxIndex(data, i);
            SortingUtility.swap(data, i, maxIndex);
        }
    }

    /* 
     * Helper method for finding the index of the maximum
     * element in the subarray
     * 
     * @param data[]: the array to be sorted
     * @param n: the number of elements in the subarray
     * 
     * @return the index of the maximum element in the subarray
     */
    private static int findMaxIndex(int[] data, int n) {
        int maxIndex = 0;
        for (int i = 1; i <= n; i++) {
            if (data[i] > data[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
