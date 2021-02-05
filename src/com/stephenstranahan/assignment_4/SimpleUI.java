package com.stephenstranahan.assignment_4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.WindowConstants;

public class SimpleUI implements Runnable {

    public void run() {

        //Frame that contains all GUI components------------------------
        JFrame myFrame = new JFrame("GUI Example");
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myFrame.setPreferredSize(new Dimension(800, 300));
        myFrame.getContentPane().setBackground(new Color(0, 0, 0));
        myFrame.pack();
        myFrame.setVisible(true);

        //Layout that manages placements of components-----------------
        GridLayout myGridLayout = new GridLayout(1, 3, 10, 10);
        myFrame.setLayout(myGridLayout);

        //GUI components ----------------------------------------------

        //JLabel
        JLabel myLabel = new JLabel("hi there!");
        Font myFont = new Font("Courier New", Font.BOLD, 36);
        myLabel.setFont(myFont);
        myLabel.setForeground(new Color(255, 255, 255));
        myFrame.add(myLabel);

        //JButton
        JButton myButton = new JButton("Click Me!");
        myFrame.add(myButton);

        //JSlider
        JSlider mySlider = new JSlider(JSlider.HORIZONTAL,0, 100, 5);
        myFrame.add(mySlider);

        //etc.

        //Event Handlers-----------------------------------------------

        //Button click event
        MyMouseListener myMouseListener = new MyMouseListener();
        myButton.addMouseListener(myMouseListener);

        //Slider change event
        MyChangeListener myChangeListener = new MyChangeListener();
        mySlider.addChangeListener(myChangeListener);
    }
} //MainUI class
