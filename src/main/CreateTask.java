package main;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static main.MainWindow.panel;
import static main.MainWindow.window;

public class CreateTask {
    private JTextField textFieldTitulo;
    private JTextField textFieldDescripcion;

    public CreateTask() {
        // Crear los componentes
        JLabel labelTitulo = new JLabel("Título");
        JLabel labelDescripcion = new JLabel("Descripción");
        textFieldTitulo = new JTextField(20);
        textFieldDescripcion = new JTextField(20);
        JButton botonAceptar = new JButton("Aceptar");

        // Establecer el layout

        // Agregar los componentes a la ventana
        panel.add(labelTitulo, BorderLayout.NORTH);
        panel.add(textFieldTitulo, BorderLayout.NORTH);
        panel.add(labelDescripcion, BorderLayout.CENTER);
        panel.add(textFieldDescripcion, BorderLayout.CENTER);
        panel.add(botonAceptar, BorderLayout.SOUTH);
        panel.add(new QuitButton(panel).getButton(), BorderLayout.SOUTH);

        // Agregar un ActionListener al botón Aceptar
        botonAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titulo = textFieldTitulo.getText().trim();
                String descripcion = textFieldDescripcion.getText().trim();
                if (titulo.equals(""))
                    JOptionPane.showMessageDialog(window, "La pestaña \"Titulo\" esta vacia, debes rellenarla");
                else if (descripcion.equals(""))
                    JOptionPane.showMessageDialog(window, "La pestaña \"Descripcion\" esta vacia, debes rellenarla");
                else{
                    new WriteTask().setTask(titulo, descripcion, window);
                    
                }
                    

            }
        });
        panel.revalidate();
        panel.repaint();
        window.setVisible(true);
    }


}