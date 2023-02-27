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
        System.out.println("3. Afegir un membre a una colla");
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
                case 3:
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
            Colla coll = demanarDadesColla();
            afegirDades(coll, nomFitxer);
        }
        else{
            System.out.println("ERROR! La colla ja existeix");
        }
    }
    
    public static Colla demanarDadesColla(){
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
        System.out.println("Introdueix el nom de la colla a la que pertany: ");
        String nomColla = scan.nextLine();
        String nomFitxer = NOM_CARPETA + "/" + nomColla + ".bin";
        if(existeixColla(nomFitxer)){
            Membre mem = demanarDadesMembre();
            afegirDadesMembre(mem, nomFitxer);
        }
        else{
            System.out.println("La colla no existeix");
        }
    }
    
    public static void afegirDadesMembre(Membre mem, String nomFitx){
        DataOutputStream dos = FuncionesUtilidades.AbrirFicheroEscrituraBinario(nomFitx, true, true);
        try {
            dos.writeUTF(mem.nom);
            dos.writeInt(mem.numero);
            dos.writeFloat(mem.diners);
            dos.writeFloat(mem.premi);
        } catch (IOException ex) {
            Logger.getLogger(Colles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Membre demanarDadesMembre(){
        Membre mem = new Membre(); 
        System.out.print("Introdueix el nom: ");
        mem.nom = scan.nextLine();
        mem.numero = FuncionesUtilidades.Entero("Introdueix el numero que juga: ", LoteriaNavidad.NUMERO_MIN, LoteriaNavidad.NUMERO_MAX);
        mem.diners = FuncionesUtilidades.LeerFloat("Introdueix els diners que juga");
        mem.premi = 0;
        
        return mem;
    }   
}
