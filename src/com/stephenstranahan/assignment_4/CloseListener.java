package com.stephenstranahan.assignment_4;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class CloseListener implements MouseListener {

    public JButton b1;

    public CloseListener(JButton b1) {
        this.b1 = b1;
    }



    @Override
    public void mouseClicked(MouseEvent e) {
        System.exit(0);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.exit(0);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }
}