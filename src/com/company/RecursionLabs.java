package com.company;

public class RecursionLabs {
    public static void main(String args[]) {
        writeBinary(44);
        System.out.println();
        backwards("Thomas");
    }

    private static void backwards(String str) {
        if (str.length() > 0) {
            System.out.print(str.charAt(str.length() - 1));
            backwards(str.substring(0, str.length() - 1));
        }
    }

    private static void writeBinary(int i) {
        if (i > 0) {
            writeBinary(i / 2);
            System.out.print(i % 2);
        }
    }
}
