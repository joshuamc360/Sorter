package com.company.binaryTree;

import com.company.Sorter;

public class BST implements BinaryTree , Sorter {

    private Node root;
    private int counter=0;

    private int ascCounter=0;
    private int[] sortedArray=new int [counter];

    public BST() {
        root = null;
    }

    @Override
    public int getRootElement() {
        return root.number;
    }

    @Override
    public int getNumberOfElements() {
        return counter;
    }

    @Override
    public void addElement(int number) {
        counter++;
        root = addElementRec(number);
    }

    @Override
    public void addElements(int[] elements) {
        for (int number : elements) {
            addElementRec(elements[number]);
            counter++;
        }
    }

    private Node addElementRec(int number) {
        Node node = new Node(number);

        if (root == null) {
            return node;
        }

        if (number < root.number) {
            root.leftChild = addElementRec(root.leftChild.number);

        } else if (number > root.number) {
            root.rightChild = addElementRec(root.rightChild.number);
        }

        return node;
    }

    @Override
    public boolean findElement(int number) {
        if(findNode(root,number)==null){
            return false;
        } else return findNode(root, number).number == number;
    }

    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {

        //find the left child of the elements
        Node leftChild = findNode(root,element).leftChild;

        if(leftChild == null){
            throw new ChildNotFoundException("Left Child Not Found.");
        }
        return leftChild.number;
    }

    @Override
    public int getRightChild(int element) throws ChildNotFoundException {

        //get right child of element
        Node rightChild = findNode(root,element).rightChild;

        //if right child is null throw exception
        if(rightChild == null){
            throw new ChildNotFoundException("Right Child not found.");
        }

        return rightChild.number;
    }

    private Node findNode(Node root, int number){

        if (root==null )
            return null;

        if(root.number== number)
            return root;

        // Key is greater than root's key
        if (root.number <  number)
            return findNode(root.rightChild,  number);

        // Key is smaller than root's key
        return findNode(root.leftChild,  number);

        //what if two node have the same number?

    }

    @Override
    public int[] getSortedTreeAsc() {
        return sortAsc(root);
    }

    private int[] sortAsc(Node node) {

        if (node == null) {
            return sortedArray;
        }

        /* first recur on left child */
        sortAsc(node.leftChild);

        /* then print the data of node */
        sortedArray[ascCounter]=node.number;
        ascCounter++;

        /* now recur on right child */
        sortAsc(node.rightChild);

        return sortedArray;
    }

    @Override
    public int[] getSortedTreeDesc() {
        int sortedListCounter=0;
        sortedListCounter++;
        return sortDesc(root, sortedListCounter);

    }

    private int[] sortDesc(Node node, int newCounter) {
        int[] getSortedTreeDesc= new int[counter];

        if (node == null) {
            return getSortedTreeDesc;
        }

        /* first recur on left child */
        sortDesc(node.rightChild, newCounter);

        //assign the
        getSortedTreeDesc[newCounter]=node.number;

        /* now recur on right child */
        sortDesc(node.leftChild,newCounter);

        return getSortedTreeDesc;
    }

    @Override
    public int[] sortArray(int[] arrayToSort) {
        return getSortedTreeAsc();
    }

    class Node {
        private int number;
        private Node leftChild;
        private Node rightChild;

        public Node(int number) {
            this.number = number;
            leftChild = null;
            rightChild = null;
        }

        public int getNumber() {
            return number;
        }

    }

}
