package Commands.Graphing;

import java.awt.Dimension;
import java.awt.*;

import javax.swing.JPanel;

public class graphPanel extends JPanel {
    int h = 500;
    int w = 500;

    int originX = w/2;
    int originY = h/2;

    graphPanel() {
        this.setPreferredSize(new Dimension(h, w));
    }

    public void paint(Graphics g) {
        int scale = 10;

        // Creates the x and y axis
        Graphics2D g1 = (Graphics2D) g;

        g1.drawLine(0, h/2, w, h/2);
        g1.drawLine(w/2, 0, w/2, h);

        // Grabs a, b, and c, from string split
        // quadraticsGraph qG = new quadraticsGraph();
        // double a = qG.a;
        // double b = qG.b;
        // double c = qG.c;
        double a = 5;
        double b = -7;
        double c = -2;

        // Draws function
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.red);

        Polygon p1 = new Polygon();
        for (int x = -250; x <= 250; x++) {
            p1.addPoint(originX + x*scale, originY - scale * ((int) Math.round(a*(x*x)+b*x+c)));
          }
          
        g2.drawPolyline(p1.xpoints, p1.ypoints, p1.npoints);
    }
}
