package com.company;

import java.io.InputStream;
import java.util.Scanner;

public class theParty {
    public static void main(String args[]) throws InterruptedException {
        System.out.println("There are 1000 people coming to the party, but one of them is out to get you.\n" +
                "heres how you'll find them: Each tribute will drink the following bottles. The next day, you can tell" +
                "who brought the posinging by entering which tributes died:");
        drink();
        System.out.println("\n\nthat was A LOT of drinking, now that everyone has drank their soda, wait a day.");
        sleep();
        System.out.println("\nGood Morning, excited to not get poisoned today???");
        int ctd = collectTheDead();
        catchTheKiller(ctd);
    }

    public static void sleep() throws InterruptedException {
        String[] t = {
                "🕜", "🕑", "🕝", "🕒", "🕞", "🕓", "🕟", "🕔", "🕠", "🕕", "🕡", "🕖", "🕢", "🕗", "🕣", "🕘", "🕤", "🕙", "🕥", "🕚", "🕦", "🕛", "🕧"};
        for (int i = 0; i < 22; i++) {
            System.out.print(t[i]);
            Thread.sleep((long) (250));
        }
    }

    public static void catchTheKiller(int d) {
        int i;
        for (i = 0; i <= 1000; i++) {
            if (intToBin(i) == d) {
                break;
            }
        }
        if (i != 1001) {
            System.out.println("We found the killer! It was your \"friend\" who gave you bottle #" + i + "!\n" +
                    "Well, I'm happy I could help save your party.");
        } else {
            System.out.println("Hmmmm.... something very fishy is going on here.... There could be: No poisoned bottles, or multiple poisoned bottles," +
                    "so good luck, and sleep easy");
        }
    }

    public static int collectTheDead() {
        InputStream is = System.in;
        Scanner s = new Scanner(is);
        int out = 0;
        System.out.println("Well, chances are high (99.9%) that at least one of your tributes have perished." +
                "Well, I hope you were expecting that... Anyways, which ones are dead today?");
        for (int i = 1; i <= 10; i++) {
            System.out.println("Did tribute " + i + " make it? (yes or no)");
            String in = s.next().toLowerCase();
            if (in.contains("n") || in.contains("o")) {
                out *= 10;
                out++;
            } else {
                out *= 10;
            }
        }

        //System.out.println(out);
        return out;

    }

    public static void drink() {
        for (int bottle = 1; bottle <= 1000; bottle++) {
            int code = intToBin(bottle);
            String sc = " " + code;
            System.out.println("\nBOTTLE NUMBER " + bottle + " code = " + code);
            for (int trib = 1; trib <= 10; trib++) {

                if (!sc.equals("") && sc.length() > trib && sc.charAt(trib) == '1') {
                    System.out.print("Tribute " + trib + " should drink bottle " + bottle + ". \n");
                } else {
                    System.out.print("Tribute " + trib + " should not drink bottle " + bottle + ". \n");
                }
            }
        }
    }

    public static int intToBin(int dec) {
        int ib = 0;
        for (int i = 11; i >= 0; i--) {
            if (dec >= Math.pow(2, i)) {
                ib *= 10;
                ib++;
                dec -= Math.pow(2, i);
            } else {
                ib *= 10;
            }
        }
        return ib;
    }
}
