package InClassAssigment_20210209;

import com.stephenstranahan.assignment_4.SpringUtilities;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class SimpleUI implements Runnable {

    public void run() {

        //Frame that contains all GUI components------------------------
        JFrame myFrame = new JFrame("Keystroke Icon Demo");
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myFrame.setPreferredSize(new Dimension(400, 600));
        myFrame.getContentPane().setBackground(new Color(128, 128, 150));
//      myFrame.setLocation(1420, 520);  // Frame will appear in center of my 3440x1440 display
        myFrame.pack();
        myFrame.setVisible(true);

        //GUI components ----------------------------------------------

        // Icon
        ImageIcon watta = null;
        ImageIcon kaufman = null;
        ImageIcon dab = null;
        ImageIcon bazzi = null;

        try {
            watta = new ImageIcon("C:\\Users\\Stephen Stranahan\\IdeaProjects\\ECE435Projects\\src\\InClassAssigment_20210209\\watta.jpg");
            kaufman = new ImageIcon("C:\\Users\\Stephen Stranahan\\IdeaProjects\\ECE435Projects\\src\\InClassAssigment_20210209\\kaufman.jpg");
            dab = new ImageIcon("C:\\Users\\Stephen Stranahan\\IdeaProjects\\ECE435Projects\\src\\InClassAssigment_20210209\\dsc_3020a_1.jpg");
            bazzi = new ImageIcon("C:\\Users\\Stephen Stranahan\\IdeaProjects\\ECE435Projects\\src\\InClassAssigment_20210209\\ali_bazzi.jpg");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        watta = new ImageIcon(watta.getImage().getScaledInstance(250,352,Image.SCALE_DEFAULT));
        kaufman = new ImageIcon(kaufman.getImage().getScaledInstance(250,352,Image.SCALE_DEFAULT));
        dab = new ImageIcon(dab.getImage().getScaledInstance(250,352,Image.SCALE_DEFAULT));
        bazzi = new ImageIcon(bazzi.getImage().getScaledInstance(250,352,Image.SCALE_DEFAULT));

        JLabel iLBL1 = new JLabel("", SwingConstants.CENTER);

        iLBL1.setIcon(watta);

        // password field
        JLabel lblPW = new JLabel("Password");
        JPasswordField pw = new JPasswordField(16);
        lblPW.setLabelFor(pw);

        //Text box for confirmation message
        JTextArea textArea = new JTextArea();

        // Submit button
        JButton submit = new JButton("Submit");

        SubmitListener sl = new SubmitListener(submit, textArea, pw);

        submit.addMouseListener(sl);

        JButton close = new JButton("Close");

        CloseListener cl = new CloseListener(close);

        close.addMouseListener(cl);

        JLabel explanation = new JLabel("A and D keys to cycle images. Spacebar to re-watta-ize", SwingConstants.CENTER);

        MyKeyListener keyListener = new MyKeyListener(iLBL1, watta, kaufman, dab, bazzi, myFrame);

        //Panel and layout
        JPanel panel = new JPanel();
        panel.setLayout(new SpringLayout());    // Using SpringLayout class - a little easier to work with than GridLayout

        explanation.addKeyListener(keyListener);

        panel.add(iLBL1);
        panel.add(explanation);
        panel.add(pw);
        panel.add(textArea);
        panel.add(submit);
        panel.add(close);

        // Set up layout - imported SpringUtilities class to get layout methods
        SpringUtilities.makeCompactGrid(panel,6 , 1, 6, 6, 6, 6);

        // Add panel to frame
        myFrame.add(panel);
    }
} //MainUI class
