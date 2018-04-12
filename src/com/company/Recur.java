package com.company;

public class Recur {
    public static void main(String args[]) {
        double time = System.currentTimeMillis();

        for (int i = 0; i < 100; i++)
            wRecur("WATCH");

        double recrTime = System.currentTimeMillis() - time;
        time = System.currentTimeMillis();

        for (int i = 0; i < 100; i++)
            wProceed("WATCH");

        System.out.println("Recur = " + recrTime + "\nProceed = " + (System.currentTimeMillis() - time));

    }

    static void wRecur(String s) {
        if (s.length() > 1) {
            wRecur(s.substring(0, s.length() - 1));
            System.out.println(s.substring(0, s.length() - 1));
        }
    }

    static void wProceed(String s) {
        for (int i = 1; i < s.length(); i++)
            System.out.println(s.substring(0, i));
    }
}
