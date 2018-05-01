package tom.pree;

import javax.swing.*;
import java.awt.*;

public class Processing3 extends JFrame {
    public int width;
    public int height;
    public Graphics2D g2d;
    public int list[];

    public Processing3() {
        super("Untitled Frame");
        g2d = (Graphics2D) super.getGraphics();
    }

    public Processing3(String title) {
        super(title);
        g2d = (Graphics2D) super.getGraphics();
    }

    public Processing3(String title, int _width, int _height) {
        super(title);
        width = _width;
        height = _height;
        super.setSize(width, height);
        super.setVisible(true);
        g2d = (Graphics2D) super.getGraphics();

    }

    public void line(int x1, int y1, int x2, int y2) {
        g2d.drawLine(x1, y1, x2, y2);
        g2d.setBackground(new Color(1, 2, 2));
    }

    public void background(int grayscale) {
        g2d.setBackground(new Color(grayscale));
    }

    public void background(int r, int g, int b) {
        g2d.setBackground(new Color(r, g, b));
    }

    public void paint(Graphics g) {
        super.paint(g);
        visulize();
        line(0, 0, 100, 100);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setList(int _list[]) {
        list = _list;
    }

    public void visulize() {
        int l = 0;
        try {
            l = list.length;
        } catch (NullPointerException e) {
            System.out.println("npe");
        }
        for (int i = 0; i < l; i++) {
            int x = i * list.length / width;
            line(x, 0, x, (list[i]));
            System.out.println(x + " " + list[i]);
        }
    }
}
