package com.itani.gui.enums;

import javax.swing.JFrame;
import com.itani.gui.GUIComponent;

public enum JFrameEnums implements GUIComponent {
    
    MAIN;

    private final JFrame jframe = new JFrame();

    public JFrame get() {
        return jframe;
    }
}
