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
        float premiGuanyat;
        float premiCorresponent;
    }
    
    /**
     * Menu d'opcions de colles.
     */
    public static void menuColles(){
        System.out.println(FuncionsIdiomes.LlegirLineas(LoteriaNavidad.buf, 17));
        System.out.println(FuncionsIdiomes.LlegirLineas(LoteriaNavidad.buf, 18));
        System.out.println(FuncionsIdiomes.LlegirLineas(LoteriaNavidad.buf, 19));
        System.out.println(FuncionsIdiomes.LlegirLineas(LoteriaNavidad.buf, 20));
        System.out.println("4. Afegir un membre a una colla");
    }
    
    /**
     * Demana una opció i la realitza. Demanarà opcions fins introduir 0.
     */
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
                    esborrarColla();
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
    
    /**
     * Comprova que la carpeta on es guarden les colles no existeix i la crea, 
     * si ja existeix no fa res.
     */
    public static void crearCarpetaColles(){
        File f = new File(NOM_CARPETA);
        if(!f.exists()){
            f.mkdir();
        }
    }
    
    /**
     * Demana el nom de la colla i crea el seu arxiu corresponent amb la informació bàsica necessària.
     * Si la colla ja existeix mostra un missatge d'error i no fa res.
     */
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
    
    /**
     * Demana el nom d'una colla i la esborra. Si la colla introduida no existeix
     * mostra un missatge d'error i no fa res.
     */
    public static void esborrarColla(){
        System.out.print("Introdueix el nom de la colla: ");
        String nom = scan.nextLine();
        String nomFitxer = NOM_CARPETA + nom + ".bin";
        String nomIndex = nomFitxer + ".index";
        if(existeixColla(nomFitxer)){
            File f = new File(nomFitxer);
            File index = new File(nomIndex);
            f.delete();
            index.delete();
        }
        else{
            System.out.println("ERROR! La colla no existeix");
        }
    }
    
    /**
     * Mostra tota la informació d'una colla.
     * @param nomFitxer El path al fitxer que conté la informació de la colla
     */
    public static void mostrarDadesColla(String nomFitxer){   
        DataInputStream dis = FuncionesUtilidades.AbrirFicheroLecturaBinario(nomFitxer, true);
        try {
            mostrarInfoColla(dis);
            System.out.println("Info Membres: ");
            while(dis.available() > 0){
                mostrarInfoMembre(dis);
            }
        } catch (IOException ex) {
            Logger.getLogger(Colles.class.getName()).log(Level.SEVERE, null, ex);
        }
        FuncionesUtilidades.CerrarLecturaBinario(dis);
    }
    
    /**
     * Mostra la informació bàsica de la colla.
     * @param dis El canal de lectura de dades, estarà vinculat a l'arxiu que 
     * conté la informació de la colla.
     */
    public static void mostrarInfoColla(DataInputStream dis){
        try {
            System.out.println("Info Colla: ");
            System.out.println("Any: " + dis.readInt());
            System.out.println("Membres: " + dis.readInt());
            System.out.println("Diners: " + dis.readFloat());
            System.out.println("Premi: " + dis.readFloat());
        } catch (IOException ex) {
            Logger.getLogger(Colles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Mostra l'informació d'un membre.
     * @param dis El canal de lectura de dades, estarà vinculat a l'arxiu que 
     * conté la informació de la colla.
     */
    public static void mostrarInfoMembre(DataInputStream dis){
        try {
            System.out.println("Nom: " + dis.readUTF());
            System.out.println("Numero: " + dis.readInt());
            System.out.println("Diners: " + dis.readFloat());
            System.out.println("Premi del seu número: " + dis.readFloat());
            System.out.println("Premi corresponent per la colla: " + dis.readFloat());
        } catch (IOException ex) {
            Logger.getLogger(Colles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Demana les dades de la colla i les guarda a un arxiu binari.
     * @param nomFitxer El path de l'arxiu on guardarem la informació de la colla.
     */
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
    
    /**
     * Escriu les dades d'un registre Colla a un fitxer binari.
     * @param coll El registre amb la informació.
     * @param nomFitx El path a l'arxiu on guardarem les dades.
     */
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
        FuncionesUtilidades.CerrarEscrituraBinario(dos);
    }
    
    /**
     * Comprova si existeix una colla.
     * @param nomFitxer El path a on buscarem si l'arxiu existeix.
     * @return true si existeix i false si no existeix.
     */
    public static boolean existeixColla(String nomFitxer){
        boolean existeix = false;
        File f = new File(nomFitxer);
        if(f.exists()){
            existeix = true;
        }
        return existeix;
    }
    
    /**
     * Demana la informació d'un membre i l'introdueix a la colla seleccionada.
     */
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
    
    /**
     * Suma l'import jugat d'un membre al total de la colla.
     * @param nomFitxer El path al fitxer on tenim la informació de la colla.
     * @param mem El registre que conté la informació del membre.
     */
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
        FuncionesUtilidades.cerrarAccesoDirecto(raf);
    }
    
    /**
     * Suma un membre a la quantitat de membres que té una colla.
     * @param nomFitxerColla El path a l'arxiu on tenim la informació de la colla.
     */
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
        FuncionesUtilidades.cerrarAccesoDirecto(raf);
    }
    
    /**
     * Escriu les dades d'un membre al fitxer de la colla corresponent.
     * @param mem El registre que conté la informació del membre.
     * @param nomFitx El path a l'arxiu on tenim la informació de la colla.
     */
    public static void afegirDadesMembre(Membre mem, String nomFitx){
        RandomAccessFile raf = FuncionesUtilidades.AbrirAccesoDirecto(nomFitx, "rw");
        try {
            raf.seek(raf.length());
            afegirMembreIndex(raf, nomFitx);
            raf.writeUTF(mem.nom);
            raf.writeInt(mem.numero);
            raf.writeFloat(mem.diners);
            raf.writeFloat(mem.premiGuanyat);
            raf.writeFloat(mem.premiCorresponent);
        } catch (IOException ex) {
            Logger.getLogger(Colles.class.getName()).log(Level.SEVERE, null, ex);
        }
        FuncionesUtilidades.cerrarAccesoDirecto(raf);
    }
    
    /**
     * Escriu la posició d'un membre al fitxer d'indexs.
     * @param raf Canal d'escritura/lectura que ens permetrà saber la posició per guardarla.
     * @param nomFitx El path a l'arxiu d'indexs on tenim la posició dels diferents membres.
     */
    public static void afegirMembreIndex(RandomAccessFile raf, String nomFitx){
        String nomFitxIndex = nomFitx + ".index";
        DataOutputStream dos = FuncionesUtilidades.AbrirFicheroEscrituraBinario(nomFitxIndex, true, true);
        try {
            dos.writeLong(raf.getFilePointer());
        } catch (IOException ex) {
            Logger.getLogger(Colles.class.getName()).log(Level.SEVERE, null, ex);
        }
        FuncionesUtilidades.CerrarEscrituraBinario(dos);
    }   
    
    /**
     * Demana i llegeix les dades d'un membre nou.
     * @return Un registre tipus Membre amb les dades introduides.
     */
    public static Membre demanarDadesMembre(){
        Membre mem = new Membre(); 
        System.out.print("Introdueix el nom: ");
        mem.nom = scan.nextLine();
        mem.numero = FuncionesUtilidades.Entero("Introdueix el numero que juga: ", LoteriaNavidad.NUMERO_MIN, LoteriaNavidad.NUMERO_MAX);
        mem.diners = FuncionesUtilidades.LeerFloat("Introdueix els diners que juga");
        mem.premiGuanyat = 0;
        mem.premiCorresponent = 0;
        
        return mem;
    }
    
    /**
     * Llegeix els premis d'un sorteig i els carrega als arrays corresponents.
     * @param nomFitxAny El path al arxiu on tenim guardats els premis que ens interessen.
     * @param premisGrans L'array on guardarem els premis grans (premis >= 60000) 
     * @param llistaPremis Array on guardarem tots els números premiats amb el seu corresponent premi.
     */
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
        FuncionesUtilidades.CerrarLecturaBinario(dis);
    }
    
    /**
     * Comprova la quantitat guanyada de premi d'un cert número.
     * @param nomFitxAny El path al fitxer on es contenen els premis que volem.
     * @param numero El número que volem comprovar.
     * @return Un enter que representa la quantitat de diners guanyats amb el número donat.
     */
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
        String nomFitxerIndex = nomFitxerColla + ".index";
            
        if(existeixColla(nomFitxerColla)){
            RandomAccessFile raf = FuncionesUtilidades.AbrirAccesoDirecto(nomFitxerColla, "rw");
            RandomAccessFile rafIndex = FuncionesUtilidades.AbrirAccesoDirecto(nomFitxerIndex, "r");
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
            assignarPremisCorresponents(nomFitxerIndex, nomFitxerColla);
            FuncionesUtilidades.cerrarAccesoDirecto(raf);
            FuncionesUtilidades.cerrarAccesoDirecto(rafIndex);
            
            mostrarDadesColla(nomFitxerColla);
        }
        else{
            System.out.println("ERROR! Aquesta colla no existeix");
        }
    }
    
    public static void assignarPremisCorresponents(String nomFitxIndex, String nomFitxColla){
        DataInputStream dis = FuncionesUtilidades.AbrirFicheroLecturaBinario(nomFitxIndex, true);
        RandomAccessFile raf = FuncionesUtilidades.AbrirAccesoDirecto(nomFitxColla, "rw");
        
        try {
            raf.seek(8);
            float dinersJugatsTotals = raf.readFloat();
            float premiTotal = raf.readFloat();
            float premiPerEuro = premiTotal/dinersJugatsTotals;
            while(dis.available() > 0){
                long posicio = dis.readLong();
                raf.seek(posicio);
                raf.readUTF();
                raf.seek(raf.getFilePointer()+4);
                float importJugat = raf.readFloat();
                float premiCorresponent = premiPerEuro*importJugat;
                raf.seek(raf.getFilePointer()+4);
                raf.writeFloat(premiCorresponent);
            }
        } catch (IOException ex) {
            Logger.getLogger(Colles.class.getName()).log(Level.SEVERE, null, ex);
        }
        FuncionesUtilidades.CerrarLecturaBinario(dis);
        FuncionesUtilidades.cerrarAccesoDirecto(raf);
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
                raf.seek(raf.getFilePointer()+4);
            }
            raf.seek(12);
            raf.writeFloat(premiTotal);
        } catch (IOException ex) {
            Logger.getLogger(Colles.class.getName()).log(Level.SEVERE, null, ex);
        }
        FuncionesUtilidades.CerrarLecturaBinario(dis);
        FuncionesUtilidades.cerrarAccesoDirecto(raf);
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
        
        FuncionesUtilidades.CerrarLecturaBinario(dis);
        
        return anyFinal;
    }
}
