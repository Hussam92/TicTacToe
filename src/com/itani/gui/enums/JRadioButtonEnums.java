package com.itani.gui.enums;

import javax.swing.JRadioButton;
import com.itani.gui.GUIComponent;

public enum JRadioButtonEnums implements GUIComponent {

    ONE_PLAYER,
    TWO_PLAYER;

    private final JRadioButton jradiobutton = new JRadioButton();

    public JRadioButton get() {
        return jradiobutton;
    }
}