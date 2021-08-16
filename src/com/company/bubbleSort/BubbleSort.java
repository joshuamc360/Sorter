package com.company.bubbleSort;

import com.company.Sorter;

public class BubbleSort implements Sorter {

    @Override
    public int[] sortArray(int[] arrayToSort) {
        return bubbleSort(arrayToSort);
    }

    public static int[] bubbleSort(int array[]) {
        int n = array.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                // if the current element is bigger than the next, swap
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
        return array;
    }

}
