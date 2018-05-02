package tom.pree;

import javax.swing.*;
import java.awt.*;

public class SortVisual extends JFrame {
    static int list[];
    static int var;
    static int h, l, j;

    public SortVisual(int _list[], int _var) {
        super("Lines Drawing Demo");
        var = _var;
        list = _list;
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void cc(int _h, int _l, int _j) {
        h = _h;
        l = _l;
        j = _j;
        try {
            SwingUtilities.updateComponentTreeUI(this);
        } catch (NullPointerException e) {

        }
        try {
            Thread.sleep(25);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void drawLines(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setBackground(Color.BLUE);
        g2d.setColor(Color.BLUE);
        float thickness = this.getWidth() / list.length;
        float hieghtMod = this.getHeight() / var;
        //System.out.println("Painting method......:");
        g2d.setStroke(new BasicStroke(thickness));
        for (int i = 0; i < list.length; i++) {
            g2d.setColor(Color.BLUE);
            if (list[i] == h)
                g2d.setColor(Color.RED);
            if (list[i] == l)
                g2d.setColor(Color.GREEN);
            if (list[i] == j)
                g2d.setColor(Color.ORANGE);

            //Rectangle r = new Rectangle((int) (i * thickness), this.getHeight(), (int) (i * thickness), (int) (list[i] * hieghtMod));
            //r.setSize((int)(list[i] * hieghtMod), (int)thickness);

            g2d.drawLine((int) (i * thickness), this.getHeight(), (int) (i * thickness), (int) (list[i] * hieghtMod));

            //System.out.println("x1 = " + (int) (i * thickness) + " y1 = 0 x2 = x1 y2 = " + (int) (list[i] * hieghtMod));
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void paint(Graphics g) {
        super.paint(g);
        drawLines(g);
        cc(h, j, l);
        try {
            Thread.sleep(25);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}