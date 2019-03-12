import com.sun.jdi.ByteType;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainWindow extends JFrame implements  ActionListener{

    private JButton click;
    private JFrame frame;
    private JPanel panel;

    public MainWindow() {

        frame = new JFrame("Uciekający przycisk");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        panel = new JPanel();
        panel.setBackground(Color.BLACK);
        frame.add(panel);
        click = new JButton("Naciśnij mnie!");
        click.addActionListener(this);
        panel.add(click);
    }

    public void actionPerformed(ActionEvent e) {
        Random ran = new Random();
        int x = ran.nextInt(400) + 5;
        int y = ran.nextInt(400) + 5;
        if (e.getSource() == click) {
            click.setLocation(x,y);
        }
    }

    public static void main(String[] args) {
        MainWindow n = new MainWindow();
    }
}

