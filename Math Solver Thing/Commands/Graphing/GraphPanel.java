package Commands.Graphing;

import java.awt.Dimension;
import java.awt.*;

import javax.swing.JPanel;

public class GraphPanel extends JPanel {
    int h = 500;
    int w = 500;

    int originX = w/2;
    int originY = h/2;

    GraphPanel() {
        this.setPreferredSize(new Dimension(h, w));
    }

    public void paintComponent(Graphics g) {
        double scale = 10;

        // Creates the x and y axis
        Graphics2D g1 = (Graphics2D) g;

        g1.drawLine(0, h/2, w, h/2);
        g1.drawLine(w/2, 0, w/2, h);

        // Grabs a, b, and c, from string split
        QuadraticsGraph qG = new QuadraticsGraph();
        double a = qG.a;
        double b = qG.b;
        double c = qG.c;

        // Draws function
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.red);

        Polygon p1 = new Polygon();
        for (double x = -w; x <= w; x += 0.1) {
            p1.addPoint((int) Math.round(originX + x*scale), (int)Math.round(originY - scale * (a*(x*x)+b*x+c)));
        }
          
        g2.drawPolyline(p1.xpoints, p1.ypoints, p1.npoints);
    }
}
