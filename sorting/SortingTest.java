/*
 * @author Gian Alingog
 * 
 * Driver class for testing the different sorting algorithms.
 * 
 * Available sorting algorithms:
 * - BOGO: BogoSort
 * - BUBBLE: BubbleSort
 * - SELECTION: SelectionSort
 * - INSERTION: InsertionSort
 * - MERGE: MergeSort
 * - QUICK: QuickSort
 * - INPLACEMERGE: InPlaceMergeSort
 * - HEAP: HeapSort
 * - OPTIMIZEDQUICK: OptimizedQuickSort
 * - HYBRID: HybridSort
 * - ALL: Test all sorting algorithms
 * 
 * To test all sorting algorithms, use the ALL enum.
 * 
 * See their respective classes for more information.
 */

package sorting;

import java.util.Random;
import java.util.function.Supplier;

/* Enum for data type */
enum DataType {
    RANDOM, SORTED, REVERSED, ONE, ODD, EVEN, POWER_OF_2, ALL
}

/* Enum for hybrid flags */
enum HybridFlags {
    STABLE, LOW_MEMORY, IN_PLACE
}

/* Enum for sorting algorithms */
enum Sort {
    // BOGO(BogoSort::new),
    // BUBBLE(BubbleSort::new),
    // SELECTION(SelectionSort::new),
    // INSERTION(InsertionSort::new),
    MERGE(MergeSort::new),
    // QUICK(QuickSort::new),
    // INPLACEMERGE(InPlaceMergeSort::new),
    HEAP(HeapSort::new),
    OPTIMIZEDQUICK(OptimizedQuickSort::new),
    HYBRID(HybridSort::new),
    ALL(null);

    private Supplier<Object> supplier;
    
    Sort(Supplier<Object> supplier) {
        this.supplier = supplier;
    }

    public Object createSorter() {
        return supplier.get();
    }

    public void sort(int[] data, int n) {
        ((SortAlgorithm) createSorter()).sort(data, n);
    }
}

/* Driver class for testing sorting algorithms */
public class SortingTest {
    // Modify this to test different hybrid flags
    private static boolean[] hybridFlags = new boolean[] { false, true, false };
    
        public static void main(String[] args) {
            // Change this to test a specific sorting algorithm
            Sort sortAlgorithm = Sort.ALL;

            // Change this to test a different data type
            DataType dataType = DataType.ALL;
            
            // Change this to test a different data size
            // Note: Do not test QuickSort on very large data sizes
            // This is because it will cause a stack overflow
            // due to unoptimized code.
            int dataSize = 1000000;
    


            /* ### START BLOCK --- TESTING BLOCK ### */
            if (sortAlgorithm == Sort.ALL) {
                for (Sort sorter : Sort.values()) {
                    if (sorter == Sort.ALL) {
                        continue;
                    }

                    if (dataType == DataType.ALL) {
                        for (DataType type : DataType.values()) {
                            if (type == DataType.ALL) {
                                continue;
                            }
                            executeTest(sorter, type, dataSize);
                        }
                    } else {
                        executeTest(sorter, dataType, dataSize);
                    }
                }
            } else {
                if (dataType == DataType.ALL) {
                    for (DataType type : DataType.values()) {
                        if (type == DataType.ALL) {
                            continue;
                        }
                        executeTest(sortAlgorithm, type, dataSize);
                    }
                } else {
                    executeTest(sortAlgorithm, dataType, dataSize);
                }
            }
            /* ### END BLOCK --- TESTING BLOCK ### */
        }

        private static int[] generateData(DataType dataType, int dataSize) {
            int bound = 10000;
            Random random = new Random();
            int[] data = new int[dataSize];
            switch (dataType) {
                case RANDOM:
                    for (int i = 0; i < dataSize; i++) {
                        data[i] = random.nextInt(bound);
                    }
                    break;
                case SORTED:
                    for (int i = 0; i < dataSize; i++) {
                        data[i] = i;
                    }
                    break;
                case REVERSED:
                    for (int i = 0; i < dataSize; i++) {
                        data[i] = dataSize - i;
                    }
                    break;
                case ONE:
                    data = new int[1];
                    for (int i = 0; i < 1; i++) {
                        data[i] = 1;
                    }
                    break;
                case ODD:
                    dataSize = dataSize + (dataSize % 2 == 0 ? 1 : 0);
                    data = new int[dataSize];
                    for (int i = 0; i < dataSize; i++) {
                        data[i] = random.nextInt(bound);
                    }
                    break;
                case EVEN:
                    dataSize = dataSize + (dataSize % 2 == 1 ? 1 : 0);
                    for (int i = 0; i < dataSize; i++) {
                        data[i] = random.nextInt(bound);
                    }
                    break;
                case POWER_OF_2:
                    dataSize = (int) Math.pow(2, (int) (Math.log(dataSize) / Math.log(2)));
                    data = new int[dataSize];
                    for (int i = 0; i < dataSize; i++) {
                        data[i] = random.nextInt(bound);
                    }
                    break;
                case ALL:
                    throw new IllegalArgumentException("Cannot generate data for all data types");
            }
            return data;
        }
    
        /*
         * Helper method for testing a sortAlgorithm with an integer array 
         * 
         * @param sortAlgorithm: the sorting algorithm to be tested
         * @param data: the array to be sorted
         */
        private static void executeTest(Sort sortAlgorithm, DataType dataType, int dataSize) {
            int[] data = generateData(dataType, dataSize);

            long startTime, endTime;
            if (sortAlgorithm == Sort.HYBRID) {
                HybridSort hybridSort = new HybridSort();
                startTime = System.nanoTime();
                hybridSort.sort(data, data.length, hybridFlags);
                endTime = System.nanoTime();
            } else {
                startTime = System.nanoTime();
                sortAlgorithm.sort(data, data.length);
                endTime = System.nanoTime();
            }
            // System.out.println("Sorted using " + sortAlgorithm.name() + ": " + java.util.Arrays.toString(data) + " in " + (endTime - startTime) + " ns");
            System.out.println("Sorted a " + dataType.name() + " of size " + dataSize + " using " + sortAlgorithm.name() + " in " + (endTime - startTime) + " ns");
    }
}
