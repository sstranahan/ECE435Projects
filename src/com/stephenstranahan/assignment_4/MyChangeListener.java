package com.stephenstranahan.assignment_4;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MyChangeListener implements ChangeListener {

    @Override
    public void stateChanged(ChangeEvent evt) {

        JSlider slider = (JSlider) evt.getSource();

        System.out.print("\nvalue: " + slider.getValue());
    }
}