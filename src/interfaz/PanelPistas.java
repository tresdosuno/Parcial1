package interfaz;

import java.awt.Color;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class PanelPistas extends JPanel {
    // Atributos de la clase 		

    private JLabel lblPistas[][];
    private int fila;
    private int columna;

    public PanelPistas(int filas, int columnas) {
        this.fila = filas;
        this.columna = columnas;
        setLayout(new GridLayout(filas, columnas));
        this.setBackground(Color.RED);

        // Instancia atributos de la clase   
        lblPistas = new JLabel[fila][columna];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                lblPistas[i][j] = new JLabel("");
                lblPistas[i][j].setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("")));
                lblPistas[i][j].setHorizontalAlignment(JLabel.CENTER);
                lblPistas[i][j].setVerticalAlignment(JLabel.CENTER);
                lblPistas[i][j].setForeground(Color.BLACK);
                add(lblPistas[i][j]);
            }
        }
    }

    public void verPistas(String pistas[][]) {
        for (int i = 0; i < fila; i = i + 1) {
            for (int j = 0; j < columna; j = j + 1) {
                if (!pistas[i][j].equals("0")) {
                    lblPistas[i][j].setText(pistas[i][j]);
                }
            }
        }
    }

}
