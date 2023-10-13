

package main;

import javax.swing.*;
import java.awt.*;
import static main.MainWindow.panel;


public class ShowHelp {
    public ShowHelp() {

        JTextArea textArea = new JTextArea("Para crear una tarea solo ve a el boton \"crear tarea\" y agrega la tarea y listo\n\npara ver las tareas solo ve al boton \"ver tareas\" y listo\n\nCreado por Trevor Gonzalo Martinez Jesusito");
        textArea.setFont(MainWindow.font);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(380, 220));
        panel.add(scrollPane);
        
        panel.add(new QuitButton(panel).getButton());
        panel.revalidate();
        panel.repaint();
    }
}