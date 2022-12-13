package com.itani.gui.enums;

import javax.swing.JPanel;
import com.itani.gui.GUIComponent;

public enum JPanelEnums implements GUIComponent {

    CONTROL,
    CONTROL_RADIO_BUTTONS,
    CONTROL_BUTTONS,
    GAME_FIELD;

    private final JPanel jpanel = new JPanel();

    public JPanel get() {
        return jpanel;
    }
}
