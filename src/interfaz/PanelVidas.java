package interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelVidas extends JPanel {

    private JLabel lbVida[];
    private ImageIcon vidaLlena, vidaVacia;
    private int contadorDeVidas;

    public PanelVidas() {
        setLayout(new GridLayout(1, 10));
        this.vidaLlena = new ImageIcon("data/live.png");
        this.vidaVacia = new ImageIcon("data/die.png");
        this.setBackground(Color.red);//PONER COLOR DEL FONDO DONDE SE VAN A PONER

        lbVida = new JLabel[3];//1,2,3

        contadorDeVidas = 2;//2 PERO EN EL ARREGLO EMPIZA DESDE 0 JASTA 2

        // Agrega los atributos al panel (PONER LA VIDAS EN EL JFRAME) DESDE EL 0 - 2 
        for (int i = 0; i < 3; i++) {
            lbVida[i] = new JLabel("");
            add(lbVida[i]);
            lbVida[i].setIcon(vidaLlena);
        }
    }

    public int getVidas() {
        return contadorDeVidas;
    }

    public void actualizarVidas() {
        System.out.println(contadorDeVidas);
        lbVida[contadorDeVidas].setIcon(null);
        lbVida[contadorDeVidas].setIcon(vidaVacia);
        contadorDeVidas--;
        System.out.println(contadorDeVidas);
        if (contadorDeVidas < 0) {
            JOptionPane.showMessageDialog(null, "PERDISTE", "Nonograma", JOptionPane.WARNING_MESSAGE);
  
        }
    }
}
