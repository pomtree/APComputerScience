package tom.pree;    //notice: if you are using BlueJ; comment out or delete this line or your program WILL NOT COMPILE!

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Lab10.java
 * Fulfills Lab10 insutructions
 *      a: User imputs a line of integers, prints sum
 *      b: Computer generates array of random integers, User requests index, computer returns desired value.
 *      c: trys/catches /0 errors
 * Tom Pree
 * 2/27/18
 */
public class Lab10 {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        //a(s);
        //b(s);
        c(s);
    }

    public static void c(Scanner s) {
        int i = 3;
        double a = Math.PI;
        try {
            System.out.println("Trying \"int i = 1 / 0; \"...");
            i = 1 / 0;
        } catch (ArithmeticException e) {
            System.out.println("A(n) " + e + " occured. Please enter a valid integer index value.");
        }
        try {
            System.out.println("Trying \"float a = 1/0; \"...");
            a = 1 / 0;
        } catch (ArithmeticException e) {
            System.out.println("A(n) " + e + " occured. Please enter a valid integer index value.");
        }
        System.out.println(" i = " + i);
        System.out.println(" a = " + a);

    }

    public static void b(Scanner s) {
        int array[] = new int[50];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 50) + 1;
        }
        System.out.println("What index value would you like to reveal?");
        try {
            int index = s.nextInt();
            try {
                System.out.println(array[index]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("A(n) " + e + " occured. Please enter a valid integer index value.");
            }
        } catch (InputMismatchException e) {
            System.out.println("A(n) " + e + " occured. Please enter a valid integer index value.");
        }
    }

    public static void a(Scanner s) {
        char c = 'p';
        System.out.println();
        while (c != 'q') {
            System.out.print("\nPlease enter your string of numbers:");
            String line = s.nextLine();
            StringTokenizer st = new StringTokenizer(line, " ");
            int total = 0;
            while (st.hasMoreTokens()) {
                try {
                    total += Integer.parseInt(st.nextToken());
                } catch (NumberFormatException e) {
                    //System.out.println(e);  //just print java-generated  exception
                    System.out.println("A(n) " + e + " occured. Please enter a phrase that contains only numbers next time.");
                }

            }
            System.out.println("The total is " + total + ".");
            System.out.println("Would you like to contine? Please enter 'p' to continue or 'q' to quit");
            c = s.nextLine().toLowerCase().charAt(0);
            while (c != 'p' && c != 'q') {
                System.out.println("That is not a valid option. Please enter p or q.");
                c = s.nextLine().toLowerCase().charAt(0);
            }
        }
        System.out.println("Goodbye");
    }
}
