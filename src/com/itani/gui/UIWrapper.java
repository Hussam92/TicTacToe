package com.itani.gui;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.FlowLayout;

import com.itani.gui.enums.JButtonEnums;
import com.itani.gui.enums.JFrameEnums;
import com.itani.gui.enums.JLabelEnums;
import com.itani.gui.enums.JPanelEnums;
import com.itani.gui.enums.JRadioButtonEnums;

public class UIWrapper {

    private GameUI gameUI;
    private ControlUI controlUI;

    public UIWrapper() {
        this("Tic-Tac-Toe");
    }

    public UIWrapper(String title) {
        this.gameUI = new GameUI();
        this.controlUI = new ControlUI();
        this.setTitle(title);
    }

    public final void setTitle(String title) {
        JFrameEnums.MAIN.get().setTitle(title);
    }

    public void buildGUI() {
        /* Tic-Tac-Toe-Buttons */
        this.gameUI.buildGUI();

        /* Control GUI */
        this.controlUI.buildGUII();

        /* GUI fertig machen */
        this.addAllComponents();
        // alle Buttons zunächst disable'n, Schriftgröße der Buttons einstellen
        this.setDefaultComponentSettings();
        this.gameUI.prepareGamefield();
        this.controlUI.setDefaultActionListeners();
        this.makeGuiReady();
    }

    private void addAllComponents() {
        JFrameEnums.MAIN.get().add(JPanelEnums.CONTROL.get());
        JFrameEnums.MAIN.get().add(JPanelEnums.GAME_FIELD.get());
    }

    private void makeGuiReady() {        
        JFrameEnums.MAIN.get().setLayout(new FlowLayout());
        JFrameEnums.MAIN.get().pack();
    }

    private void setDefaultComponentSettings() {
        JFrameEnums.MAIN.get().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrameEnums.MAIN.get().setResizable(false);

        JRadioButtonEnums.ONE_PLAYER.get().setText("Ein Spieler");
        JRadioButtonEnums.TWO_PLAYER.get().setText("Zwei Spieler");
        JRadioButtonEnums.ONE_PLAYER.get().setFocusPainted(false);
        JRadioButtonEnums.TWO_PLAYER.get().setFocusPainted(false);

        JButtonEnums.EXIT.get().setFocusPainted(false);
        JButtonEnums.RESET.get().setFocusPainted(false);
        JButtonEnums.START.get().setFocusPainted(false);

        JLabelEnums.SELECT_PLAYER_COUNT.get().setText("Anzahl der Spieler bitte Auswählen");
        JLabelEnums.USER_INFORMATION_OUTPUT.get().setText("Bitte Spieleranzahl wählen!");
        JLabelEnums.USER_INFORMATION_OUTPUT.get().setForeground(Color.red);

        // erst wenn bei Radio-Buttons eine Aktion durchgeführt
        // wurde, wird Button aktiv
        JButtonEnums.START.get().setEnabled(false);
    }

    public void showGUI() {
        JFrameEnums.MAIN.get().setVisible(true);
    }
    
    public void hide() {
        JFrameEnums.MAIN.get().setVisible(false);
    }

    public static void main(String[] args) {
        UIWrapper gui = new UIWrapper();
        gui.buildGUI();
        gui.showGUI();
    }
}
