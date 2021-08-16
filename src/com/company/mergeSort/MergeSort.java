package com.company.mergeSort;

import com.company.Sorter;

public class MergeSort implements Sorter {

    @Override
    public int[] sortArray(int[] arrayToSort) {

        if(arrayToSort == null){
            throw new IllegalArgumentException("Array must not be null");
        }else {
            return sort(arrayToSort, 0, arrayToSort.length - 1);
        }
    }

    private int[] merge(int arr[], int leftMostNum, int middle, int rightMostNum) {
        // Find sizes of two subarrays to be merged
        int n1 = middle - leftMostNum + 1;
        int n2 = rightMostNum - middle;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[leftMostNum + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[middle + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = leftMostNum;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
        return arr;
    }


    private int[] sort(int arr[], int leftMostNum, int rightMostNum) {
        if (leftMostNum < rightMostNum) {
            // Find the middle point
            int m =leftMostNum+ (rightMostNum-leftMostNum)/2;

            // Sort first and second halves
            sort(arr, leftMostNum, m);
            sort(arr, m + 1, rightMostNum);

            // Merge the sorted halves
            merge(arr, leftMostNum, m, rightMostNum);
        }
        return arr;
    }
}
