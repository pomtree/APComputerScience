package tom.pree;

import java.util.Scanner;

public class TicTacToe {
    public static int[][] b;

    // 0 = blank, 1 = X; 2 = O;
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        b = new int[3][3];
        boolean x = true; //x (true) = x's turn
        print();
        while (hasWon() != 0) {
            if (x) {
                go(x, s);
            } else {
                go(x, s);
            }
            x = !x;
        }
    }

    public static void go(boolean x, Scanner s) {
        if (x) {
            System.out.println("It's X's turn.");
        } else System.out.println("It's O's turn.");

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
