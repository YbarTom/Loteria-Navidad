package loterianavidad;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionesGuardar {
    
    
    /**
     * Crea una carpeta para los Sorteos en el caso de que no exista
     * 
     */
    public static void crearCarpetaSorteos(){
        File f = new File(LoteriaNavidad.CARPETA);
        if(!f.exists()){
            f.mkdir();
        }
    }
    
    
    /**
     * Lleig un arxiu binari amb els números premiats amb el sorteig de la Loteria de Nadal
     * 
     * @param nomFitxer Nom del arxiu binari que es vol llegir
     * @param vector Un array d'objectes NumPremiat en el que s'emmagatzemarà els números premiats llegits de l'arxiu
     * @param premisGrans Un array en el que es registraran els premis de la sèrie de meros guanyadors.
     */
    public static void leerSorteo(String nomFitxer, LoteriaNavidad.NumPremiat[] vector, int[] premisGrans){
        DataInputStream dis = FuncionesUtilidades.AbrirFicheroLecturaBinario(nomFitxer, true);
        for(int i = 0; i < LoteriaNavidad.TOTPREMS; ++i){
            try {
                vector[i] = new LoteriaNavidad.NumPremiat();
                vector[i].numero = dis.readInt();
                vector[i].premi = dis.readInt();
                guardarGrans(vector[i].numero, vector[i].premi, premisGrans);
            } catch (IOException ex) {
                Logger.getLogger(FuncionesGuardar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            dis.close();
        } catch (IOException ex) {
            Logger.getLogger(FuncionesGuardar.class.getName()).log(Level.SEVERE, null, ex);
        }
        FuncionesUtilidades.CerrarLecturaBinario(dis);
    }
    
    
    /**
     * Metode per guardar els numeros dels premis grans de la loteria de Nadal en un array
     * 
     * @param numero Numero premiat que es vol guardar
     * @param premi Tipus de premi Guardat 
     * @param premisGrans Array on es guardan els numeros premiats
     */
    public static void guardarGrans(int numero, int premi, int[] premisGrans){
        switch (premi) {
            case LoteriaNavidad.PRIMERPREMI:
                premisGrans[0] = numero;
                break;
            case LoteriaNavidad.SEGONPREMI:
                premisGrans[1] = numero;
                break;
            case LoteriaNavidad.TERCERPREMI:
                premisGrans[2] = numero;
                break;
            case LoteriaNavidad.QUARTPREMI:
                if(premisGrans[3] != 0){
                    premisGrans[4] = numero;
                }
                else{
                    premisGrans[3] = numero;
                }   break;
            default:
                break;
        }
    }
    
    
    /**
     * Escriu els numero premiat en l'arxiu Binari
     * 
     * @param vector Array d'objectes NumPremiat que conté els números premiats
     * @param nomFitxer Nom del Fitxer on es vol escriure els numeros premiats
     */
    public static void escribirSorteo(LoteriaNavidad.NumPremiat[] vector, String nomFitxer){
        DataOutputStream dos = FuncionesUtilidades.AbrirFicheroEscrituraBinario(nomFitxer, true, true);
        for(int i = 0; i < vector.length; ++i){
            try {
                dos.writeInt(vector[i].numero);
                dos.writeInt(vector[i].premi);
            } catch (IOException ex) {
                Logger.getLogger(FuncionesGuardar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
