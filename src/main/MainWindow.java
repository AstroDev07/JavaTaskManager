package main;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MainWindow {
    
    public static Font font;
    public static JFrame window;
    public static JPanel panel;
            
    private static JButton ayuda = new JButton("Ayuda");
    private static JButton crearTarea = new JButton("Crear Tarea");
    private static JButton verTareas = new JButton("Ver Tareas");
    private static JLabel presentacion = new JLabel("esta es una recreacion de \"CTaskManager\"");

    
    
    
    public MainWindow () {
        window = new JFrame();
        panel = new JPanel();
        window.setTitle("JavaTaskManager");
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(400, 300);
        window.setLocationRelativeTo(null);
        
        
        panel.setLayout(new FlowLayout());
        font = new GetFont().getFont();
        new FileExist();
        
        
        ayuda.setFocusable(false);
        ayuda.setSize(100, 50);
       
        crearTarea.setFocusable(false);
        crearTarea.setSize(100, 50);
        
        verTareas.setFocusable(false);
        verTareas.setSize(100, 50);
        
        presentacion.setFont(font);
         
        ayuda.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll(); // Cierra la ventana actual
                new ShowHelp(); // Abre una nueva ventana
            }
        });
        crearTarea.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                panel.removeAll(); // Cierra la ventana actual
                new CreateTask(); // Abre una nueva ventana
            }
        });
        verTareas.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll(); // Cierra la ventana actual
                new ShowTasks(); // Abre una nueva ventana
            }
        });
        
        
        update();
    }
    
    public static void update () {
        panel.revalidate();
        panel.repaint();
        panel.add(ayuda);
        panel.add(crearTarea);
        panel.add(verTareas);
        panel.add(presentacion);
        window.add(panel);
        window.setVisible(true);
    }
}