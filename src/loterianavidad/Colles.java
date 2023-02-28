package loterianavidad;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import static loterianavidad.LoteriaNavidad.CARPETA;
import static loterianavidad.LoteriaNavidad.PREMISIMPORTANTS;
import static loterianavidad.LoteriaNavidad.TOTPREMS;
import static loterianavidad.LoteriaNavidad.scan;

public class Colles {
    
    static final String NOM_CARPETA = "./colles/";
    
    static final int IMPORT_NUMERO = 200;
    
    
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
        System.out.println("4. Afegir un membre a una colla");
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
                    break;
                case 3:
                    demanarDadesComprovar();
                    
                    break;
                case 4:
                    afegirMembre();
                    break;
                default:
                    System.out.println(FuncionsIdiomes.LlegirLineas(LoteriaNavidad.buf, 13));
                    break;
            }
            menuColles();
            opcio = FuncionesUtilidades.Entero(FuncionsIdiomes.LlegirLineas(LoteriaNavidad.buf, 16));
            scan.nextLine();
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
        String nomFitxer = NOM_CARPETA + nom + ".bin";
        if(!existeixColla(nomFitxer)){
            demanarDadesColla(nomFitxer);
        }
        else{
            System.out.println("ERROR! La colla ja existeix");
        }
    }
    
    public static void demanarDadesColla(String nomFitxer){
        Colla coll = new Colla();
        coll.nMembres = 0;
        
        int any = FuncionesUtilidades.Entero("Introdueix l'any de la colla: ");
        String anySorteig = CARPETA + any + ".bin";
        File f = new File(anySorteig);
        if(f.exists()){
            coll.anySorteig = any;
            coll.importTotal = 0;
            coll.premiTotal = 0;
            afegirDades(coll, nomFitxer);
        } else {
            System.out.println("ERROR! No s'ha fet sorteig d'aquest any, primer l'has de fer");
        }
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
        String nomFitxer = NOM_CARPETA + nomColla + ".bin";
        if(existeixColla(nomFitxer)){
            Membre mem = demanarDadesMembre();
            afegirDadesMembre(mem, nomFitxer);
            sumarMembre(nomFitxer);
            sumarImport(nomFitxer, mem);
        }
        else{
            System.out.println("La colla no existeix");
        }
    }
    
    public static void sumarImport(String nomFitxer, Membre mem){
        RandomAccessFile raf = FuncionesUtilidades.AbrirAccesoDirecto(nomFitxer, "rw");
        try {
            raf.seek(8);
            float importFinal = raf.readFloat() + mem.diners;
            raf.seek(8);
            raf.writeFloat(importFinal);
        } catch (IOException ex) {
            Logger.getLogger(Colles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void sumarMembre(String nomFitxerColla){
        RandomAccessFile raf = FuncionesUtilidades.AbrirAccesoDirecto(nomFitxerColla, "rw");
        try {
            raf.seek(4);
            int nMembres = raf.readInt();
            ++nMembres;
            raf.seek(4);
            raf.writeInt(nMembres);
        } catch (IOException ex) {
            Logger.getLogger(Colles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void afegirDadesMembre(Membre mem, String nomFitx){
        RandomAccessFile raf = FuncionesUtilidades.AbrirAccesoDirecto(nomFitx, "rw");
        try {
            raf.seek(raf.length()-1);
            afegirMembreIndex(raf, nomFitx);
            raf.writeUTF(mem.nom);
            raf.writeInt(mem.numero);
            raf.writeFloat(mem.diners);
            raf.writeFloat(mem.premi);
        } catch (IOException ex) {
            Logger.getLogger(Colles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void afegirMembreIndex(RandomAccessFile raf, String nomFitx){
        String nomFitxIndex = nomFitx + "index";
        DataOutputStream dos = FuncionesUtilidades.AbrirFicheroEscrituraBinario(nomFitxIndex, true, true);
        try {
            dos.writeLong(raf.getFilePointer());
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
    
    public static void llegirPremis(String nomFitxAny, int[] premisGrans, LoteriaNavidad.NumPremiat[] llistaPremis){
        DataInputStream dis = FuncionesUtilidades.AbrirFicheroLecturaBinario(nomFitxAny, true);
        for(int i = 0; i < LoteriaNavidad.TOTPREMS; ++i){
            llistaPremis[i] = new LoteriaNavidad.NumPremiat();
            try {
                int numero = dis.readInt();
                int premi = dis.readInt();
                llistaPremis[i].numero = numero;
                llistaPremis[i].premi = premi;
                FuncionesGuardar.guardarGrans(numero, premi, premisGrans);
            } catch (IOException ex) {
                Logger.getLogger(Colles.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            dis.close();
        } catch (IOException ex) {
            Logger.getLogger(Colles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static int comprovarPremi(String nomFitxAny, int numero){
        int premi;
        
        LoteriaNavidad.NumPremiat VectorPremi[] = new LoteriaNavidad.NumPremiat[TOTPREMS];
        int[] premis = new int[PREMISIMPORTANTS];
        
        llegirPremis(nomFitxAny, premis, VectorPremi);
        
        premi = FuncionesComprobacion.comprovacioGeneral(numero, premis, VectorPremi);
        
        return premi;
    }
    
    public static void demanarDadesComprovar(){
        System.out.print("Introdueix la colla que vols comprovar: ");
        String nomColla = scan.nextLine();
        String nomFitxerColla = NOM_CARPETA + nomColla + ".bin";
        String nomFitxerIndex = nomFitxerColla + "index";
        
        RandomAccessFile raf = FuncionesUtilidades.AbrirAccesoDirecto(nomFitxerColla, "rw");
        RandomAccessFile rafIndex = FuncionesUtilidades.AbrirAccesoDirecto(nomFitxerIndex, "r");    
        if(existeixColla(nomFitxerColla)){
            int any = anySorteigColla(nomFitxerColla);
            String nomFitxAny = LoteriaNavidad.CARPETA + any + ".bin";
            int numeroJugador = numeroJugador(raf, rafIndex);
            while(numeroJugador != -1){
                float importJugat = importJugat(raf);
                float premi = (comprovarPremi(nomFitxAny, numeroJugador) * importJugat) / IMPORT_NUMERO;
                escribirPremio(raf, premi);
                numeroJugador = numeroJugador(raf, rafIndex);
            }
            acumularPremisColla(nomFitxerIndex, nomFitxerColla);
        }
        else{
            System.out.println("ERROR! Aquesta colla no existeix");
        }
    }
    
    public static void acumularPremisColla(String nomFitxIndex, String nomFitxColla){
        DataInputStream dis = FuncionesUtilidades.AbrirFicheroLecturaBinario(nomFitxIndex, true);
        RandomAccessFile raf = FuncionesUtilidades.AbrirAccesoDirecto(nomFitxColla, "rw");
        
        float premiTotal = 0;
        try {
            while(dis.available() > 0){
                long posicion = dis.readLong();
                raf.seek(posicion);
                raf.readUTF();
                raf.seek(raf.getFilePointer()+8);
                premiTotal += raf.readFloat();
            }
            raf.seek(12);
            raf.writeFloat(premiTotal);
        } catch (IOException ex) {
            Logger.getLogger(Colles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void escribirPremio(RandomAccessFile raf, float premi){
        try {
            raf.writeFloat(premi);
        } catch (IOException ex) {
            Logger.getLogger(Colles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static float importJugat(RandomAccessFile raf){
        float importJugador = 0;
        
        try {
            importJugador = raf.readFloat();
        } catch (IOException ex) {
            Logger.getLogger(Colles.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return importJugador;
    }
    
    public static int numeroJugador(RandomAccessFile raf, RandomAccessFile rafIndex){
        int numero;
        
        try {
            long posicion = rafIndex.readLong();
            raf.seek(posicion);
            raf.readUTF();
            numero = raf.readInt();
            
        } catch (IOException ex) {
            numero = -1;
        }
        
        return numero;
    }
    
    public static int anySorteigColla(String nomFitxer){
        int anyFinal = 0;
        
        DataInputStream dis = FuncionesUtilidades.AbrirFicheroLecturaBinario(nomFitxer, true);
        
        try {
            anyFinal = dis.readInt();
        } catch (IOException ex) {
            Logger.getLogger(Colles.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return anyFinal;
    }
}
