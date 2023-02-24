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
     * Funció menu per a mostar la selecció d'idioma
     */
    public static String MenuIdiomes() {
        
        String nomFitxer;
        
        File carpeta = new File("./idiomes");
        String [] llista = carpeta.list();
        
        for(int i=0;i<llista.length;i++){
            System.out.println(llista[i]);
        }
        
        System.out.println("Introdueix el nom de l'idioma que vols: ");
        nomFitxer = scan.nextLine();
        
        idioma+=nomFitxer;
        
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
    
    public static BufferedReader TancarObrirBuf(BufferedReader buf) throws IOException{
        buf.close();
        buf=ObrirArxiu(idioma);
        
        return buf;
    }
}
