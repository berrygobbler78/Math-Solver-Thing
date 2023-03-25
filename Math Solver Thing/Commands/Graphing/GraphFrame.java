package Commands.Graphing;

import javax.swing.JFrame;

public class GraphFrame extends JFrame {
    GraphPanel panel;

    GraphFrame() {
        panel = new GraphPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
