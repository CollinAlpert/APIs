import de.collin.ObservableList;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {


    private Main() {
        this.setLayout(new BorderLayout());

        JTextBox box = new JTextBox("E-Mail", true);
        box.setPreferredSize(new Dimension(150, 25));
        JPanel pan = new JPanel();
        pan.add(box);

        JPanel pan2 = new JPanel();
        JButton b = new JButton("Click me");
        b.addActionListener(e -> System.out.println(box.getText()));
        pan2.add(b);

        this.add(pan, BorderLayout.NORTH);
        this.add(pan2, BorderLayout.SOUTH);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new Main();
    }
}
