package com.itani.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import com.itani.gui.enums.ButtonGroupEnums;
import com.itani.gui.enums.JButtonEnums;
import com.itani.gui.enums.JPanelEnums;
import com.itani.gui.enums.JRadioButtonEnums;
import com.itani.gui.enums.JLabelEnums;


public class ControlUI {

    public void buildGUII() {
        this.buildRadioButtonsUnit();
        this.buildControlButtonsUnit();
        this.buildControlUnit();
    }

    public void setDefaultActionListeners() {
        JButtonEnums.EXIT.get().addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });

        JButtonEnums.RESET.get().addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ButtonGroupEnums.RADIO_BUTTONS.get().clearSelection();
                        JButtonEnums.START.get().setEnabled(false);
                        // Wenn das Spiel zurückgesetzt wird soll man
                        // wieder optionen setzen können
                        JRadioButtonEnums.ONE_PLAYER.get().setEnabled(true);
                        JRadioButtonEnums.TWO_PLAYER.get().setEnabled(true);
                    }
                });

        JButtonEnums.START.get().addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // wenn das Spiel gestartet wird sollen
                        // bestimmte Schaltflächen deaktiviert werden
                        JButtonEnums.START.get().setEnabled(false);
                        JRadioButtonEnums.ONE_PLAYER.get().setEnabled(false);
                        JRadioButtonEnums.TWO_PLAYER.get().setEnabled(false);
                        GameUI.setGamefieldEnabled(true);
                    }
                });

        JRadioButtonEnums.ONE_PLAYER.get().addActionListener(new RadioButtonsActionListener());
        JRadioButtonEnums.TWO_PLAYER.get().addActionListener(new RadioButtonsActionListener());
    }

    private void buildRadioButtonsUnit() {      
        // Button-Gruppierung registrieren, damit immer nur ein Eintrag
        // gewählt werden kann.
        ButtonGroupEnums.RADIO_BUTTONS.get().add(JRadioButtonEnums.ONE_PLAYER.get());
        ButtonGroupEnums.RADIO_BUTTONS.get().add(JRadioButtonEnums.TWO_PLAYER.get());
       
        JPanelEnums.CONTROL_RADIO_BUTTONS.get().add(
           JLabelEnums.SELECT_PLAYER_COUNT.get()
       );
       JPanelEnums.CONTROL_RADIO_BUTTONS.get().add(JRadioButtonEnums.ONE_PLAYER.get());
       JPanelEnums.CONTROL_RADIO_BUTTONS.get().add(JRadioButtonEnums.TWO_PLAYER.get());
    }

    private void buildControlButtonsUnit() {
        JButtonEnums.START.get().setText("Starten");
        JButtonEnums.RESET.get().setText("Zurücksetzen");
        JButtonEnums.EXIT.get().setText("Beenden");
        
        JPanelEnums.CONTROL_BUTTONS.get().add(JButtonEnums.START.get());
        JPanelEnums.CONTROL_BUTTONS.get().add(JButtonEnums.RESET.get());
        JPanelEnums.CONTROL_BUTTONS.get().add(JButtonEnums.EXIT.get());
        
        JPanelEnums.CONTROL_BUTTONS.get().setLayout(
            new FlowLayout()
        );
    }
    
    private void buildControlUnit() {       
        // hinzufügen der Elemente zum Panel
        JPanelEnums.CONTROL.get().add(JLabelEnums.SELECT_PLAYER_COUNT.get());
        JPanelEnums.CONTROL.get().add(JPanelEnums.CONTROL_RADIO_BUTTONS.get());
        JPanelEnums.CONTROL.get().add(JPanelEnums.CONTROL_BUTTONS.get());
        JPanelEnums.CONTROL.get().add(JLabelEnums.USER_INFORMATION_OUTPUT.get());
        
        JPanelEnums.CONTROL.get().setLayout(
            new GridLayout(JPanelEnums.CONTROL.get().getComponentCount(), 1)
        );        
    }

    private class RadioButtonsActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButtonEnums.START.get().setEnabled(true);
            JLabelEnums.USER_INFORMATION_OUTPUT.get().setText("");
        }
    }
    
    public void setUserinformationText(String text) {
        JLabelEnums.USER_INFORMATION_OUTPUT.get().setText(text);
    }
}
