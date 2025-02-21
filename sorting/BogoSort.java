/*
 * @author Gian Alingog
 * 
 * Implementation of the Sort interface as a BogoSort.
 * 
 * This BogoSort algorithm can be classified as a "pure" BogoSort
 * because it shuffles the array first before checking if it is sorted,
 * which means that passing a sorted array will not guarantee that the
 * algorithm will terminate.
 */

package sorting;

public class BogoSort implements SortAlgorithm {
    /* 
     * Sorts the array using the BogoSort algorithm 
     * 
     * @param data[]: the array to be sorted
     * @param n: the number of elements in the array
     */
    public void sort(int[] data, int n) {
        // Shuffle the array then check if it is sorted
        do {
            SortingUtility.shuffle(data, n);
        } while (!SortingUtility.isSorted(data, n));
    }
}