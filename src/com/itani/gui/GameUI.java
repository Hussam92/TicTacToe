package com.itani.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

import com.itani.gui.enums.JButtonEnums;
import com.itani.gui.enums.JPanelEnums;
import com.itani.gui.enums.JRadioButtonEnums;
import com.itani.gui.enums.JLabelEnums;

public class GameUI {
    
    public void buildGUI() {
        /*      Tic-Tac-Toe-Buttons      */
        this.setButtonsSize();
        this.addButtonsToPanel();
        this.setGamefieldPanelLayout();
    }
    
    private void setButtonsSize() {
        for (JButtonEnums button : JButtonEnums.values()) {
            if (button.toString().contains("GAME_")) {
                button.get().setPreferredSize( new Dimension(120, 120));
            }
        }
    }
    
    private void addButtonsToPanel() {
        /* keine Schleife die iteriert, damit die Buttons in der
        richtigen Reihenfolge erscheinen! */
        JPanelEnums.GAME_FIELD.get().add(
            JButtonEnums.GAME_TOP_LEFT.get()
        );
        JPanelEnums.GAME_FIELD.get().add(
            JButtonEnums.GAME_TOP_CENTER.get()
        );
        JPanelEnums.GAME_FIELD.get().add(
            JButtonEnums.GAME_TOP_RIGHT.get()
        );
        JPanelEnums.GAME_FIELD.get().add(
            JButtonEnums.GAME_MIDDLE_LEFT.get()
        );
        JPanelEnums.GAME_FIELD.get().add(
            JButtonEnums.GAME_MIDDLE_CENTER.get()
        );
        JPanelEnums.GAME_FIELD.get().add(
            JButtonEnums.GAME_MIDDLE_RIGHT.get()
        );
        JPanelEnums.GAME_FIELD.get().add(
            JButtonEnums.GAME_BOTTOM_LEFT.get()
        );
        JPanelEnums.GAME_FIELD.get().add(
            JButtonEnums.GAME_BOTTOM_CENTER.get()
        );
        JPanelEnums.GAME_FIELD.get().add(
            JButtonEnums.GAME_BOTTOM_RIGHT.get()
        );
    }
    
    private void setGamefieldPanelLayout() {
        int d = 7;        
        JPanelEnums.GAME_FIELD.get().setBorder(
            new EmptyBorder(d, d, d, d)
        );        
        JPanelEnums.GAME_FIELD.get().setLayout(
            new GridLayout(3, 3, d, d)
        );
    }
    
    public void addActionListener(GUIComponent c, ActionListener al) {
        // in diesem Fall brauche ich nur Action Listener für Buttons
        if (c instanceof JButtonEnums) {
            JButtonEnums.valueOf(c.toString()).get().addActionListener(al);
        }
    }
    
    public void setGamefieldButtonValue(JButtonEnums button, String text) {
        button.get().setText(text);
    }
    
    public boolean canUseThisButton(JButtonEnums button) {
        return "".equals(button.get().getText());
    }
    
    public int getNumberOfPlayers() {
        if (JRadioButtonEnums.ONE_PLAYER.get().isSelected()) {
            return 1;
        } else if (JRadioButtonEnums.TWO_PLAYER.get().isSelected()) {
            return 2;
        } else {
            return 0;
        }
    }
    

    public void prepareGamefield() {
        for (JButtonEnums button : JButtonEnums.values()) {
            if (button.toString().contains("GAME_")) {
                button.get().setFont(new Font("Arial", Font.PLAIN, 80));
                button.get().setFocusPainted(false);
                button.get().setEnabled(false);
            }
        }
    }
    
    public static void setGamefieldEnabled(boolean enabled) {
        for (JButtonEnums button : JButtonEnums.values()) {
            if (button.toString().contains("GAME_")) {
                button.get().setEnabled(enabled);
            }
        }
    }
    
    public void resetGameField() {
       for (JButtonEnums button : JButtonEnums.values()) {
            if (button.toString().contains("GAME_")) {
                button.get().setText("");
            }
        } 
    }
}