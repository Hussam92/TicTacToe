package com.itani.gui.enums;

import javax.swing.ButtonGroup;

import com.itani.gui.GUIComponent;

public enum ButtonGroupEnums implements GUIComponent {

    RADIO_BUTTONS;

    private final ButtonGroup buttongroup = new ButtonGroup();

    public ButtonGroup get() {
        return buttongroup;
    }
}
