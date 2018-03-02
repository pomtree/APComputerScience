package com.company;

//demo timer:
/*
long startTime = System.nanoTime();
methodToTime();
long endTime = System.nanoTime();

long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
 */


public class Sorter {
    protected static int[] array;
    static int[] arraySortMe;
    static int array_size;

    public static void main(String args[]) {
        //quicksort testing
        init();
        array_size = 500;

        print();

        //  for(int testCase = 0; testCase < 10; testCase++) {
        //      array_size = 50000; //desired length of arrays to sort here
        //      System.out.println("\nTest case " + testCase + ". Sorting an array of " + array_size + " int values from 0 to " + array_size);
        //      init();
        //      long startTime = System.nanoTime();
        //      swapSort(arraySortMe);
        //      long endTime = System.nanoTime();
        //      float duration = ((endTime - startTime) / 1000000);
        //      System.out.println("Swap sorted in " + duration / 1000.0 + " seconds.");
        //      reset();
        //      startTime = System.nanoTime();
        //      insertionSort(arraySortMe);
        //      endTime = System.nanoTime();
        //      duration = ((endTime - startTime) / 1000000);
        //      System.out.println("Insertion sorted in " + duration / 1000.0 + " seconds.");
        //  }
    }

    static void insertionSort(int[] arr) {
        //System.out.println("Insertion sorting...");
        for (int i = 1; i < arr.length; i++) {
            insertionSortHelper1(i, arr);
        }
        //System.out.println("Insertion sort successful.");
    }

    public static void swapSort(int[] list) {
        //System.out.println("Now swap sorting...");
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < list.length - 1; i++) {
                if (list[i] > list[i + 1]) {
                    sorted = false;
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                }
            }
            if (sorted) {
                //System.out.print("Swap sort successful.");
                return;
            }
        }
    }

    public static void init() {
        array = new int[array_size];
        for (int i = 0; i < array_size; i++) {
            array[i] = (int) (Math.random() * array_size + 1);
        }
        arraySortMe = array.clone();
    }

    public static void print() {
        System.out.print("\nOriginal Array:\n");
        for (int i : array) System.out.print(i + " ");
        System.out.print("\nSorted Array:\n");
        for (int i : arraySortMe) System.out.print(i + " ");
    }

    public static void reset() {
        arraySortMe = array.clone();
    }

    private static void insertionSortHelper1(int pos, int[] a) {
        int value = a[pos], i;
        //System.out.println("value: " + value);
        for (i = pos; i > 0; i--) {
            a[i] = a[i - 1];
            if (value > a[i]) break;
            //for(int j : a)System.out.print(j + " ");
            //System.out.println();
        }
        a[i] = value;
        //for(int j : a)System.out.print(j + " ");
        //System.out.println();

    }

    static int partition(int arr[], int left, int right) {
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2];
        while (i <= j) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }

        return i;
    }//copied from http://www.algolist.net/Algorithms/Sorting/Quicksort

    static void quickSort(int arr[], int left, int right) {        //coped from http://www.algolist.net/Algorithms/Sorting/Quicksort
        int index = partition(arr, left, right);
        if (left < index - 1)
            quickSort(arr, left, index - 1);
        if (index < right)
            quickSort(arr, index, right);
    } //copied from http://www.algolist.net/Algorithms/Sorting/Quicksort
}
