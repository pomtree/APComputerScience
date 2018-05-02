package tom.pree;

import java.util.Scanner;

public class QuickSort2 {
    static int list[];
    static int variation;
    static SortVisual f;

    public static void main(String args[]) {
        System.out.println("Hello, welcome to QuickSort");

        Scanner s = new Scanner(System.in);
        System.out.println("How many items would you like in your array?");
        int size = s.nextInt();
        list = new int[size];
        System.out.println("What is the minimum value you would like in your array?");
        int min = s.nextInt();
        System.out.println("What is the maximum value you would like in your array?");
        int max = s.nextInt();
        for (int i = 0; i < list.length; i++) {
            list[i] = min + (int) (Math.random() * (max - min));
        }
        variation = max - min;
        System.out.println("Alright, here is your randomly generated array");
        printArr();
        System.out.println("We will now start the visualization and sorting progress...");
        //System.out.println("Painted");
        //SwingUtilities.invokeLater(() -> new LinesDrawingExample(list, variation).setVisible(true));
        f = new SortVisual(list, variation);
        f.setVisible(true);
        System.out.println("Ready?? Enter 0 to continue");
        s.nextInt();
        sort();
        System.out.println("Sorted.");
        f.setVisible(false);
        main(null);
    }

    static void printArr() {
        System.out.println();
        System.out.print("[");
        for (int i = 0; i < list.length - 1; i++)
            System.out.print(list[i] + ", ");
        System.out.print(list[list.length - 1] + "]");
        System.out.println();

    }

    static int part(int l, int h) {
        int pivot = list[h];
        int i = l - 1;
        for (int j = l; j < h; j++) {
            if (list[j] <= pivot) {
                i++;
                int temp = list[i];
                list[i] = list[j];
                list[j] = temp;
            }

            f.cc(h, l, j);
        }
        int temp = list[i + 1];
        list[i + 1] = list[h];
        list[h] = temp;
        return i + 1;
    }

    static void sort(int l, int h) {
        if (l < h) {
            int p = part(l, h);
            sort(l, p - 1);
            sort(p + 1, h);
        }
    }

    static void sort() {
        sort(0, list.length - 1);
    }


}
