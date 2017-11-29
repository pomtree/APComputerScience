package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello Java");
        JLabel label = new JLabel("Hello, Java", JLabel.CENTER);
        frame.add(label);
        frame.setSize(300,300);
        label.setText("help");
        frame.setVisible(true);
    }

}
