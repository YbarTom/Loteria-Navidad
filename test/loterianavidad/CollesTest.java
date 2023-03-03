/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package loterianavidad;

import java.io.DataInputStream;
import java.io.RandomAccessFile;
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
     * Test of menuColles method, of class Colles.
     */
    @Test
    public void testMenuColles() {
        System.out.println("menuColles");
        Colles.menuColles();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of gestionarOpcions method, of class Colles.
     */
    @Test
    public void testGestionarOpcions() {
        System.out.println("gestionarOpcions");
        Colles.gestionarOpcions();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crearCarpetaColles method, of class Colles.
     */
    @Test
    public void testCrearCarpetaColles() {
        System.out.println("crearCarpetaColles");
        Colles.crearCarpetaColles();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crearColla method, of class Colles.
     */
    @Test
    public void testCrearColla() {
        System.out.println("crearColla");
        Colles.crearColla();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of esborrarColla method, of class Colles.
     */
    @Test
    public void testEsborrarColla() {
        System.out.println("esborrarColla");
        Colles.esborrarColla();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarDadesColla method, of class Colles.
     */
    @Test
    public void testMostrarDadesColla() {
        System.out.println("mostrarDadesColla");
        String nomFitxer = "";
        Colles.mostrarDadesColla(nomFitxer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarInfoColla method, of class Colles.
     */
    @Test
    public void testMostrarInfoColla() {
        System.out.println("mostrarInfoColla");
        DataInputStream dis = null;
        Colles.mostrarInfoColla(dis);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarInfoMembre method, of class Colles.
     */
    @Test
    public void testMostrarInfoMembre() {
        System.out.println("mostrarInfoMembre");
        DataInputStream dis = null;
        Colles.mostrarInfoMembre(dis);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of demanarDadesColla method, of class Colles.
     */
    @Test
    public void testDemanarDadesColla() {
        System.out.println("demanarDadesColla");
        String nomFitxer = "";
        Colles.demanarDadesColla(nomFitxer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of afegirDades method, of class Colles.
     */
    @Test
    public void testAfegirDades() {
        System.out.println("afegirDades");
        Colles.Colla coll = null;
        String nomFitx = "";
        Colles.afegirDades(coll, nomFitx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of existeixColla method, of class Colles.
     */
    @Test
    public void testExisteixColla() {
        System.out.println("existeixColla");
        String nomFitxer = "";
        boolean expResult = false;
        boolean result = Colles.existeixColla(nomFitxer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of afegirMembre method, of class Colles.
     */
    @Test
    public void testAfegirMembre() {
        System.out.println("afegirMembre");
        Colles.afegirMembre();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sumarImport method, of class Colles.
     */
    @Test
    public void testSumarImport() {
        System.out.println("sumarImport");
        String nomFitxer = "";
        Colles.Membre mem = null;
        Colles.sumarImport(nomFitxer, mem);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sumarMembre method, of class Colles.
     */
    @Test
    public void testSumarMembre() {
        System.out.println("sumarMembre");
        String nomFitxerColla = "";
        Colles.sumarMembre(nomFitxerColla);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of afegirDadesMembre method, of class Colles.
     */
    @Test
    public void testAfegirDadesMembre() {
        System.out.println("afegirDadesMembre");
        Colles.Membre mem = null;
        String nomFitx = "";
        Colles.afegirDadesMembre(mem, nomFitx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of afegirMembreIndex method, of class Colles.
     */
    @Test
    public void testAfegirMembreIndex() {
        System.out.println("afegirMembreIndex");
        RandomAccessFile raf = null;
        String nomFitx = "";
        Colles.afegirMembreIndex(raf, nomFitx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of demanarDadesMembre method, of class Colles.
     */
    @Test
    public void testDemanarDadesMembre() {
        System.out.println("demanarDadesMembre");
        Colles.Membre expResult = null;
        Colles.Membre result = Colles.demanarDadesMembre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of llegirPremis method, of class Colles.
     */
    @Test
    public void testLlegirPremis() {
        System.out.println("llegirPremis");
        String nomFitxAny = "";
        int[] premisGrans = null;
        LoteriaNavidad.NumPremiat[] llistaPremis = null;
        Colles.llegirPremis(nomFitxAny, premisGrans, llistaPremis);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of comprovarPremi method, of class Colles.
     */
    @Test
    public void testComprovarPremi() {
        System.out.println("comprovarPremi");
        String nomFitxAny = "";
        int numero = 0;
        int expResult = 0;
        int result = Colles.comprovarPremi(nomFitxAny, numero);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of demanarDadesComprovar method, of class Colles.
     */
    @Test
    public void testDemanarDadesComprovar() {
        System.out.println("demanarDadesComprovar");
        Colles.demanarDadesComprovar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of assignarPremisCorresponents method, of class Colles.
     */
    @Test
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
     */
    @Test
    public void testAcumularPremisColla() {
        System.out.println("acumularPremisColla");
        String nomFitxIndex = "";
        String nomFitxColla = "";
        Colles.acumularPremisColla(nomFitxIndex, nomFitxColla);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of escribirPremio method, of class Colles.
     */
    @Test
    public void testEscribirPremio() {
        System.out.println("escribirPremio");
        RandomAccessFile raf = null;
        float premi = 0.0F;
        Colles.escribirPremio(raf, premi);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of importJugat method, of class Colles.
     */
    @Test
    public void testImportJugat() {
        System.out.println("importJugat");
        RandomAccessFile raf = null;
        float expResult = 0.0F;
        float result = Colles.importJugat(raf);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of numeroJugador method, of class Colles.
     */
    @Test
    public void testNumeroJugador() {
        System.out.println("numeroJugador");
        RandomAccessFile raf = null;
        RandomAccessFile rafIndex = null;
        int expResult = 0;
        int result = Colles.numeroJugador(raf, rafIndex);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of anySorteigColla method, of class Colles.
     */
    @Test
    public void testAnySorteigColla() {
        System.out.println("anySorteigColla");
        String nomFitxer = "";
        int expResult = 0;
        int result = Colles.anySorteigColla(nomFitxer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
