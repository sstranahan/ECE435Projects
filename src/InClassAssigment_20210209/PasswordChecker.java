package InClassAssigment_20210209;

import javax.swing.*;

public class PasswordChecker {

    public static final String CORRECT_PW = "password";

    public static boolean checkPassword(JTextArea tb, String pw) {
        if (pw.equals(CORRECT_PW)) {
            tb.setText("Correct password. Unlocking functionality.");
            return true;
        } else {
            tb.setText("Incorrect password. Try again.");
            return false;
        }
    }
}
