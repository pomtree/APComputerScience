package tom.pree;

/**
 * By Tom Pree, psedocode by Rajat Mishra at GeeksForGeeks.org
 */
public class QuickSort {
    private static Processing3 p3;
    private static int list[];

    public static void main(String args[]) {
        init();
        printToConsole();
        sort();
        printToConsole();

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

    static void printToConsole() {
        System.out.println();
        for (int i : list)
            System.out.print(i + " ");
    }

    static void draw() {

    }

    static void init() {
        p3 = new Processing3("Hello friends!", 500, 500);
        list = new int[500];
        for (int i = 0; i < list.length; i++)
            list[i] = (int) (Math.random() * list.length);

    }
}