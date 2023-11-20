package tictactoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
public class ButtonClickListener implements ActionListener {
    private JButton[][] buttons;
    private String currentPlayer;
    public ButtonClickListener(JButton[][] buttons, String currentPlayer) {
        this.buttons = buttons;
        this.currentPlayer = currentPlayer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}