package InClassAssigment_20210209;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static InClassAssigment_20210209.PasswordChecker.checkPassword;

public class SubmitListener implements MouseListener {

    public JButton submit;
    public static boolean correctPW = false;
    public JTextArea tb;
    public JPasswordField passwordField;

    public SubmitListener(JButton submit, JTextArea tb, JPasswordField passwordField) {
        this.submit = submit;
        this.tb = tb;
        this.passwordField = passwordField;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String pw = passwordField.getText();
        correctPW = checkPassword(tb, pw);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        String pw = passwordField.getText();
        correctPW = checkPassword(tb, pw);
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
