package com.stephenstranahan.assignment_5_2;

import com.stephenstranahan.assignment_5_2.GUI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        GUI myGUI = new GUI();

        SwingUtilities.invokeLater(myGUI);
    }
}
