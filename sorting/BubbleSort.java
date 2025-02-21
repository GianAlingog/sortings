/*
 * @author Gian Alingog
 * 
 * Implementation of the Sort interface as a BubbleSort.
 * 
 * This BubbleSort algorithm passes through the array comparing elements
 * and swapping them if they are in the wrong order. This process is
 * repeated until the array is sorted. It can be proven that the worst
 * case will take n-1 passes to sort the array.
 * 
 * Note: This implementation is optimized to stop early if no swaps
 * are made in a pass, indicating that the array is already sorted.
 */

package sorting;

public class BubbleSort implements SortAlgorithm {
    /* 
     * Sorts the array using the BubbleSort algorithm 
     * 
     * @param data[]: the array to be sorted
     * @param n: the number of elements in the array
     */
    public void sort(int[] data, int n) {
        // Iterate through the array n-1 times
        for (int i = 0; i < n - 1; i++) {
            // Iterate through each element and swap adjacent elements
            // Note, i elements are already sorted at the end of the array
            // so we only need to pass through n-i. This is the nature of
            // BubbleSort; the largest element will "bubble" to the end
            boolean sorted = passThrough(data, n-i);

            // If the array is already sorted, break early
            if (sorted) {
                break;
            }
        }
    }

    /* 
     * Helper method to pass through the array and swap adjacent elements
     * if they are in the wrong order
     * 
     * @param data[]: the array to be sorted
     * @param n: the number of elements to pass through
     * 
     * @return whether the array is sorted
     */
    private static boolean passThrough(int[] data, int n) {
        boolean swapped = false;

        for (int j = 0; j < n - 1; j++) {
            if (data[j] > data[j + 1]) {
                SortingUtility.swap(data, j, j + 1);
                swapped = true;
            }
        }

        // Swapped is false if no swaps were made, true otherwise
        // Thus, return the opposite to indicate whether the array is sorted
        return !swapped;
    }
}
