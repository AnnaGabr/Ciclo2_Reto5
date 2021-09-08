package reto5;

import VistaControlador.VentanaPrincipal;

public class Reto5 {
    
    // Nuestro main es que abra la ventana
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }
    
}
