/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package loterianavidad;

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
public class FuncionesComprobacionTest {
    
    public FuncionesComprobacionTest() {
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
     * Test of comprovacioGeneral method, of class FuncionesComprobacion.
     */
    @Test
    public void testComprovacioGeneral() {
        System.out.println("comprovacioGeneral");
        int numero = 0;
        int[] premisGrans = null;
        LoteriaNavidad.NumPremiat[] llistaPremis = null;
        int expResult = 0;
        int result = FuncionesComprobacion.comprovacioGeneral(numero, premisGrans, llistaPremis);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of comprovarGrossos method, of class FuncionesComprobacion.
     */
    @Test
    public void testComprovarGrossos() {
        System.out.println("comprovarGrossos");
        int numero = 0;
        LoteriaNavidad.NumPremiat[] llistaPremis = null;
        int expResult = 0;
        int result = FuncionesComprobacion.comprovarGrossos(numero, llistaPremis);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Aproximacio method, of class FuncionesComprobacion.
     */
    @Test
    public void testAproximacio() {
        System.out.println("Aproximacio");
        int numero = 0;
        int premi = 0;
        boolean expResult = false;
        boolean result = FuncionesComprobacion.Aproximacio(numero, premi);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of comprovarAproximacions method, of class FuncionesComprobacion.
     */
    @Test
    public void testComprovarAproximacions() {
        System.out.println("comprovarAproximacions");
        int numero = 0;
        int premi1 = 0;
        int premi2 = 0;
        int premi3 = 0;
        int expResult = 0;
        int result = FuncionesComprobacion.comprovarAproximacions(numero, premi1, premi2, premi3);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarNumero method, of class FuncionesComprobacion.
     */
    @Test
    public void testEliminarNumero() {
        System.out.println("eliminarNumero");
        int numero = 0;
        int[] premisGrans = null;
        FuncionesComprobacion.eliminarNumero(numero, premisGrans);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contarDigits method, of class FuncionesComprobacion.
     */
    @Test
    public void testContarDigits() {
        System.out.println("contarDigits");
        int numero = 12345;
        int expResult = 5;
        int result = FuncionesComprobacion.contarDigits(numero);
        assertEquals("5 digits", expResult, result);
        
        numero = 123;
        expResult = 3;
        result = FuncionesComprobacion.contarDigits(numero);
        assertEquals("3 digits", expResult, result);
        
        numero = 0;
        expResult = 1;
        result = FuncionesComprobacion.contarDigits(numero);
        assertEquals("1 digit", expResult, result);
    }

    /**
     * Test of passarAString method, of class FuncionesComprobacion.
     */
    @Test
    public void testPassarAString() {
        System.out.println("passarAString");
        int numero = 243;
        String expResult = "00243";
        String result = FuncionesComprobacion.passarAString(numero);
        assertEquals(expResult, result);
        
        numero = 0;
        expResult = "00000";
        result = FuncionesComprobacion.passarAString(numero);
        assertEquals(expResult, result);

    }

    /**
     * Test of comprovarCentenes method, of class FuncionesComprobacion.
     */
    @Test
    public void testComprovarCentenes() {
        System.out.println("comprovarCentenes");
        String numero = "";
        String premi1 = "";
        String premi2 = "";
        String premi3 = "";
        String premi4 = "";
        String premi5 = "";
        boolean expResult = false;
        boolean result = FuncionesComprobacion.comprovarCentenes(numero, premi1, premi2, premi3, premi4, premi5);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of comprovarUltims method, of class FuncionesComprobacion.
     */
    @Test
    public void testComprovarUltims() {
        System.out.println("comprovarUltims");
        String numero = "";
        String premi1 = "";
        String premi2 = "";
        String premi3 = "";
        boolean expResult = false;
        boolean result = FuncionesComprobacion.comprovarUltims(numero, premi1, premi2, premi3);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reintegrament method, of class FuncionesComprobacion.
     */
    @Test
    public void testReintegrament() {
        System.out.println("reintegrament");
        String numero = "";
        String premi1 = "";
        boolean expResult = false;
        boolean result = FuncionesComprobacion.reintegrament(numero, premi1);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of comprovarDigits method, of class FuncionesComprobacion.
     */
    @Test
    public void testComprovarDigits() {
        System.out.println("comprovarDigits");
        String numero = "";
        String premi = "";
        int inici = 0;
        int finalNumero = 0;
        boolean expResult = false;
        boolean result = FuncionesComprobacion.comprovarDigits(numero, premi, inici, finalNumero);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
