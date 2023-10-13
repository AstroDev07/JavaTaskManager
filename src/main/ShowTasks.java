package main;

import java.awt.Dimension;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import static main.MainWindow.panel;
import static main.MainWindow.window;

public class ShowTasks {

    
    private final JTextArea textArea;
    public ShowTasks() {
        
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(MainWindow.font);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(380, 220));

        
        panel.add(scrollPane);
        panel.add(new QuitButton(panel).getButton());
        panel.revalidate();
        panel.repaint();
        window.setVisible(true);
        readCSV();
    }
    

    private void readCSV() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("tareas.txt"));
            String line;
            ArrayList<String> descriptions = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                String[] data = line.split("·");
                String description = data[0];
                String information = data[1];

                descriptions.add(description + ": " + information);
            }

            for (String description : descriptions) {
                textArea.append(description + "\n\n");
            }
            
        } catch (IOException e) {
            System.out.println("paco");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("iba a dar la excepcion");
            File file = new File("tareas.txt");
            file.delete();
            new FileExist();
        }
    }
}
