package com.company;
/*
lab6QF.java
A program to solve quadratic eautions, incuding graphing functionallity.
by Tom Pree
12/1

Tcodo:
parse floats becuase we havnt learned that
finish float grabber
graph better
linear eqations

 */


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
        char exp = (char) 131250;
        System.out.print("Quadratic Equation:\n" + "ax" + exp + " + bx + c = 0\n\n");
        System.out.print("Enter the value for a:");
        float a = getFloat(s);
        System.out.print("Enter a value for b: ");
        float b = getFloat(s);
        System.out.print("Enter a value for c: ");
        float c = getFloat(s);
        System.out.println("\nQuadratic Equation: " + pn(a) + "x" + exp + " + " + pn(b) + "x + " + pn(c) + " = 0\n");
        qf(a, b, c);
        System.out.print("\nWould you like a graph? (y or n)\nYour selection: ");
        char cont = s.next().toUpperCase().charAt(0);
        while (cont != 'Y' && cont != 'N') {
            System.out.print("Invalid Selection, try again (y or n)\n Your selection:");
            cont = s.next().toUpperCase().charAt(0);
        }
        if (cont == 'Y') {
            qfGraphL(a, b, c);
        } else {
            System.out.println("Thank you.");
        }

    }

    private static float getFloat(Scanner s) {
        String str, n = ".0123456789";
        boolean clear;
        while (true) {
            System.out.println(" ");
            str = s.next();
            clear = true;
            //System.out.println("str = " + str);
            if (str.length() > 1 && !(n + "-+").contains(str.charAt(0) + "")) {
                clear = false;
            }
            if (str.length() == 1 && (str.contains("-") || str.contains("+"))) {
                clear = false;
            }
            for (int i = 1; i < str.length(); i++) {
                if (!n.contains(str.charAt(i) + "")) {
                    clear = false;
                }
                if (str.charAt(i) == '.') {
                    n = n.substring(1);
                }
            }
            if (clear && str.length() > 0) {
                return tomParse(str);
            } else {
                System.out.println("Not a number, try again");
            }
        }
    }

    private static float tomParse(String str) {
        //String backup = str;
        float out = 0;
        int isNegative = 1; // 0 means not found (postive) , 1 is postive, 0 is negative
        if (str.charAt(0) == '-') {
            isNegative = -1;
            str = str.substring(1);
        } else if (str.charAt(0) == '+') {
            isNegative = 1;
            str = str.substring(1);
        }
        if (str.indexOf('.') == -1) {
            str += '.';
        }
        int i;
        int d = str.indexOf('.');
        boolean dCheck = false;
        while (str.length() > 0) {
            d--;
            if (!dCheck && d == -1) {
                d++;
                dCheck = true;
            }
            //System.out.println(str + " and d = " + d);
            if (str.charAt(0) == '0') {
                i = 0;
            } else if (str.charAt(0) == '1') {
                i = 1;
            } else if (str.charAt(0) == '2') {
                i = 2;
            } else if (str.charAt(0) == '3') {
                i = 3;
            } else if (str.charAt(0) == '4') {
                i = 4;
            } else if (str.charAt(0) == '5') {
                i = 5;
            } else if (str.charAt(0) == '6') {
                i = 6;
            } else if (str.charAt(0) == '7') {
                i = 7;
            } else if (str.charAt(0) == '8') {
                i = 8;
            } else if (str.charAt(0) == '9') {
                i = 9;
            } else {
                i = -1;
            }
            if (i != -1) {
                out += (i * Math.pow(10, d));
                //System.out.println(out);
            }
            str = str.substring(1);
        }
        out *= isNegative;
        return out;
    }

    private static void qfGraphL(float a, float b, float c) {
        System.out.println("\nWelcome to the graphing tool");
        String graph = "";
        //for(int i = 0; i < 20; i++) {
        //    for(int j = 0; j < 20; j++) {
        //        graph += " ";
        //    }
        //    graph +='\n';
        //}
        float vertex1 = (-b / 2 * a);
        float vertex2 = (a * vertex1 * vertex1 + b * vertex1 + c);
        System.out.println("Vertex at " + vertex1 + ',' + vertex2);
        graph = graphGo(graph, a, b, c, (int) vertex1, (int) vertex2);
        System.out.println(graph);
    }

    private static String graphGo(String graph, float a, float b, float c, int vx, int vy) {
        for (int y = vy - 20; y < vy + 20; y++) {
            for (int x = vx - 20; x < vx + 20; x++) {
                if (y == (int) (-a * x * x + b * x + c)) {
                    graph += 'x';
                } else if (x == 0 && y == 0) {
                    graph += '+';
                } else if (x == 0) {
                    graph += '|';
                } else if (y == 0) {
                    graph += '-';
                } else {
                    graph += ' ';
                }
            }
            graph += '\n';
        }
        return graph;
    }

    private static String graphGo(String graph, float a, float b, float c) {
        for (int y = -20; y < 20; y++) {
            for (int x = -20; x < 20; x++) {
                if (y == (int) (-a * x * x + b * x + c)) {
                    graph += 'x';
                } else if (x == 0 && y == 0) {
                    graph += '+';
                } else if (x == 0) {
                    graph += '|';
                } else if (y == 0) {
                    graph += '-';
                } else {
                    graph += ' ';
                }
            }
            graph += '\n';
        }
        return graph;
    }

    /*

    //obsolete because I did something even better

    private static float qf(float a, float b, float c, boolean plus) {

        if (plus) {
            System.out.print(Math.round(((-b + Math.sqrt(b * b - 4 * a * c)) / 2.0 * a)) + " ");
            return Math.round(((-b + Math.sqrt(b * b - 4 * a * c)) / 2.0 * a));

        }
        System.out.print(Math.round(((-b - Math.sqrt(b * b - 4 * a * c)) / 2.0 * a)) + " ");
        return Math.round((-b - Math.sqrt(b * b - 4 * a * c)) / 2.0 * a);


    }
    */

    private static void qf(float a, float b, float c) {
        if (((b * b) - (4 * a * c)) >= 0) {
            float root1 = (float) ((-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a));
            float root2 = (float) ((-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a));
            if (root1 == root2) {
                System.out.println("One real solution: x = " + root1);
            } else {
                System.out.println("Two real solutions: x = " + root1 + " and x = " + root2);
            }
        } else {
            System.out.println("No real solutions.");
            float root1 = (float) ((-b + Math.sqrt(Math.abs(b * b - 4 * a * c))) / (2 * a));
            float root2 = (float) ((-b - Math.sqrt(Math.abs(b * b - 4 * a * c))) / (2 * a));
            System.out.println("Two imaginary solutions: " + root1 + "i and " + root2 + "i.");
        }
    }

    private static String pn(float n) {
        int cast = (int) n;
        if (n % 1 == 0) {
            return cast + "";
        } else {
            return n + "";
        }
    }
/*

    //The following code works, however it uses matieral not yet covered in class so I thought it best to leave out

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

    private static char[][] basicGridGen2(float a, float b, float c, char[][] g) {
        for (int y = -10; y < g.length - 10; y++) {
            for (int x = -10; x < g[y + 10].length - 10; x++) {
                g[9 - y][x + 10] = ' ';
                if (qf(a, b, c, true) == x || qf(a, b, c, false) == x) {
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
    */
}
