package com.company;

public class CodeBatRecursion {//9 = 21

    public static void main(String args[]) {
        writeBinary(44);// 44 = 101100 -> 0101100
        //                       0011010
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


    private static int countx(String s) {
        if (s.length() > 0 && s.charAt(0) == 'x')
            return 1 + countx(s.substring(1));
        if (s.length() > 0)
            return countx(s.substring(1));
        return 0;
    }

    private static int count7(int i) {
        if (i % 10 == 7)
            return 1 + count7(i / 10);
        if (i > 0)
            return count7(i / 10);
        return 0;
    }

    private static int fibonacci(int i) {
        if (i <= 3)
            return 1;
        return fibonacci(i - 1) + fibonacci(i - 2);
    }

    private static int bunnyEars2(int i) {
        if (i > 0) return 3 - i % 2 + bunnyEars2(i - 1);
        return 0;
    }
}
