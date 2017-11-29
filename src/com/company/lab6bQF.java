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

    private static void qfContainer(Scanner s) {
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
        while (cont != 'Y' && cont != 'N') {
            System.out.print("Invalid Selection, try again (y or n)\n Your selection:");
            cont = s.next().toUpperCase().charAt(0);
        }
        if (cont == 'Y') {
            qfGraph(a, b, c);
        } else {
            System.out.println("Thank you.");
        }

    }

    private static void qfGraph(float a, float b, float c) {
        System.out.println("\nWelcome to the graphing tool");
        char[][] g = new char[20][20];
        float vertex[] = new float[3];
        vertex[1] = (-b / 2 * a);
        vertex[2] = (a * vertex[1] * vertex[1] + b * vertex[1] + c);
        System.out.println("Vertex at " + vertex[1] + ',' + vertex[2]);
        g = basicGridGen(a, b, c, g);
        //for(int i = 0; i < 20; i ++)for(int j = 0; j < 20; j++)g[i][j] = ' ';
        System.out.println(gridAsString(g));
    }

    private static char[][] basicGridGen(float a, float b, float c, char[][] g) {
        for (int y = -10; y < g.length - 10; y++) {
            for (int x = -10; x < g[y + 10].length - 10; x++) {
                g[9 - y][x + 10] = ' ';
                if (y == a * x * x + b * x + c) {
                    g[9 - y][x + 10] = 'x';
                } else {
                    if (x == 0 && y == 0) {
                        g[9 - y][x + 10] = '+';
                    } else if (x == 0) {
                        g[9 - y][x + 10] = '|';
                    } else if (y == 0) {
                        g[9 - y][x + 10] = '-';
                    }

                }
            }
        }

        return g;
    }

    private static void qf(float a, float b, float c) {
        if (b * b - 4 * a * c >= 0) {
            float root1 = (float) ((-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a));
            float root2 = (float) ((-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a));
            if (root1 == root2) System.out.println("One real solution: x = " + root1);
            else System.out.println("Two real solutions: x = " + root1 + " and x = " + root2);

        } else System.out.println("No real solutions.");

    }


    private static String pn(float n) {
        int cast = (int) n;
        if (n % 1 == 0) return cast + "";
        else return n + "";
    }

    private static String gridAsString(char[][] g) {
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
