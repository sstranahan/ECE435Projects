package InClassAssigment_20210209;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {

    public JLabel label;
    public ImageIcon i1;
    public ImageIcon i2;
    public ImageIcon i3;
    public ImageIcon i4;
    public JFrame frame;

    public MyKeyListener(JLabel label, ImageIcon i1, ImageIcon i2, ImageIcon i3, ImageIcon i4, JFrame frame) {
        this.label = label;
        this.i1 = i1;
        this.i2 = i2;
        this.i3 = i3;
        this.i4 = i4;
        this.frame = frame;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        int n = 1;
        char key = e.getKeyChar();

        //       if (SubmitListener.correctPW == true) {
        if (key == 'a') {
            n--;
            if (n == 0)
                n = 4;
        }

        if (key == 'd') {
            n++;
            if (n == 5)
                n = 1;
        }

        if (key == ' ') {
            n = 1;
        }

        switch (n) {
            case 1:
                label.setIcon(i1);
                break;
            case 2:
                label.setIcon(i2);
                break;
            case 3:
                label.setIcon(i3);
                break;
            case 4:
                label.setIcon(i4);
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int n = 1;
        char key = e.getKeyChar();

 //       if (SubmitListener.correctPW == true) {
    if (key == 'a') {
        n--;
        if (n == 0)
            n = 4;
    }

    if (key == 'd') {
        n++;
        if (n == 5)
            n = 1;
    }

    if (key == ' ') {
        n = 1;
    }

    switch (n) {
        case 1:
            label.setIcon(i1);
            break;
        case 2:
            label.setIcon(i2);
            break;
        case 3:
            label.setIcon(i3);
            break;
        case 4:
            label.setIcon(i4);
            break;
            }
        }
//    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
