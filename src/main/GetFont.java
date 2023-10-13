package main;

import java.awt.Font;
import javax.swing.UIManager;

public class GetFont {
    // Establecer el look and feel
    public GetFont() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Obtener el font predeterminado
        
    }
    public Font getFont() {
        return UIManager.getFont("Label.font");
    }
}
