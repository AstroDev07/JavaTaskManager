package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import static main.MainWindow.panel;

public class QuitButton {
    private JButton quit;
    
    public QuitButton (JPanel panel) {
        quit = new JButton("Salir");
        quit.setFocusable(false);
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll(); // Cierra la ventana actual
                panel.revalidate();
                panel.repaint();
                MainWindow.update();// Abre una nueva ventana
            }
        });
    }
    public JButton getButton() {
        return quit;
    }
}
