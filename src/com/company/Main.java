package com.company;

import com.company.binaryTree.BST;
import com.company.binaryTree.ChildNotFoundException;
import com.company.bubbleSort.BubbleSort;
import com.company.mergeSort.MergeSort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ChildNotFoundException {
        startSorter();
    }

    public static void startSorter(){

        boolean loadMenu = true;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Pick an Sorting Algorithm");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Binary Search Tree");
            System.out.println("3. Merge Sort");
            System.out.println("4. Quit Program");

            int choice = scan.nextInt();
            int length;

            switch (choice) {
                case 1 :
                    System.out.println("Pick length of Array");
                    length = scan.nextInt();
                    startBubbleSort(length);
                    break;

                case 2 :
                    System.out.println("Pick length of Array");
                    length = scan.nextInt();
                    startBST(length);
                    break;

                case 3 :
                    System.out.println("Pick length of Array");
                    length = scan.nextInt();
                    startMergeSort(length);
                    break;

                case 4 :
                    System.out.println("Thanks for using Sorter");
                    loadMenu =false;
                    break;

                default: System.out.println("Invalid choice");

            } // end of switch
        } while (loadMenu);
    }

    private static void startBubbleSort(int lengthOfArray){

        //create array, sort the array and calculate time taken
        int[] array = createRandomArray(lengthOfArray);

        System.out.println("Unsorted Array:"+ Arrays.toString(array));
        BubbleSort bs = new BubbleSort();

        long start = System.nanoTime();
        int [] sortedArray = bs.sortArray(array);
        long end = System.nanoTime();
        long time = calcAlgoTime(start,end);

        printResults(sortedArray,time);
    }

    private static void startBST(int lengthOfArray){

        int[] array = createRandomArray(lengthOfArray);
        System.out.println("Unsorted Array:"+ Arrays.toString(array));

        BST tree = new BST();
        tree.addElements(array);

        long start = System.nanoTime();
        int[] sortedArray = tree.sortArray(array);
        long end = System.nanoTime();
        long time = calcAlgoTime(start,end);

        printResults(sortedArray,time);

//      code for catching exception for getChild methods.
//        try{
//            tree.getLeftChild(40);
//        }catch(ChildNotFoundException cnf){
//            System.out.println(cnf.getMessage());
//        }

    }

    private static void startMergeSort(int lengthOfArray){
        //create array, start merge sort algo and track time taken

        int[] array = createRandomArray(lengthOfArray);

        System.out.println("Unsorted Array:"+ Arrays.toString(array));

        MergeSort mergeSort = new MergeSort();
        long start = System.nanoTime();
        int [] sortedArray = mergeSort.sortArray(array);
        long end = System.nanoTime();

        long time = calcAlgoTime(start,end);

        printResults(sortedArray,time);
    }

    private static int[] createRandomArray(int length){

        //validate length
        int[] array = new int[length];

        //generate random number
        Random random = new Random();

        //populate the array
        for(int i=0;i<array.length;i++) {
            int randomNumber = random.nextInt(100);
            array[i] = randomNumber;
        }
        return array;
    }

    private static long calcAlgoTime(long start, long end){
        return end-start;
    }

    private static void printResults(int[] sortedArray, long time){
        System.out.println("Sorted Array: "+ Arrays.toString(sortedArray));
        System.out.println("Elapsed Time: "+time+" nanoseconds.");
    }

}
