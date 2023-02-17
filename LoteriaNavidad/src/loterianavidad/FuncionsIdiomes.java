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

    /**
     * Funció menu per a mostar la selecció d'idioma
     */
    public static int MenuIdiomes() {
        int opcio;

        System.out.println("1-Català");
        System.out.println("2-Español");
        System.out.println("3-English");
        System.out.println("Introdueix el numero de l'idioma que vols: ");
        opcio = scan.nextInt();

        return opcio;
    }

    /**
     * Funció per a seleccionar el fitxer on estan els missatges amb l'idioma
     * seleccionat
     *
     * @param opcio opcio seleccionada
     */
    public static String SelectorFitxer(int opcio) {

        String idioma = "";

        switch (opcio) {
            case 1:
                //nom del fitxer
                idioma = "./catala.txt";
                break;
            case 2:
                //nom del fitxer
                idioma = "./espanol.txt";
                break;
            case 3:
                //nom del fitxer
                idioma = "./english.txt";
                break;
        }
        return idioma;
    }

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

    public static String  LlegirLineas(BufferedReader buf, int linea) {
        String linia="";
        try {
            
            
            
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
}
