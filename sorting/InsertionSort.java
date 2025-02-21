/*
 * @author Gian Alingog
 * 
 * Implementation of the Sort interface as a InsertionSort.
 * 
 * This InsertionSort "inserts" each element into the sorted portion
 * of the array by swapping elements, until it is in the correct
 * position. Once all elements have been "inserted," the resulting
 * array will be sorted.
 */

package sorting;

public class InsertionSort implements SortAlgorithm {
    /* 
     * Sorts the array using the InsertionSort algorithm 
     * 
     * @param data[]: the array to be sorted
     * @param n: the number of elements in the array
     */
    public void sort(int[] data, int n) {
        // Iterate through each element and insert
        // it into the sorted portion of the array
        for (int i = 1; i < n; i++) {
            insert(data, i);
        }
    }

    /* 
     * Helper method to insert an element at index into
     * the sorted portion of the array
     * 
     * @param data[]: the array to be sorted
     * @param index: the index of the element to be inserted
     */
    private static void insert(int[] data, int index) {
        // While there are still elements in the sorted portion of 
        // the array that are greater than the element at index, swap them
        while (index > 0 && data[index - 1] > data[index]) {
            SortingUtility.swap(data, index - 1, index);
            index--;
        }
    }
}
