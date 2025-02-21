/*
 * @author Gian Alingog
 * 
 * Implementation of the Sort interface as a HeapSort.
 * 
 * This HeapSort algorithm uses a fixed-size heap to sort the array.
 * The heap is built from the array, and then the elements are removed
 * from the heap in order to sort the array.
 * 
 * See FixedHeap.java for the implementation of the fixed-size heap.
 */

package sorting;

public class HeapSort implements SortAlgorithm {
    /* 
     * Sorts the array using the HeapSort algorithm
     * 
     * @param data[]: the array to be sorted
     * @param n: the number of elements in the array
     */
    public void sort(int[] data, int n) {
        FixedHeap heap = new FixedHeap(data);

        for (int i = 0; i < n; i++) {
            data[i] = heap.poll();
        }
    }
}
