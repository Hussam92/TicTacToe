package com.itani.gui.enums;

import javax.swing.JButton;

import com.itani.gui.GUIComponent;

public enum JButtonEnums implements GUIComponent {

    START,
    EXIT,
    RESET,
    GAME_TOP_LEFT,
    GAME_TOP_CENTER,
    GAME_TOP_RIGHT,
    GAME_MIDDLE_LEFT,
    GAME_MIDDLE_CENTER,
    GAME_MIDDLE_RIGHT,
    GAME_BOTTOM_LEFT,
    GAME_BOTTOM_CENTER,
    GAME_BOTTOM_RIGHT;

    private final JButton jbutton = new JButton();

    public JButton get() {
        return jbutton;
    }

}
