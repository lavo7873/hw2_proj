package com.divideandconquer;

public class MergeSorter {

	public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // sort the left half of the array
            mergeSort(arr, left, mid);

            // sort the right half of the array
            mergeSort(arr, mid + 1, right);

            // merge the two halves
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        // calculate the sizes of the two subarrays
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // create two temporary subarrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // copy data from the original array to the temporary subarrays
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        // merge the two subarrays into the original array
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // copy any remaining elements from the left subarray
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // copy any remaining elements from the right subarray
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }


}
