package com.itani.gui.enums;

import javax.swing.JLabel;

import com.itani.gui.GUIComponent;

public enum JLabelEnums implements GUIComponent {
   
    SELECT_PLAYER_COUNT,
    USER_INFORMATION_OUTPUT;

    private final JLabel jlabel = new JLabel();

    public JLabel get() {
        return jlabel;
    }
}
