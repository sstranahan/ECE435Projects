package com.stephenstranahan.assignment_4;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        SimpleUI mySimpleUI = new SimpleUI();

        SwingUtilities.invokeLater(mySimpleUI);
    }
}