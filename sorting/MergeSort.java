/*
 * @author Gian Alingog
 * 
 * Implementation of the Sort interface as a MergeSort.
 * 
 * This MergeSort algorithm recursively divides the array into two
 * subarrays, sorts the subarrays, and then merges them back together.
 */

package sorting;

public class MergeSort implements SortAlgorithm {
    /* 
     * Sorts the array using the MergeSort algorithm 
     * 
     * @param data[]: the array to be sorted
     * @param n: the number of elements in the array
     */
    public void sort(int[] data, int n) {
        sortR(data, 0, n);
    }

    /* 
     * Helper method for recursive MergeSort calls
     * 
     * @param data[]: the array to be sorted
     * @param start: the starting index of the subarray
     * @param index: the index of the element to be inserted
     */
    public void sortR(int[] data, int start, int n) {
        // Base case
        if (n == 1) return;

        // Split the array into two subarrays
        sortR(data, start, n / 2);
        sortR(data, start + (n / 2), (n+1) / 2);

        // Merge the two sorted subarrays
        merge(data, start, n);
    }

    /* 
     * Helper method to merge two sorted subarrays
     * 
     * @param data[]: the array to be sorted
     * @param start: the starting index of the first subarray
     * @param n: the total number of elements in the subarrays
     */
    public void merge(int[] data, int start, int n) {
        // Create a temporary array to store the first subarray
        int[] temp = new int[n / 2];
        for (int i = 0; i < n / 2; i++) {
            temp[i] = data[start + i];
        }

        int p1 = 0;
        int p2 = start + (n / 2);
        int index = 0;

        // Merge the two subarrays into the original array
        while (p1 < n / 2 && p2 < start + n) {
            if (temp[p1] <= data[p2]) {
                data[start + index] = temp[p1];
                p1++;
            } else {
                data[start + index] = data[p2];
                p2++;
            }
            index++;
        }

        while (p1 < n / 2) {
            data[start + index] = temp[p1];
            p1++;
            index++;
        }
    }
}
