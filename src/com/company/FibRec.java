package com.company;

public class FibRec {//9 = 21

    public static void main(String args[]) {
        System.out.println(fib(9));
    }

    private static int fib(int i) {
        if (i <= 3)
            return 1;
        return fib(i - 1) + fib(i - 2);
    }
}
