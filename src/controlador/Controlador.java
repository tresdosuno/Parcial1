package controlador;

import mundo.Nonograma;
import interfaz.PanelGrilla;
import javax.swing.JOptionPane;
//import mundo.LoadNono;
import mundo.LoadNono;

/**
 *
 * @author SRMOON
 */
public class Controlador {
    private PanelGrilla pnlGrilla;
    private LoadNono loadNono;
    private Nonograma nonograma;

    public Controlador() {
        this.loadNono = new LoadNono();//crar un objeto de "LoadNono".(Crea un plantilla de esa clase).
        leerNonograma();//usa el metodo para cargar la plantilla con los datos del txt.
        this.nonograma = new Nonograma(getNono());
    }
    public void conectar(PanelGrilla pnlGrilla) {
        this.pnlGrilla = pnlGrilla;
    }

    public void leerNonograma() {//carga el archivo txt en el "LoadNono"
        loadNono.leerNonograma("G:\\Mi unidad\\3) Java ejercicios\\3) IntelliJ IDEA\\Nonograma\\nonogramas\\nono0.in");
    }
    public String[][] getNono() {
        return loadNono.getNono();
    }
    public String[][] getFilas() {
        return loadNono.getFilas();
    }
    public String[][] getColumnas() {
        return loadNono.getColumnas();
    }

    /* Metodo para controlar el evento del mouse */
    public boolean ponerCelda(int x, int y, String c) {
        if (!nonograma.verificacion(x, y, c)) {
            pnlGrilla.pnlVidas.actualizarVidas();
        }
        if (nonograma.termino() && pnlGrilla.pnlVidas.getVidas() > 0) {
            JOptionPane.showMessageDialog(null, " GANASTE! ", "Nonograma", JOptionPane.INFORMATION_MESSAGE);
        }
        return nonograma.verificacion(x, y, c);
    }
    

    
    
    
    

    

}
