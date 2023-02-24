package loterianavidad;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionesGuardar {
    
    public static void leerSorteo(String nomFitxer, LoteriaNavidad.NumPremiat[] vector, int[] premisGrans){
        DataInputStream dis = AbrirFicheroLecturaBinario(nomFitxer, true);
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
    }
    
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
    
    public static void escribirSorteo(LoteriaNavidad.NumPremiat[] vector, String nomFitxer){
        DataOutputStream dos = AbrirFicheroEscrituraBinario(nomFitxer, true, true);
        for(int i = 0; i < vector.length; ++i){
            try {
                dos.writeInt(vector[i].numero);
                dos.writeInt(vector[i].premi);
            } catch (IOException ex) {
                Logger.getLogger(FuncionesGuardar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static File AbrirFichero(String nomFichero, boolean crear) {
        File result = new File(nomFichero);

        if (!result.exists()) {
            if (crear) {
                try {
                    result.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(FuncionesGuardar.class.getName()).log(Level.SEVERE, null, ex);
                    result = null;
                }
            } else {
                result = null;
            }
        }

        return result;
    }
    
    public static DataOutputStream AbrirFicheroEscrituraBinario(String nomFichero, boolean crear, boolean blnAnyadir) {
        DataOutputStream dos = null;
        File f = AbrirFichero(nomFichero, crear);

        if (f != null) {
            // Declarar el writer para poder escribir en el fichero¡
            FileOutputStream writer;
            try {
                writer = new FileOutputStream(f, blnAnyadir);
                // PrintWriter para poder escribir más comodamente
                dos = new DataOutputStream(writer);
            } catch (IOException ex) {
                Logger.getLogger(FuncionesGuardar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return dos;
    }
    
    public static DataInputStream AbrirFicheroLecturaBinario(String nomFichero, boolean crear) {
        DataInputStream dis = null;
        File f = AbrirFichero(nomFichero, crear);

        if (f != null) {
            // Declarar el writer para poder escribir en el fichero¡
            FileInputStream reader;
            try {
                reader = new FileInputStream(f);
                // PrintWriter para poder escribir más comodamente
                dis = new DataInputStream(reader);
            } catch (IOException ex) {
                Logger.getLogger(FuncionesGuardar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return dis;
    }
}
