package com.company;

import java.util.ArrayList;

public class Tominizer {
    ArrayList l;

    public Tominizer(String in) {
        l = new ArrayList();
        String arr[] = in.split(" ");
        for (int i = 0; i < arr.length; i++) {
            l.add(arr[i]);
        }
    }

    public int countToms() {
        return l.size();
    }

    public String nextTom(boolean ri) {
        String r = (String) l.get(0);
        if (ri) l.remove(0);
        return r;
    }

    public String nextTom() {
        String r = (String) l.get(0);
        l.remove(0);
        return r;
    }

    public boolean hasMoreToms() {
        if (countToms() > 0) return true;
        return false;
    }


}
