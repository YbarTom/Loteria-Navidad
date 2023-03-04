/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package loterianavidad;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import static loterianavidad.Colles.NOM_CARPETA;
import static loterianavidad.Colles.anySorteigColla;
import static loterianavidad.Colles.importJugat;
import static loterianavidad.Colles.numeroJugador;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ausias
 */
public class CollesTest {

    public CollesTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of menuColles method, of class Colles. Aquest procediment no es pot
     * comprobar ja que l'unic que fa es imprimir, i no modifica cap valor que
     * poguem mirar si s'ha cambiat.
     */
    /*@Test
    public void testMenuColles() {
        System.out.println("menuColles");
        Colles.menuColles();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    /**
     * Test of gestionarOpcions method, of class Colles. Aquest procediment no
     * es pot comprobar ja que crida a una funcio que requereix que l'usuari
     * introdueixi valor per teclat.
     */
    /*@Test
    public void testGestionarOpcions() {
        System.out.println("gestionarOpcions");
        Colles.gestionarOpcions();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    /**
     * Test of crearCarpetaColles method, of class Colles. El que fem a aquest
     * test es cridar al procediment crearCarpetaColles per mirar si la carpeta
     * està creada, si no ho està la creara. Llavors declarem un boolean a
     * false, si la carpeta està creada despres de la crida a la funcio el
     * boolean es posara true.
     */
    @Test
    public void testCrearCarpetaColles() {
        File f = new File(NOM_CARPETA);
        boolean result = false;
        boolean expResult = true;
        System.out.println("crearCarpetaColles");
        Colles.crearCarpetaColles();
        if (f.exists()) {
            result = true;
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of crearColla method, of class Colles. Aquest procediment requereix
     * que l'usuari introdueixi dades per teclat, per aixo no es pot comprobar
     */
    /*@Test
    public void testCrearColla() {
        System.out.println("crearColla");
        Colles.crearColla();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    /**
     * Test of esborrarColla method, of class Colles. Aquest procediment
     * requereix que l'usuari introdueixi dades per teclat, per aixo no es pot
     * comprobar
     */
    /*@Test
    public void testEsborrarColla() {
        System.out.println("esborrarColla");
        Colles.esborrarColla();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    /**
     * Test of mostrarDadesColla method, of class Colles. Al ser un procediment
     * que imprimeix dades per pantalla, no la podem comprobar
     */
    /*@Test
    public void testMostrarDadesColla() {
        System.out.println("mostrarDadesColla");
        String nomFitxer = "";
        Colles.mostrarDadesColla(nomFitxer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    /**
     * Test of mostrarInfoColla method, of class Colles. Al ser un procediment
     * que imprimeix dades per pantalla, no la podem comprobar
     */
    /*@Test
    public void testMostrarInfoColla() {
        System.out.println("mostrarInfoColla");
        DataInputStream dis = null;
        Colles.mostrarInfoColla(dis);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    /**
     * Test of mostrarInfoMembre method, of class Colles. Al ser un procediment
     * que imprimeix dades per pantalla, no la podem comprobar
     */
    /*@Test
    public void testMostrarInfoMembre() {
        System.out.println("mostrarInfoMembre");
        DataInputStream dis = null;
        Colles.mostrarInfoMembre(dis);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    /**
     * Test of demanarDadesColla method, of class Colles. Aquest procediment
     * crida a una funcio que demana dades per teclat a l'usuari, no ho podem
     * comprobar
     */
    /*@Test
    public void testDemanarDadesColla() {
        System.out.println("demanarDadesColla");
        String nomFitxer = "";
        Colles.demanarDadesColla(nomFitxer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    /**
     * Test of afegirDades method, of class Colles. no podem comprobar aquest
     * procediment ja que hauriem de crear dos fitxers binaris nomes per a
     * aquesta funcio i cridar a funcions que requereixen de que l'usuari
     * introdueixi dades
     */
    /*@Test
    public void testAfegirDades() {
        System.out.println("afegirDades");
        Colles.Colla coll = null;
        String nomFitx = "";
        Colles.afegirDades(coll, nomFitx);
        // TODO review the generated test code and remove the default call to fail.
    }*/
    /**
     * Test of existeixColla method, of class Colles. Cridem a la funcio
     * existeix colla per a que retorni true si el fitxer que li diem que
     * comprobi exiseix, previament ja sabem que el fitxer existeix llavors
     * declarem el expResult coma true
     */
    @Test
    public void testExisteixColla() {
        System.out.println("existeixColla");
        String nomFitxer = "./colles/rupamito.bin";
        boolean expResult = true;
        boolean result = Colles.existeixColla(nomFitxer);
        assertEquals(expResult, result);

    }

    /**
     * Test of afegirMembre method, of class Colles. no podem comprobar el
     * procediment ja que requereix que l'usuari introdueixi dades per teclat
     */
    /*@Test
    public void testAfegirMembre() {
        System.out.println("afegirMembre");
        Colles.afegirMembre();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    /**
     * Test of sumarImport method, of class Colles. no podem comprobar el
     * procediment ja que hauriem de crear un fitxer per a simular tot i llavors
     * necesitariem accedir a funcions que demanen a l'usuari introduir dades
     * per teclat
     */
    /*@Test
    public void testSumarImport() {
        System.out.println("sumarImport");
        String nomFitxer = "";
        Colles.Membre mem = null;
        Colles.sumarImport(nomFitxer, mem);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    /**
     * Test of sumarMembre method, of class Colles. no podem comprobar el
     * procediment ja que hauriem de crear un fitxer per a simular tot i llavors
     * necesitariem accedir a funcions que demanen a l'usuari introduir dades
     * per teclat
     */
    /*@Test
    public void testSumarMembre() {
        System.out.println("sumarMembre");
        String nomFitxerColla = "";
        Colles.sumarMembre(nomFitxerColla);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    /**
     * Test of afegirDadesMembre method, of class Colles. no podem comprobar el
     * procediment ja que hauriem de crear un fitxer per a simular tot i llavors
     * necesitariem accedir a funcions que demanen a l'usuari introduir dades
     * per teclat
     */
    /*@Test
    public void testAfegirDadesMembre() {
        System.out.println("afegirDadesMembre");
        Colles.Membre mem = null;
        String nomFitx = "";
        Colles.afegirDadesMembre(mem, nomFitx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    /**
     * Test of afegirMembreIndex method, of class Colles. no podem comprobar el
     * procediment ja que hauriem de crear un fitxer per a simular tot i llavors
     * necesitariem accedir a funcions que demanen a l'usuari introduir dades
     * per teclat
     */
    /*@Test
    public void testAfegirMembreIndex() {
        System.out.println("afegirMembreIndex");
        RandomAccessFile raf = null;
        String nomFitx = "";
        Colles.afegirMembreIndex(raf, nomFitx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    /**
     * Test of demanarDadesMembre method, of class Colles. No podem comprobar
     * aquest procediment ja que el que fa es imprimir.
     */
    /*@Test
    public void testDemanarDadesMembre() {
        System.out.println("demanarDadesMembre");
        Colles.Membre expResult = null;
        Colles.Membre result = Colles.demanarDadesMembre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    /**
     * Test of comprovarPremi method, of class Colles.
     */
    @Test
    public void testComprovarPremi() {
        String nomFitxAny = "./sorteos/2000.bin";
        int numero = 31347;
        int expResult = 4000000;
        int result = Colles.comprovarPremi(nomFitxAny, numero);
        assertEquals(expResult, result);
    }

    /**
     * Test of demanarDadesComprovar method, of class Colles. Aquesta funció no
     * es pot comprovar perquè l'usuari ha d'introduïr dades
     */
    /*@Test
    public void testDemanarDadesComprovar() {
        System.out.println("demanarDadesComprovar");
        Colles.demanarDadesComprovar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
     */
    /**
     * Test of assignarPremisCorresponents method, of class Colles. Aquesta
     * funció no es pot comprovar perquè simplement imprimieix el que ha llegit
     * després d'algunes operacions, no retorna res ni modifica un objecte
     */
    /*@Test
    public void testAssignarPremisCorresponents() {
        System.out.println("assignarPremisCorresponents");
        String nomFitxIndex = "";
        String nomFitxColla = "";
        Colles.assignarPremisCorresponents(nomFitxIndex, nomFitxColla);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of acumularPremisColla method, of class Colles.
     * Aquesta funció no es pot comprovar perquè simplement imprimieix el que ha llegit
     * després d'algunes operacions, no retorna res ni modifica un objecte
     */
 /*@Test
    public void testAcumularPremisColla() {
        System.out.println("acumularPremisColla");
        String nomFitxIndex = "";
        String nomFitxColla = "";
        Colles.acumularPremisColla(nomFitxIndex, nomFitxColla);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
     */
    /**
     * Test of escribirPremio method, of class Colles. Aquesta funció no es pot
     * comprovar perquè simplement imprimieix el que li entra no retorna res ni
     * modifica un objecte
     */
    /*@Test
    public void testEscribirPremio() {
        System.out.println("escribirPremio");
        RandomAccessFile raf = null;
        float premi = 0.0F;
        Colles.escribirPremio(raf, premi);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
     */
    /**
     * Test of importJugat method, of class Colles.
     */
    @Test
    public void testImportJugat() {
        String nomFitxerColla = NOM_CARPETA + "rupamito" + ".bin";
        String nomFitxerIndex = nomFitxerColla + ".index";
        RandomAccessFile raf = FuncionesUtilidades.AbrirAccesoDirecto(nomFitxerColla, "rw");
        RandomAccessFile rafIndex = FuncionesUtilidades.AbrirAccesoDirecto(nomFitxerIndex, "r");
        int any = anySorteigColla(nomFitxerColla);
        String nomFitxAny = LoteriaNavidad.CARPETA + any + ".bin";
        int numeroJugador = numeroJugador(raf, rafIndex);
        float expResult = 60;
        float result = importJugat(raf);
        assertEquals(expResult, result, 0);
    }

    /**
     * Test of numeroJugador method, of class Colles.
     */
    @Test
    public void testNumeroJugador() {

        String nomFitxerColla = NOM_CARPETA + "rupamito" + ".bin";
        String nomFitxerIndex = nomFitxerColla + ".index";
        RandomAccessFile raf = FuncionesUtilidades.AbrirAccesoDirecto(nomFitxerColla, "rw");
        RandomAccessFile rafIndex = FuncionesUtilidades.AbrirAccesoDirecto(nomFitxerIndex, "r");

        int expResult=49308;
        
        int result = Colles.numeroJugador(raf, rafIndex);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of anySorteigColla method, of class Colles. no la podem comprobar ja
     * que necessitariem un fitxer per a testejar funcions. i llavors cridariem
     * a funcions que demanen dades per teclat a l'usuari
     */
    /*@Test
    public void testAnySorteigColla() {
        System.out.println("anySorteigColla");
        String nomFitxer = "";
        int expResult = 0;
        int result = Colles.anySorteigColla(nomFitxer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
}
