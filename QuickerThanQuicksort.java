import java.util.Random;

/**
 * A hybrid sorting algorithm combining quicksort and selection sort
 * Selection sort is a simple comparison-based sorting algorithm that, 
 * 	while not the most efficient for larger arrays, performs well
 *	on small arrays due to its simplicity.
 */
public class QuickerThanQuicksort {

    // treshold for selection sort 
    private static final int MIN_QUICKSORT_SIZE = 20;

    /**
     * Sorts a subarray using quicksort if its size is larger than the threshold; otherwise, it uses selection sort
     *
     * @param arr    array to be sorted.
     * @param left   index of the left boundary of the subarray.
     * @param right  index of the right boundary of the subarray.
     * @return 	     pivot index if quicksort is used; -1 if quadratic sort is used.
     */
    public int quicksort(double[] arr, int left, int right) {
        if (right - left + 1 <= MIN_QUICKSORT_SIZE) {
            quadraticsort(arr, left, right);
            return -1; 
        }

        int pivotIndex = partition(arr, left, right);
        quicksort(arr, left, pivotIndex - 1);
        quicksort(arr, pivotIndex + 1, right);

        return pivotIndex;
    }

    /**
     * Sorts a subarray using selection.
     *
     * @param arr    array to be sorted.
     * @param left   index of the left boundary of the subarray.
     * @param right  index of the right boundary of the subarray.
     */
    public void quadraticsort(double[] arr, int left, int right) {
        for (int i = left; i <= right; i++) {
            int minIndex = i;
            for (int j = i + 1; j <= right; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the elements
            double temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    private int partition(double[] arr, int left, int right) {
        double pivot = arr[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                double temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        double temp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = temp;

        return i + 1;
    }

    /**
     * Main method 
     */
    public static void main(String[] args) {
        // Create an array with random double values
        int arraySize = 100;
        double[] arr = new double[arraySize];
        Random random = new Random();
        for (int i = 0; i < arraySize; i++) {
            arr[i] = random.nextDouble();
        }

        QuickerThanQuicksort sorter = new QuickerThanQuicksort();

        // perform the hybrid sort
        int pivotIndex = sorter.quicksort(arr, 0, arraySize - 1);

        System.out.println("Sorted Array:");
        for (int i = 0; i < arraySize; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
