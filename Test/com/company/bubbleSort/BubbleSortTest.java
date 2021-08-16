package com.company.bubbleSort;

import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleSortTest {

    BubbleSort bs = new BubbleSort();

    @Test
    public void sortEmptyArray() {
        int [] emptyArray= new int[0];
        assertArrayEquals(emptyArray,bs.sortArray(emptyArray));
    }

    @Test
    public void singleElement() {
        int [] alreadySortedArray= {1};
        assertArrayEquals(alreadySortedArray,bs.sortArray(alreadySortedArray));
    }

    @Test
    public void sortAlreadySortedArray() {
        int [] alreadySortedArray= {1,2,3,4,5,6,7,8,9,10};
        assertArrayEquals(alreadySortedArray,bs.sortArray(alreadySortedArray));
    }

    @Test
    public void sortUnsortedSortedArray() {
        int [] unsortedArray= {10,9,8,7,6,5,4,3,2,1};
        int [] alreadySortedArray= {1,2,3,4,5,6,7,8,9,10};
        assertArrayEquals(alreadySortedArray,bs.sortArray(unsortedArray));
    }

    @Test
    public void sortNegativeArray() {
        int [] unsortedArray= {-10,-9,-8,-7,-6,-5,-4,-3,-2,-1};
        int [] sortedArray= {-1,-2,-3,-4,-5,-6,-7,-8,-9,-10};
        assertArrayEquals(unsortedArray,bs.sortArray(sortedArray));
    }

    @Test
    public void sortZeroValueArray() {
        int [] zeroArray= {0,0,0,0};
        assertArrayEquals(zeroArray,bs.sortArray(zeroArray));
    }

    @Test
    public void positiveAndNegativeValueArray() {
        int [] unsortedArray= {-1,2,-3,4,-5,6,-7,8,-9,10};
        int [] sortedArray= {10,8,6,4,2,-1,-3,-5,-7,-9};
        assertArrayEquals(sortedArray,bs.sortArray(unsortedArray));
    }


    //negative value
    //0 value
    //mixture of possive and negative values

}