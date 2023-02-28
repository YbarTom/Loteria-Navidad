/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package loterianavidad;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
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
public class FuncionesUtilidadesTest {
    
    public FuncionesUtilidadesTest() {
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
     * Test of LeerFloat method, of class FuncionesUtilidades.
     * Aquesta funció no es pot comprobar ja que requereix que l'usuari introdueixi
     * un valor
     */
    /*@Test
    public void testLeerFloat() {
        System.out.println("LeerFloat");
        String missatge = "";
        float expResult = 0.0F;
        float result = FuncionesUtilidades.LeerFloat(missatge);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of LeerDinero method, of class FuncionesUtilidades.
     * Aquesta funció no es pot comprobar ja que requereix que l'usuari introdueixi
     * un valor
     */
    /*@Test
    public void testLeerDinero() {
        System.out.println("LeerDinero");
        String missatge = "";
        float expResult = 0.0F;
        float result = FuncionesUtilidades.LeerDinero(missatge);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of Entero method, of class FuncionesUtilidades.
     * Aquesta funció no es pot comprobar ja que requereix que l'usuari introdueixi
     * un valor
     */
    /*@Test
    public void testEntero_String() {
        System.out.println("Entero");
        String missatge = "";
        int expResult = 0;
        int result = FuncionesUtilidades.Entero(missatge);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of Entero method, of class FuncionesUtilidades.
     * Aquesta funció no es pot comprobar ja que requereix que l'usuari introdueixi
     * un valor
     */
    /*@Test
    public void testEntero_3args() {
        System.out.println("Entero");
        String missatge = "";
        int min = 0;
        int max = 0;
        int expResult = 0;
        int result = FuncionesUtilidades.Entero(missatge, min, max);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of AbrirFichero method, of class FuncionesUtilidades.
     */
    @Test
    public void testAbrirFichero() {
        System.out.println("AbrirFichero");
        String nomFichero = "";
        boolean crear = false;
        File expResult = null;
        File result = FuncionesUtilidades.AbrirFichero(nomFichero, crear);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AbrirFicheroEscrituraBinario method, of class FuncionesUtilidades.
     */
    @Test
    public void testAbrirFicheroEscrituraBinario() {
        System.out.println("AbrirFicheroEscrituraBinario");
        String nomFichero = "";
        boolean crear = false;
        boolean blnAnyadir = false;
        DataOutputStream expResult = null;
        DataOutputStream result = FuncionesUtilidades.AbrirFicheroEscrituraBinario(nomFichero, crear, blnAnyadir);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AbrirFicheroLecturaBinario method, of class FuncionesUtilidades.
     */
    @Test
    public void testAbrirFicheroLecturaBinario() {
        System.out.println("AbrirFicheroLecturaBinario");
        String nomFichero = "";
        boolean crear = false;
        DataInputStream expResult = null;
        DataInputStream result = FuncionesUtilidades.AbrirFicheroLecturaBinario(nomFichero, crear);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Entero method, of class FuncionesUtilidades.
     * No la podem probar amb les nostres eines i coneixements actuals perquè demana dades pel teclat
     */
    /*
    @Test
    Oculta per evitar l'error de testing
    public void testEntero() {
        System.out.println("Entero");
        String missatge = "";
        int expResult = 0;
        int result = FuncionesUtilidades.Entero(missatge);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
}
