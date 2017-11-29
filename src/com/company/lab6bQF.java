package com.company;

import java.util.Scanner;

public class lab6bQF {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean go = true;
        System.out.print("*************************\n" + "**Quadratic Formula Solver**\n" + "*************************\n" + "WELCOME\n" + "Would you like to begin? (y or n): ");
        char cont = s.next().toUpperCase().charAt(0);
        if (cont == 'Y') qfContainer(s);
        else if (cont != 'N') System.out.println("Invalid selection.\n");
        else go = false;
        if (go) {
            while (cont != 'N') {
                System.out.print("\nWould you like to continue? (y or n)\n" + "Your selection: ");
                cont = s.next().toUpperCase().charAt(0);
                if (cont == 'Y') {
                    qfContainer(s);
                } else if (cont != 'N') System.out.println("Invalid selection.");
            }

        }
        System.out.println("\nThanks for solving!");

    }

    public static void qfContainer(Scanner s) {
        System.out.print("Quadratic Equation:\n" + "ax^2 + bx + c = 0\n\n" + "Enter the value for a:");
        float a = s.nextFloat();
        System.out.print("Enter a value for b: ");
        float b = s.nextFloat();
        System.out.print("Enter a value for c: ");
        float c = s.nextFloat();
        System.out.println("\nQuadratic Equation: " + pn(a) + "x^2 + " + pn(b) + "x + " + pn(c) + " = 0\n");
        qf(a, b, c);
        System.out.print("\nWould you like a graph? (y or n)\nYour selection: ");
        char cont = s.next().toUpperCase().charAt(0);
        while(cont != 'Y' && cont != 'N') {
            System.out.print("Invalid Selection, try again (y or n)\n Your selection:");
            cont = s.next().toUpperCase().charAt(0);
        }
        if(cont == 'Y') {
            qfGraph(a,b,c);
        }
        else {
            System.out.println("Thank you.");
        }

    }
    public static void qfGraph(float a, float b, float c) {
        System.out.println("\nWelcome to the graphing tool");
        char[][] g = new char[20][20];
        //for(int i = 0; i < 20; i ++)for(int j = 0; j < 20; j++)g[i][j] = ' ';
        System.out.println(gridAsString(g));
    }

    public static void qf(float a, float b, float c) {
        if (b * b - 4 * a * c >= 0) {
            float root1 = (float) ((-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a));
            float root2 = (float) ((-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a));
            if (root1 == root2) System.out.println("One real solution: x = " + root1);
            else System.out.println("Two real solutions: x = " + root1 + " and x = " + root2);

        } else System.out.println("No real solutions.");

    }


    public static String pn(float n) {
        int cast = (int) n;
        if (n % 1 == 0) return cast + "";
        else return n + "";
    }

    public static String gridAsString(char[][] g) {
        StringBuilder r = new StringBuilder();
        for (char[] aG : g) {
            for (char anAG : aG) {
                r.append(anAG);
            }
            r.append('\n');
        }
        return r.toString();
    }
}
