import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * SortingAlgorithms is a class that runs and calculates running times of numerous sort algorithms saves data to a .txt file
 */

public class SortingAlgorithms {

/**
 * Writes data to file
 *
 * @param fileName = name of the file to write to.
 * @param data = data to write to the file.
 */
    public static void writeDataToFile(String fileName, String data) {
        try {
            FileWriter writer = new FileWriter(fileName, true); 
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
/**
 * Main function copies arrays of differing sizes and calls functions to perform different sorts
 */
    public static void main(String[] args) {

        // declare array sizes based on project specs
        int[] arraySizes = { 50000, 100000, 150000, 200000, 250000, 300000, 350000, 400000, 450000, 500000 };
        for (int size : arraySizes) {
    
            // intialize array with random values by calling the generate array function
            float[] unsortedArray = generateArray(size);

            // copy each array and then call function to perform sort
            float[] selectionSortArray = Arrays.copyOf(unsortedArray, size);
            float[] bubbleSortArray = Arrays.copyOf(unsortedArray, size);
            float[] insertionSortArray = Arrays.copyOf(unsortedArray, size);
            float[] mergeSortArray = Arrays.copyOf(unsortedArray, size);
            float[] quickSortArray = Arrays.copyOf(unsortedArray, size);

            // catch return value and print onto console
            long selectionSortTime = selectionSort(selectionSortArray);
            long bubbleSortTime = bubbleSort(bubbleSortArray);
            long insertionSortTime = insertionSort(insertionSortArray);
            long mergeSortTime = mergeSort(mergeSortArray);
            long quickSortTime = quickSort(quickSortArray);

            System.out.println("Array Size: " + size);
            System.out.println("Selection Sort Time: " + selectionSortTime + " milliseconds");
            System.out.println("Bubble Sort Time: " + bubbleSortTime + " milliseconds");
            System.out.println("Insertion Sort Time: " + insertionSortTime + " milliseconds");
            System.out.println("Merge Sort Time: " + mergeSortTime + " milliseconds");
            System.out.println("Quick Sort Time: " + quickSortTime + " milliseconds");

            // create a string with the data
            String data = "Algorithm,ArraySize,Time\n";
            data += "Selection Sort," + size + "," + selectionSortTime + "\n";
            data += "Bubble Sort," + size + "," + bubbleSortTime + "\n";
            data += "Insertion Sort," + size + "," + insertionSortTime + "\n";
            data += "Merge Sort," + size + "," + mergeSortTime + "\n";
            data += "Quick Sort," + size + "," + quickSortTime + "\n";

            // write data to file to be accessed by python script
            writeDataToFile("sorting_data.txt", data);
        }
    }
/**
 * Generates random arraysand intializes array with random numbers (floats)
 *
 * @param size = size of array
 * @retun arr = intialized array returned
 */

    public static float[] generateArray(int size) {
        float[] arr = new float[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextFloat();
        }
        return arr;
    }
/**
 * Selection sort function
 *
 * @param arr = unsorted array
 * @retun arr = time between function start and end
 */
    public static long selectionSort(float[] arr) {
        long timeMillisStart = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            int minimum = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minimum]) {
                    minimum = j;
                }
            }
            float temp = arr[minimum];
            arr[minimum] = arr[i];
            arr[i] = temp;
        }
        long timeMillisEnd = System.currentTimeMillis();
        return timeMillisEnd - timeMillisStart;
    }
/**
 * Bubble sort function
 *
 * @param arr = unsorted array
 * @retun arr = time between function start and end
 */
    public static long bubbleSort(float[] arr) {
        long timeMillisStart = System.currentTimeMillis();
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    float temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if(swapped == false){
                    break;
            }
        }

        long timeMillisEnd = System.currentTimeMillis();
        return timeMillisEnd - timeMillisStart;
    }
/**
 * Insertion sort function
 *
 * @param arr = unsorted array
 * @retun arr = time between function start and end
 */
    public static long insertionSort(float[] arr) {
        long timeMillisStart = System.currentTimeMillis();
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            float key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

        long timeMillisEnd = System.currentTimeMillis();
        return timeMillisEnd - timeMillisStart;
    }
/**
 * Recursive Merge sort function
 * @param arr = unsorted array with left ad right sides
 */
    public static void mergeSort(float[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }
/**
 * Merge sort Merge function
 *
 * @param arr = unsorted array with endpoints to merge
 */
    public static void merge(float[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        float[] leftArray = new float[n1];
        float[] rightArray = new float[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[middle + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
/**
 * Merge sort function
 *
 * @param arr = unsorted array
 * @retun arr = time between function start and end
 */
    public static long mergeSort(float[] arr) {
        long timeMillisStart = System.currentTimeMillis();
        int n = arr.length;
        mergeSort(arr, 0, n - 1);
        long timeMillisEnd = System.currentTimeMillis();
        return timeMillisEnd - timeMillisStart;
    }
/**
 * Quick sort function
 *
 * @param arr = unsorted array
 * @retun arr = time between function start and end
 */
    public static void quickSort(float[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(float[] arr, int low, int high) {
        float pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                float temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        float temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static long quickSort(float[] arr) {
        long timeMillisStart = System.currentTimeMillis();
        int n = arr.length;
        quickSort(arr, 0, n - 1);
        long timeMillisEnd = System.currentTimeMillis();
        return timeMillisEnd - timeMillisStart;
    }
/**
 * All function family sends each array size to the respective sort
 * @param = array of unsprted arrays
 */
    public static void selectionsortAll(float[][] arrays) {
        String algorithmName = "Selection Sort";

        for (int i = 0; i < arrays.length; i++) {
            long time = selectionSort(arrays[i]);
            int arraySize = arrays[i].length;
            System.out.println("Algorithm: " + algorithmName + ", Array Size: " + arraySize + ", Time: " + time + " milliseconds");
        }
    }

    public static void bubblesortAll(float[][] arrays) {
        String algorithmName = "Bubble Sort";

        for (int i = 0; i < arrays.length; i++) {
            long time = bubbleSort(arrays[i]);
            int arraySize = arrays[i].length;
            System.out.println("Algorithm: " + algorithmName + ", Array Size: " + arraySize + ", Time: " + time + " milliseconds");
        }
    }

    public static void insertionsortAll(float[][] arrays) {
        String algorithmName = "Insertion Sort";

        for (int i = 0; i < arrays.length; i++) {
            long time = insertionSort(arrays[i]);
            int arraySize = arrays[i].length;
            System.out.println("Algorithm: " + algorithmName + ", Array Size: " + arraySize + ", Time: " + time + " milliseconds");
        }
    }

    public static void mergesortAll(float[][] arrays) {
        String algorithmName = "Merge Sort";

        for (int i = 0; i < arrays.length; i++) {
            long time = mergeSort(arrays[i]);
            int arraySize = arrays[i].length;
            System.out.println("Algorithm: " + algorithmName + ", Array Size: " + arraySize + ", Time: " + time + " milliseconds");
        }
    }

    public static void quicksortAll(float[][] arrays) {
        String algorithmName = "Quick Sort";

        for (int i = 0; i < arrays.length; i++) {
            long time = quickSort(arrays[i]);
            int arraySize = arrays[i].length;
            System.out.println("Algorithm: " + algorithmName + ", Array Size: " + arraySize + ", Time: " + time + " milliseconds");
        }
    }

}
