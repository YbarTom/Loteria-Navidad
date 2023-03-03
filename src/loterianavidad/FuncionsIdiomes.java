/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loterianavidad;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static loterianavidad.LoteriaNavidad.scan;

/**
 *
 * @author ausias
 */
public class FuncionsIdiomes {
    
    static String idioma="./idiomes/";
    
    
    /**
     * Funció menu per a mostar la selecció d'idioma.
     * @return El path a l'arxiu d'idioma seleccionat.
     */
    public static String MenuIdiomes() {

        String nomFitxer;

        File carpeta = new File("./idiomes/");
        String [] llista = carpeta.list();

        for(int i=0;i<llista.length;i++){
            System.out.println(llista[i]);
        }

        System.out.println("Introdueix el nom de l'idioma que vols: ");
        nomFitxer = scan.nextLine();

        idioma+=nomFitxer;
        
        boolean valid = false;
        while(!valid){
            File f = new File(idioma);
            if(f.exists()){
                valid = true;
            }
            else{
                System.out.println("ERROR! Opció no vàlida, trona a introduir-la: ");
                nomFitxer = scan.nextLine();
                idioma = idioma.substring(0, 10) + nomFitxer;
            }
        }

        return idioma;
    }

    /**
     * Obre un canal de lectura d'un arxiu de text.
     * @param idioma El path a l'arxiu de l'idioma.
     * @return El canal de lectura vinculat a l'arxiu.
     */
    public static BufferedReader ObrirArxiu(String idioma) {

        BufferedReader buffer = null;

        try {
            File arxiu = new File(idioma);
            FileReader reader = new FileReader(arxiu);
            buffer = new BufferedReader(reader);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FuncionsIdiomes.class.getName()).log(Level.SEVERE, null, ex);
        }

        return buffer;
    }

    /**
     * Llegeix certa línea d'un arxiu de text i ho retorna com a String.
     * @param buf El canal de lectura vinculat a l'arxiu de l'idioma.
     * @param linea La línia de l'arxiu que volem llegir.
     * @return La línia llegida a l'arxiu en format String.
     */
    public static String  LlegirLineas(BufferedReader buf, int linea) {
        String linia="";
        try {
            
            buf=TancarObrirBuf(buf);
            
            if (linea == 1) {
                linia = buf.readLine();
                
            } else {

                for (int i = 1; i <= linea; i++) {
                    linia=buf.readLine();
                }
                
            }
            
        } catch (IOException ex) {
            Logger.getLogger(FuncionsIdiomes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return linia;
    }
    
    /**
     * Reiniciar el canal de lectura de l'arxiu.
     * @param buf El canal de lectura.
     * @return El canal de lectura reiniciat.
     */
    public static BufferedReader TancarObrirBuf(BufferedReader buf){
        try {
            
            buf.close();
            buf=ObrirArxiu(idioma);
            
        } catch (IOException ex) {
            Logger.getLogger(FuncionsIdiomes.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        return buf;
    }
}
