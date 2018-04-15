package tom.pree;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
    public static int[][] b;
    static boolean firstRun;

    // 0 = blank, 1 = X; 2 = O;
    public static void main(String args[]) {
        firstRun = true;
        driver();
        System.out.println("Goodbye");
    }

    public static void driver() {
        if (!firstRun) System.out.println("\n\n\n\n\n\n");
        System.out.println("Welcome to TicTacToe!");
        Scanner s = new Scanner(System.in);
        b = new int[3][3];
        boolean x = true; //x (true) = x's turn
        //print();
        while (hasWon() == 0) {
            if (x) {
                go(x, s);
            } else {
                go(x, s);
            }
            x = !x;
        }
        if (hasWon() == 1) System.out.println("X's has won!!");
        else System.out.println("O's have won!");
        System.out.print("Would you like to play again? (y or n): ");
        char c = (s.nextLine().toUpperCase() + " ").charAt(0);
        if (c == 'Y') {
            driver();
        }
    }

    public static void go(boolean x, Scanner s) {
        if (!firstRun) System.out.println("\n\n\n");
        print();
        if (x) {
            System.out.println("It's X's turn.");
        } else {
            System.out.println("It's O's turn.");
        }
        int[] coord = getPos(s);
        if (x) {
            b[coord[0]][coord[1]] = 1;
        } else {
            b[coord[0]][coord[1]] = 2;
        }
    }

    public static int[] getPos(Scanner s) {
        int row = -1;
        while (row == -1) {
            System.out.print("Enter your desired row: ");
            try {
                row = s.nextInt();
                if (row > 3 || row < 1) {
                    throw new InputMismatchException();
                }
                //System.out.println(row);
            } catch (InputMismatchException e) {
                System.out.println("You entered an invalid row, please try again. (1-3)");
                row = -1;
            }
        }
        int col = -1;
        while (col == -1) {
            System.out.print("Enter your desired column: ");
            if (!firstRun) s.nextLine();
            else firstRun = false;
            try {
                col = s.nextInt();
                if (col > 3 || col < 1) {
                    throw new InputMismatchException();
                }
                //System.out.println(col);
            } catch (InputMismatchException e) {
                System.out.println("You entered an invalid column, please try again. (1-3)");
                col = -1;
            }
        }
        row--;
        col--;
        if (b[row][col] != 0) {
            System.out.println("Sorry, that spot is taken. Try again.");
            return getPos(s);
        }

        System.out.print("You entered " + (row + 1) + "," + (col + 1) + ". Is this OK?( y or n): ");
        s.nextLine();
        char c = (s.nextLine().toUpperCase() + " ").charAt(0);
        if (c != 'Y') {
            return getPos(s);
        }

        return new int[]{row, col};
    }


    public static void print() {
        char[] l = {' ', 'X', 'O'};
        System.out.println(l[b[0][0]] + "|" + l[b[0][1]] + "|" + l[b[0][2]]);
        System.out.println("-+-+-");
        System.out.println(l[b[1][0]] + "|" + l[b[1][1]] + "|" + l[b[1][2]]);
        System.out.println("-+-+-");
        System.out.println(l[b[2][0]] + "|" + l[b[2][1]] + "|" + l[b[2][2]]);
    }

    public static int hasWon() {
        for (int row = 0; row < 3; row++) {
            if (b[row][0] != 0 && (b[row][0] == b[row][1] && b[row][0] == b[row][2])) {
                return b[row][0];
            }
            if (b[0][row] != 0 && (b[0][row] == b[1][row] && b[0][row] == b[2][row])) {
                return b[0][row];
            }
        }

        return 0;
    }
}