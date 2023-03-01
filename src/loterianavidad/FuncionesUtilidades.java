package loterianavidad;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import static loterianavidad.LoteriaNavidad.scan;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
public class FuncionesUtilidades {

    public static float LeerFloat(String missatge) {
        float numero = 0;
        
        boolean correcte = false;
        System.out.println(missatge);

        do {
            if (scan.hasNextFloat()) {
                numero = scan.nextFloat();
                correcte = true;
            } else {
                scan.next();
                System.out.println("El número no és un decimal, torna a introduir-lo: ");
            }
        } while (correcte == false);
        return numero;
    }
    
    public static float LeerDinero(String missatge) {
        float numero = 0;
        final float DINERS_MIN = 5;
        final float DINERS_MAX = 60;

        boolean correcte = false;
        System.out.println(missatge);

        do {
            if (scan.hasNextFloat()) {
                numero = scan.nextFloat();
                if(numero > DINERS_MAX || numero < DINERS_MIN || numero % 5 != 0){
                    System.out.println(FuncionsIdiomes.LlegirLineas(LoteriaNavidad.buf, 4));
                    
                }
                else{
                    correcte = true;
                }
            } else {
                scan.next();
                System.out.println(FuncionsIdiomes.LlegirLineas(LoteriaNavidad.buf, 5));
            }
        } while (correcte == false);
        return numero;
    }
    
    /**
     * Demana entrades per consola fins que se li dona un número enter que estigui dins del nostre interval.
     *
     * @param missatge Un missatge per demanar el número
     * @return El número enter en qüestió
     */
    public static int Entero(String missatge) {
        int numero = 0;
        
        boolean correcte = false;
        System.out.println(missatge);

        do {
            if (scan.hasNextInt()) {
                numero = scan.nextInt();
                correcte = true;
            } else {
                scan.next();
                System.out.println(FuncionsIdiomes.LlegirLineas(LoteriaNavidad.buf, 15));
            }
        } while (correcte == false);
        return numero;
    }
    
    /**
     * Demana entrades per consola fins que se li dona un número enter que estigui dins del nostre interval.
     *
     * @param missatge Un missatge per demanar el número
     * @param min
     * @param max
     * @return El número enter en qüestió
     */
    public static int Entero(String missatge, int min, int max) {
        int numero = 0;

        boolean correcte = false;
        System.out.println(missatge);

        do {
            if (scan.hasNextInt()) {
                numero = scan.nextInt();
                if(numero > max || numero < min){
                    System.out.println(FuncionsIdiomes.LlegirLineas(LoteriaNavidad.buf, 4));
                    
                }
                else{
                    correcte = true;
                }
            } else {
                scan.next();
                System.out.println(FuncionsIdiomes.LlegirLineas(LoteriaNavidad.buf, 5));
            }
        } while (correcte == false);
        return numero;
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

    public static RandomAccessFile AbrirAccesoDirecto(String nomFitxer, String mode){
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(nomFitxer, mode);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FuncionesUtilidades.class.getName()).log(Level.SEVERE, null, ex);
        }
        return raf;
    }
    
    public static void CerrarEscrituraBinario(DataOutputStream dos) {
        try {
            dos.flush();
            dos.close();
        } catch (IOException ex) {
            Logger.getLogger(FuncionesUtilidades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void CerrarLecturaBinario(DataInputStream dis) {
        try {
            dis.close();
        } catch (IOException ex) {
            Logger.getLogger(FuncionesUtilidades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void cerrarAccesoDirecto(RandomAccessFile raf){
        try {
            raf.close();
        } catch (IOException ex) {
            Logger.getLogger(FuncionesUtilidades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
