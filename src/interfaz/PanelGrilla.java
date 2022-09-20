package interfaz;

import controlador.Controlador;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class PanelGrilla extends JPanel {
    
    private JLabel[][] lblGrilla;
    private Controlador controlador;
    public PanelVidas pnlVidas;
    

    public PanelGrilla(Controlador controlador, InterfazApp interfazApp, PanelVidas pnlVidas) {
        setLayout(new GridLayout(10,10));

        this.controlador = controlador;
        this.pnlVidas = pnlVidas;

        // Instancia atributos de la clase   
        lblGrilla = new JLabel[10][10];

        // Agrega los atributos al panel   
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                lblGrilla[i][j] = new JLabel("");
                lblGrilla[i][j].setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("")));
                lblGrilla[i][j].setHorizontalAlignment(JLabel.CENTER);
                lblGrilla[i][j].setVerticalAlignment(JLabel.CENTER);
                lblGrilla[i][j].setEnabled(true);
                lblGrilla[i][j].addMouseListener(new LabelClicMouse(i, j, lblGrilla[i][j], controlador, this, pnlVidas));
                add(lblGrilla[i][j]);
            }
        }
    } 
///*SOLO SE USO PARA PROBAR SI LLENA EL NONOGRAMA*/
//    public void verPistas(String pistas[][]) {
//        for (int i = 0; i < 10; i = i + 1) {
//            for (int j = 0; j < 10; j = j + 1) {
//                if (!pistas[i][j].equals("0")) {
//                    lblGrilla[i][j].setText(pistas[i][j]);
//                }
//            }
//        }
//    }
}//FIN CLASE PANEL GRILLA


class LabelClicMouse extends MouseAdapter {

    private static final String BLOCK = "data/Block.gif";

    private JLabel label;
    private Controlador ctrl;
    private int x, y;
    private ImageIcon imgCell;
    private PanelGrilla pnlGrilla;
    public PanelVidas pnlVidas;

    public LabelClicMouse(int x, int y, JLabel label, Controlador ctrl, PanelGrilla pnlGrilla, PanelVidas pnlVidas) {
        this.label = label;
        this.ctrl = ctrl;
        this.x = x;
        this.y = y;
        this.imgCell = new ImageIcon(BLOCK);
        this.pnlGrilla = pnlGrilla;
        this.pnlVidas = pnlVidas;

    }

    public void mouseClicked(MouseEvent evento) {

        if (pnlVidas.getVidas()>= 0) {
            if (evento.isMetaDown()) { // boton derecho del raton x

                if ((label.getText()).equals("") && label.getIcon() == null) {
                    if (!ctrl.ponerCelda(x, y, "X")) {
                        label.setIcon(imgCell);
                        System.out.println("ERROR! ---> ([*])");
                    } else {
                        label.setText("X");
                        System.out.println("Click derecho del mouse (X)");
                    }
                    System.out.println("Pocision  " + x + "," + y);
                }
            } else {// boton izquierdo del raton 
                if ((label.getText()).equals("") && label.getIcon() == null) {
                    if (!ctrl.ponerCelda(x, y, "0")) {
                        label.setText("X");
                        System.out.println("ERROR! ---> (X)");
                    } else {
                        label.setIcon(imgCell);
                        System.out.println("Click izquierdo del mouse ([*])");
                    }
                    System.out.println("Pocision " + x + "," + y);

                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Game Over.", "Nonograma", JOptionPane.WARNING_MESSAGE);
        }
    }
}