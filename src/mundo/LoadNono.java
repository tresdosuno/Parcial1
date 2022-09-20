package mundo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoadNono {

    private String[][] filas;
    private String[][] columnas;
    private String[][] nono;

    public LoadNono() {
        filas = new String[5][];
        columnas = new String[10][];
        nono = new String[10][];
    }

    public String[][] getFilas() {
        return filas;
    }

    public String[][] getColumnas() {
        return columnas;
    }

    public String[][] getNono() {
        return nono;
    }

    public void leerNonograma(String fileIn) {
        BufferedReader buffer = null;
        String line;

        try {
            buffer = new BufferedReader(new FileReader(fileIn));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            for (int i = 0; i < 5; i++) // Lee pistas de las filas
            {
                line = buffer.readLine();
                filas[i] = line.split(" ");
            }
            for (int i = 0; i < 10; i++) // Lee pistas de las columnas
            {
                line = buffer.readLine();
                columnas[i] = line.split(" ");
            }
            for (int i = 0; i < 10; i++) // Lee el nonograma
            {
                line = buffer.readLine();
                nono[i] = line.split(" ");
            }
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
