package main;

import java.io.File;
import java.io.IOException;

public class FileExist {
    public FileExist () {
        String rutaArchivo = "tareas.txt";

        File archivo = new File(rutaArchivo);

        if (archivo.exists()) {
            return;
        } else {
            try {
                if (archivo.createNewFile()) {
                    System.out.println("El archivo se ha creado exitosamente.");
                } else {
                    System.out.println("No se pudo crear el archivo.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



