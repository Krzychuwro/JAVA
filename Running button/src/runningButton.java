import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import static java.lang.StrictMath.abs;

public class runningButton extends JFrame implements ActionListener {
    private JButton button;
    private JFrame frame;
    private JPanel panel;

    double currentPosX = 200;
    double currentPosY = 0;

    boolean move = false;

    public runningButton() {

        frame = new JFrame ("Running button!");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);

        panel = new JPanel();
        panel.setBackground(Color.BLACK);
        button = new JButton("Click me!");
        button.addActionListener(this);

        frame.add(panel);
        panel.add(button);
        button.setLocation((int)currentPosX, (int)currentPosY);
    }

   public void buttonMove() {
        Random ran = new Random();
        int nextPosX = ran.nextInt(400);
        int nextPosY = ran.nextInt(400);
        double jumpX = abs(currentPosX - nextPosX) / 100;
        double jumpY = abs(currentPosY - nextPosY) / 100;

        move = true;

        Timer buttonAnimation = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                button.setLocation((int)((currentPosX<nextPosX)?(currentPosX+=jumpX):(currentPosX-=jumpX)),
                        (int)((currentPosY<nextPosY)?(currentPosY+=jumpY):(currentPosY-=jumpY)));

                if(abs(currentPosX - nextPosX) < jumpX )
                {
                    move = false;
                    button.setLocation(nextPosX, nextPosY);
                    cancel();
                }
            }
        };
        buttonAnimation.scheduleAtFixedRate(task, 5, 5);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button && !move) {
            buttonMove();
        }
    }

    public static void main(String[] args) {
        runningButton run = new runningButton();
    }
}
