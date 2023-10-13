package main;

import java.awt.BorderLayout;
import java.awt.Dimension;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import static main.MainWindow.panel;
import static main.MainWindow.window;

public class ShowTasks {

    private JTextArea textArea;
    public ShowTasks() {
        
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(MainWindow.font);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(380, 220));

        
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(new QuitButton(panel).getButton(), BorderLayout.SOUTH);
        readCSV("tareas.txt");
        panel.revalidate();
        panel.repaint();
        window.setVisible(true);
    }
    

    public void readCSV(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
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
            JOptionPane.showMessageDialog(window, "");
        }
    }
}
