import java.util.Arrays;

public class ArraySort {

    /**
     * The mergeSort function recursively divides the array into subarrays
     * and sorts them using the merge function.
     * (arr) The array to be sorted
     * (left) The left index of the subarray to be sorted
     * (right) The right index of the subarray to be sorted
     */
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Recursively sort the left and right subarrays
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the sorted subarrays
            merge(arr, left, mid, right);
        }
    }

    /**
     * The merge function merges two sorted subarrays into a larger sorted array.
     * (arr) The array containing the subarrays to be merged
     * (left) The left index of the first subarray
     * (mid) The right index of the first subarray and the left index of the second subarray
     * (right) The right index of the second subarray
     */
    public static void merge(int[] arr, int left, int mid, int right) {
        // Determine the sizes of the two subarrays
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays to hold the two subarrays
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // Copy the data from the original array into the two subarrays
        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }

        for (int i = 0; i < n2; i++) {
            rightArr[i] = arr[mid + 1 + i];
        }

        // Merge the two subarrays
        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements from the left subarray
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        // Copy any remaining elements from the right subarray
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("Original array: " + Arrays.toString(arr));

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}