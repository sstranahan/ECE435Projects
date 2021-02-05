package com.stephenstranahan.assignment_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SubmitListener implements MouseListener {

    public JButton b1;
    public JTextArea printArea;
    public JTextField tf1, tf2, tf3;
    public JPasswordField pw;
    String printStr = "";

    public SubmitListener(JButton b1, JTextArea printArea, JTextField tf1, JTextField tf2, JTextField tf3, JPasswordField pw) {
        this.b1 = b1;
        this.printArea = printArea;
        this.tf1 = tf1;
        this.tf2 = tf2;
        this.tf3 = tf3;
        this.pw = pw;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        printStr = "First Name: " + tf1.getText() + "\n" +
                "Last Name: " + tf2.getText() + "\n" +
                "Username: " + tf3.getText() + "\n" +
                "Password: " + pw.getText() + "\n";

        printArea.setText(printStr);

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
