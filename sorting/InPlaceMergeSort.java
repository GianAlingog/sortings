/*
 * @author Gian Alingog
 * 
 * Implementation of the Sort interface as an InPlaceMergeSort.
 * 
 * The main idea for this in-place MergeSort was to use three pointers,
 * p1, p2, and p3, where p1 is initialized at the start of the first
 * half, and p2 and p3 at the start of the second. With these, compare
 * the elements at these three pointers, and move the smallest element
 * to the back of the sorted portion of the array at the front. Then,
 * rinse and repeat, while always incrementing p1, which marks the index
 * right after the sorted portion of the array. Increment p3 if it was
 * just previously swapped AND the element after it is greater. Keep
 * p2 in place.
 * 
 * This was one of the ideas I originally drafted to try and construct
 * an in-place O(nlog(n)) MergeSort, however, it can be proven that this
 * will not guarantee that the second half of the sub-array will be
 * sorted. Thus, a simple solution would be to call another MergeSort
 * to re-sort that portion.
 * 
 * For further research, the state of the second half after applying
 * the original idea could be further explored. If it is always
 * near-sorted, which is my hypothesis, perhaps a different sorting
 * algorithm may be used to resolve the second half.
 * 
 * Time Complexity: O(nlog^2(n))
 * Space Complexity: O(1) + original array
 * 
 * Note: I have not done any research on other attempts at in-place
 * MergeSort. There might be a similar or more constant-efficient
 * algorithm or implementation out there.
 */

package sorting;

public class InPlaceMergeSort implements SortAlgorithm {
    /* 
    * Sorts the array using the InPlaceMergeSort algorithm 
    * 
    * @param data[]: the array to be sorted
    * @param n: the number of elements in the array
    */
    public void sort(int[] data, int n) {
        sortR(data, 0, n);
    }

    /* 
     * Helper method for recursive InPlaceMergeSort calls
     * 
     * @param data[]: the array to be sorted
     * @param start: the starting index of the subarray
     * @param index: the index of the element to be inserted
     */
    public void sortR(int[] data, int start, int n) {
        if (n == 1) return;

        sortR(data, start, n / 2);
        sortR(data, start + (n / 2), (n+1) / 2);

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
        int p1 = start, p2 = start + (n / 2), p3 = p2;

        while (p1 != p3) {
            if (p1 >= p2) {
                if (data[p1] > data[p3]) { 
                    SortingUtility.swap(data, p1, p3);
                }
            } else {
                if (data[p3] < data[p1] && (p2 == p3 || data[p3] < data[p2])) {
                    SortingUtility.swap(data, p1, p3);
                    if (p3 < (start + n - 1) && data[p3] < data[p3+1]) p3++;
                } else if (data[p2] < data[p1] && (p2 == p3 || data[p2] < data[p3])) {
                    SortingUtility.swap(data, p1, p2);
                }
            }
            p1++;

            sortR(data, start + (n / 2), (n + 1) / 2);
        }
    }
}
