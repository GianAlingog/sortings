/*
 * @author Gian Alingog
 * 
 * Implementation of a fixed-size min-heap for the HeapSort algorithm.
 * 
 * I implemented the heap as a binary tree.
 * 
 * Credit to the following sources I consulted:
 * - WilliamFiset's video on Priority Queues and Heaps
 * 
 * TODO: Implement an in-place heap for the HeapSort algorithm.
 */

package sorting;

import java.util.NoSuchElementException;

public class FixedHeap {
    private int size;
    private int bit[];

    /*
     * Constructor for FixedHeap.
     * 
     * @param data: the array to be converted into a heap
     */
    public FixedHeap(int[] data) {
        int sz = data.length;

        this.size = sz;
        this.bit = new int[sz];

        for (int i = 0; i < sz; i++) {
            bit[i] = data[i];
        }

        for (int i = Math.max(0, (sz / 2) - 1); i >= 0; i--) {
            sink(i);
        } 
    }

    /*
     * Checks if the heap is empty.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /*
     * Returns the size of the heap.
     */
    public int size() {
        return size;
    }

    /*
     * Returns the minimum element in the heap.
     */
    public int peek() {
        return bit[0];
    }

    /*
     * Removes and returns the minimum element in the heap.
     */
    public int poll() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return removeAt(0);
    }

    /*
     * Adds an element to the heap.
     * 
     * @param val: the element to be added
     */
    public void add(int val) {
        bit[size] = val;

        swim(size);

        size++;
    }

    /*
     * Removes an element at a specific index in the heap.
     * 
     * @param k: the index of the element to be removed
     */
    private int removeAt(int k) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        int removed = bit[k];
        bit[k] = bit[size - 1];

        bit[size - 1] = 0;
        size--;

        sink(k);

        return removed;
    }

    /*
     * Helper method to maintain the heap property by moving an element down the heap.
     * 
     * @param k: the index of the element to be moved
     */
    private void sink(int k) {
        int heapSize = size;
        while (true) {
            int left = 2 * k + 1;
            int right = 2 * k + 2;
            int smallest = left;

            if (right < heapSize && bit[right] < bit[left]) {
                smallest = right;
            }

            if (left >= heapSize || bit[k] < bit[smallest]) {
                break;
            }

            SortingUtility.swap(bit, k, smallest);
            k = smallest;
        }
    }

    /*
     * Helper method to maintain the heap property by moving an element up the heap.
     * 
     * @param k: the index of the element to be moved
     */
    private void swim(int k) {
        while (k > 0) {
            int parent = (k - 1) / 2;

            if (bit[k] > bit[parent]) {
                break;
            }

            SortingUtility.swap(bit, k, parent);
            k = parent;
        }
    }
}
