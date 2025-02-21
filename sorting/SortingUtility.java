/*
 * @author Gian Alingog
 * 
 * Utility class for sorting algorithms.
 */

package sorting;

public class SortingUtility {
    /*
     * Helper method for swapping two elements in the array
     * 
     * @param data[]: the array to be sorted
     * @param i: the index of the first element
     * @param j: the index of the second element
     */
    public static void swap(int[] data, int i, int j) {
        // Guard clause to prevent swapping the same element
        if (i == j) {
            return;
        }

        // Swap the elements at indices i and j with a temporary variable
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    /*
     * Helper method for checking if the array is sorted
     * 
     * @param data[]: the array to be sorted
     * @param n: the number of elements in the array
     */
    public static boolean isSorted(int[] data, int n) {
        for (int i = 1; i < n; i++) {
            // If two elements are out of order, the array is not sorted
            if (data[i - 1] > data[i]) {
                return false;
            }
        }

        // If no elements are out of order, the array is sorted
        return true;
    }

    /* 
     * Helper method for shuffling the array
     * 
     * @param data[]: the array to be sorted
     * @param n: the number of elements in the array
     */
    public static void shuffle(int[] data, int n) {
        // Shuffle the array by swapping each element with a random element
        for (int i = 0; i < n; i++) {
            int j = (int) (Math.random() * n);
            swap(data, i, j);
        }
    }

    /*
     * Helper method for checking if the array is near-sorted
     * 
     * @param data[]: the array to be sorted
     * @param n: the number of elements in the array
     * @param threshold: the percentage of elements that can be out of order
     */
    public static boolean isNearSorted(int[] data, int n, double threshold) {
        int outOfOrderCount = 0;

        for (int i = 0; i < n - 1; i++) {
            if (data[i] > data[i + 1]) {
                outOfOrderCount++;
            }
        }

        double percentageOutOfOrder = (outOfOrderCount / (double) (n - 1)) * 100;
        return percentageOutOfOrder <= threshold;
    }
}
