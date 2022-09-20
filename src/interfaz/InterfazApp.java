package interfaz;

import controlador.Controlador;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class InterfazApp extends JFrame {

    private Controlador ctrl;

    private PanelGrilla pnlGrilla;
    private PanelVidas pnlVidas;
    private PanelPistas pnlPistasFilas, pnlPistasColumnas;

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLUE);
        /*inicial(columna,fila)final(columna,fila)*/
        g.drawLine(178, 400, 478, 400);
        g.setColor(Color.red);
        g.drawLine(327, 250, 327, 550);
    }
    public InterfazApp() {

        this.ctrl = new Controlador();

        /*CONTROLA EL JFRAME*/
        setTitle("NONOGRAMA");
        getContentPane().setLayout(null);
        setSize(600, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        /*FIN DEL JFRAME*/

 /*CREACION DE LAS VIDAS*/
        this.pnlVidas = new PanelVidas();
        this.pnlVidas.setBounds(195, 0, 110, 100);
        getContentPane().add(pnlVidas);
        
        /*FIN VIDAS*/

 /*CREACION DE LAS PISTAS*/
 /*PISTA HORIZONTAL------------------------*/
        this.pnlPistasFilas = new PanelPistas(5, 10);
        this.pnlPistasFilas.setBounds(170, 120, 300, 100);
        getContentPane().add(pnlPistasFilas);
        pnlPistasFilas.verPistas(ctrl.getFilas());//inserta las pistas en los labels

        /*PISTA VERTICAL------------------------*/
        this.pnlPistasColumnas = new PanelPistas(10, 5);
        this.pnlPistasColumnas.setBounds(70, 220, 100, 300);
        getContentPane().add(pnlPistasColumnas);
        pnlPistasColumnas.verPistas(ctrl.getColumnas());//inserta las pistas en los labels
        /*FIN PISTAS*/

 /*LAGRILLA ES LO ULTIMO QUE SE PONE PUES NECESITA QUE PRIMERO SE CREEN LAS VIDAS Y LAS PISTAS PARA PODER FUNCIONAR.*/
 /*CREACION DE LA GRILLA CENTRAL*/
        this.pnlGrilla = new PanelGrilla(ctrl, this, pnlVidas);
        this.pnlGrilla.setBounds(170, 220, 300, 300);
        getContentPane().add(pnlGrilla);
//        pnlGrilla.verPistas(ctrl.getNono());//SOLO SE USO PARA VER SI LLENA EL NONOGRAMA
        /*FIN GRILLA CENTRAL*/

        ctrl.conectar(pnlGrilla);
        
    }

    public static void main(String[] args) {//INICIA LA EJECUACION DE LA INTERFA.
        new InterfazApp().setVisible(true);

    }

}
