package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        wrapper();
        //lexiLab();

    }

    private static void wrapper() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= 50; i++) {
            list.add(i);
        }
        System.out.println(list);
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            int c = list.get(i);
            if (c % 5 != 0) {
                list.remove(i);
                i--;
            } else sum += c;
        }
        System.out.println(sum);
        System.out.println(list);
    }

    /**
     *
     */
    private static void lexiLab() {
        ArrayList<String> teachers = new ArrayList<String>(), teachersCopy;
        teachers.add("Bach");
        teachers.add("Hart");
        teachers.add("Kabat");
        teachers.add("Beeson");
        teachers.add("Houge");
        teachers.add("Chan");
        teachersCopy = (ArrayList<String>) teachers.clone();
        System.out.println("Original List:" + teachers);
        for (int i = 1; i < teachers.size(); i += 2) {
            teachers.add(i, "Passing Period");
        }
        System.out.println("Now with passing periods: " + teachers);
        for (int i = teachers.size() - 2; i > 0; i -= 2) {
            teachers.remove(i);
        }
        System.out.println("Now without passing periods: " + teachers);
        lastYear(teachers);
        System.out.println("Teachers replaced with last year's: " + teachers);
        System.out.println("Formatter method: " + format(teachers));
        sort(teachersCopy);

        System.out.println("Copy of original, sorted: " + teachersCopy);
    }

    static String format(ArrayList<String> list) {
        if (list.size() >= 5) return "Second period: " + list.get(1) + "\tSixth Period: " + list.get(5);
        return "";
    }

    static void lastYear(ArrayList<String> list) {
        list.set(0, "Murphy");
        list.set(1, "Smith");
        list.set(2, "Zarate");
        list.set(3, "Soderburg");
        list.set(4, "Tobais");
        list.set(5, "Underland");
    }

    static void sort(ArrayList<String> list) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).toUpperCase().compareTo(list.get(i + 1).toUpperCase()) > 0) {
                    String swap = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, swap);
                    sorted = false;
                }
            }
        }
    }
}
