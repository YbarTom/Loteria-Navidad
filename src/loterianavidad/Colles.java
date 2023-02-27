package loterianavidad;

import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static loterianavidad.LoteriaNavidad.scan;

public class Colles {
    
    static final String NOM_CARPETA = "./colles";
    
    
    public static class Colla{
        int nMembres;
        float importTotal;
        int anySorteig;
        float premiTotal;
    }
    
    public static class Membre{
        String nom;
        int numero;
        float diners;
        float premi;
    }
    
    public static void menuColles(){
        System.out.println(FuncionsIdiomes.LlegirLineas(LoteriaNavidad.buf, 17));
        System.out.println(FuncionsIdiomes.LlegirLineas(LoteriaNavidad.buf, 18));
        System.out.println(FuncionsIdiomes.LlegirLineas(LoteriaNavidad.buf, 19));
        System.out.println(FuncionsIdiomes.LlegirLineas(LoteriaNavidad.buf, 20));
    }
    
    public static void gestionarOpcions(){
        menuColles();
        int opcio = FuncionesUtilidades.Entero(FuncionsIdiomes.LlegirLineas(LoteriaNavidad.buf, 16));
        scan.nextLine();
        while(opcio != 0){
            switch (opcio) {
                case 1:
                    crearColla();
                    break;
                case 2:
                    afegirMembre();
                    break;
                default:
                    System.out.println(FuncionsIdiomes.LlegirLineas(LoteriaNavidad.buf, 13));
                    break;
            }
            menuColles();
            opcio = FuncionesUtilidades.Entero(FuncionsIdiomes.LlegirLineas(LoteriaNavidad.buf, 16));
        }
    }
    
    public static void crearCarpetaColles(){
        File f = new File(NOM_CARPETA);
        if(!f.exists()){
            f.mkdir();
        }
    }
    
    public static void crearColla(){
        crearCarpetaColles();
        System.out.print("Introdueix el nom de la colla: ");
        String nom = scan.nextLine();
        String nomFitxer = NOM_CARPETA + "/" + nom + ".bin";
        if(!existeixColla(nomFitxer)){
            Colla coll = demanarDades();
            afegirDades(coll, nomFitxer);
        }
        else{
            System.out.println("ERROR! La colla ja existeix");
        }
    }
    
    public static Colla demanarDades(){
        Colla coll = new Colla();
        coll.nMembres = 0;
        coll.anySorteig = FuncionesUtilidades.Entero("Introdueix l'any de la colla: ");
        coll.importTotal = 0;
        coll.premiTotal = 0;
        
        return coll;
    }
    
    public static void afegirDades(Colla coll, String nomFitx){
        DataOutputStream dos = FuncionesUtilidades.AbrirFicheroEscrituraBinario(nomFitx, true, true);
        try {
            dos.writeInt(coll.anySorteig);
            dos.writeInt(coll.nMembres);
            dos.writeFloat(coll.importTotal);
            dos.writeFloat(coll.premiTotal);
        } catch (IOException ex) {
            Logger.getLogger(Colles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean existeixColla(String nom){
        boolean existeix = false;
        File f = new File(nom);
        if(f.exists()){
            existeix = true;
        }
        return existeix;
    }
    
    public static void afegirMembre(){
        
    }
}
