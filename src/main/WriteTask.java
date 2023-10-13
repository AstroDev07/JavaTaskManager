package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class WriteTask {

    public void setTask(String titulo, String descripcion, JFrame window) {
        String text = "\n"+ titulo+ "·"+descripcion;
        try {
            FileWriter fileWriter = new FileWriter("tareas.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(text);

            bufferedWriter.close();
            JOptionPane.showMessageDialog(window, "La tarea se ha guardado correctamente");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(window, "Error al escribir en el archivo: " + e.getMessage());
        }
    }
    
        
}



