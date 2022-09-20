package mundo;

public class Nonograma{
    private String [][] nono ;
    private String[][] auxiliar = new String [10][10];

    public Nonograma(String nono [][]){ 
        this.nono = nono;
        for(int i = 0; i < auxiliar.length; i++){
            for(int j = 0; j < auxiliar[i].length; j++) {
                auxiliar[i][j]="h";
            }
        }
    }
    
    public boolean verificacion (int x, int y, String c){
        if(this.nono [x][y].equals(c)){
           this.auxiliar[x][y] = c;
           return true;
        }
        else{
            if ("X".equals(c)) this.auxiliar[x][y] = "X";
            else this.auxiliar[x][y] = "0";
            return false;
        }
    }
    public boolean termino(){
        int contador = 0;
        for (int i = 0; i < auxiliar.length; i++) {
            for (int j = 0; j < auxiliar[i].length; j++) {
                if(auxiliar[i][j].equals("h")){
                    break;
                }
                else {
                    contador++;
                }
            }
        }
        return contador == 100;
    }
}
