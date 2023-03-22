package Commands.Graphing;

import javax.swing.JFrame;

public class graphFrame extends JFrame {
    graphPanel panel;

    graphFrame() {
        panel = new graphPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
