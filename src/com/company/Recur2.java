package com.company;

/*
ThinkPad is providing incredibly inconsistent results, try again on modern processor.

 */

public class Recur2 {
    public static void main(String args[]) {
        double time = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++)
            factorial(100);

        double recurTime = System.currentTimeMillis() - time;
        time = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++)
            factorialProceed(100);

        double proceedTime = System.currentTimeMillis() - time;

        System.out.println("Recur time = " + recurTime + "\nProceed time = " + proceedTime);


    }

    public static int factorial(int in) {
        if (in > 1)
            return factorial(in - 1) * in;
        return 1;
    }

    public static int factorialProceed(int in) {
        int inInit = in;
        for (int i = 1; i < inInit; i++)
            in *= i;
        return in;
    }

}
