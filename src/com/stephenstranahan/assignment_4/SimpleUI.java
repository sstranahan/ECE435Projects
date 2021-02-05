package com.stephenstranahan.assignment_4;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;


public class SimpleUI implements Runnable {

    public void run() {

        //Frame that contains all GUI components------------------------
        JFrame myFrame = new JFrame("Text and password fields tutorial");
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myFrame.setPreferredSize(new Dimension(600, 400));
        myFrame.getContentPane().setBackground(new Color(128, 128, 150));
        myFrame.setLocation(1420, 520);  // Frame will appear in center of my 3440x1440 display
        myFrame.pack();
        myFrame.setVisible(true);

        //GUI components ----------------------------------------------

        // First Name field
        JLabel lblFName = new JLabel("First Name");
        JTextField tfFName = new JTextField(32);
        lblFName.setLabelFor(tfFName);

        // Last Name field
        JLabel lblLName = new JLabel("Last Name");
        JTextField tfLName = new JTextField(32);
        lblLName.setLabelFor(tfLName);

        // username field
        JLabel lblUName = new JLabel("Username");
        JTextField tfUName = new JTextField(32);
        lblUName.setLabelFor(tfUName);

        // password field
        JLabel lblPW = new JLabel("Password");
        JPasswordField pw = new JPasswordField(32);
        lblPW.setLabelFor(pw);

        // Icon
        ImageIcon icon = new ImageIcon("C:\\Users\\Stephen Stranahan\\IdeaProjects\\ECE435Projects\\src\\" +
                "com\\stephenstranahan\\assignment_4\\SS_Logo_50x50.png");

        JLabel iconLbl = new JLabel();
        iconLbl.setIcon(icon);

        JTextArea textArea = new JTextArea();


        // Submit button
        JButton submit = new JButton("Submit");
        SubmitListener submitListener = new SubmitListener(submit, textArea, tfFName, tfLName, tfUName, pw);
        submit.addMouseListener(submitListener);

        // Close button
        JButton close = new JButton("Close");
        CloseListener closeListener = new CloseListener(close);
        close.addMouseListener(closeListener);

        //Panel and layout
        JPanel panel = new JPanel();
        panel.setLayout(new SpringLayout());    // Using SpringLayout class - a little easier to work with than GridLayout


        // Add components to panel
        panel.add(lblFName);
        panel.add(tfFName);
        panel.add(lblLName);
        panel.add(tfLName);
        panel.add(lblUName);
        panel.add(tfUName);
        panel.add(lblPW);
        panel.add(pw);

        panel.add(iconLbl);
        panel.add(textArea);
        panel.add(submit);
        panel.add(close);


        // Set up layout - imported SpringUtilities class to get layout methods
        SpringUtilities.makeCompactGrid(panel, 6, 2, 6, 6, 6, 6);

        // Add panel to frame
        myFrame.add(panel);



//        //JLabel
//        JLabel myLabel = new JLabel("hi there!");
//        Font myFont = new Font("Courier New", Font.BOLD, 36);
//        myLabel.setFont(myFont);
//        myLabel.setForeground(new Color(255, 255, 255));
//        myFrame.add(myLabel);
//
//        //JButton
//        JButton myButton = new JButton("Click Me!");
//        myFrame.add(myButton);
//
//        //JSlider
//        JSlider mySlider = new JSlider(JSlider.HORIZONTAL,0, 100, 5);
//        myFrame.add(mySlider);

        //etc.

        //Event Handlers-----------------------------------------------

//        //Button click event
//        MyMouseListener myMouseListener = new MyMouseListener();
//        myButton.addMouseListener(myMouseListener);
//
//        //Slider change event
//        MyChangeListener myChangeListener = new MyChangeListener();
//        mySlider.addChangeListener(myChangeListener);
    }
} //MainUI class
