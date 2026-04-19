package Swings;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ButtonExample2 {

    JLabel l1;

    ButtonExample2() {
        JFrame f = new JFrame("Image Button Example");

        // Label
        l1 = new JLabel();
        l1.setBounds(50, 30, 400, 50);
        l1.setFont(new Font("Arial", Font.BOLD, 18));

        // Load Images (make sure images are in project folder)
        ImageIcon digitalIcon = new ImageIcon("digital.png");
        ImageIcon hourglassIcon = new ImageIcon("hourglass.png");

        // Buttons with images
        JButton b1 = new JButton(digitalIcon);
        JButton b2 = new JButton(hourglassIcon);

        b1.setBounds(50, 100, 150, 150);
        b2.setBounds(250, 100, 150, 150);

        // Action for Digital Clock button
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                l1.setText("Digital Clock is pressed");
            }
        });

        // Action for Hour Glass button
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                l1.setText("Hour Glass is pressed");
            }
        });

        // Add components
        f.add(b1);
        f.add(b2);
        f.add(l1);

        f.setSize(500, 350);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ButtonExample2();
    }
}