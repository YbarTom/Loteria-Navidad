/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package loterianavidad;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
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
        int numero = 41329;
        int[] premisGrans = {41120, 63668, 56823, 70195, 44057};
        LoteriaNavidad.NumPremiat[] llistaPremis = new LoteriaNavidad.NumPremiat[1];
        llistaPremis[0] = new LoteriaNavidad.NumPremiat();
        llistaPremis[0].numero = 41329;
        llistaPremis[0].premi = 1000;
        int expResult = 1000;
        int result = FuncionesComprobacion.comprovacioGeneral(numero, premisGrans, llistaPremis);
        assertEquals(expResult, result);
    }

    /**
     * Test of comprovarGrossos method, of class FuncionesComprobacion.
     */
    @Test
    public void testComprovarGrossos() {
        System.out.println("comprovarGrossos");
        int numero = 38571;
        LoteriaNavidad.NumPremiat[] llistaPremis = new LoteriaNavidad.NumPremiat[1];
        llistaPremis[0] = new LoteriaNavidad.NumPremiat();
        llistaPremis[0].numero = 38571;
        llistaPremis[0].premi = 4000000;
        int expResult = 4000000;
        int result = FuncionesComprobacion.comprovarGrossos(numero, llistaPremis);
        assertEquals(expResult, result);
    }

    /**
     * Test of Aproximacio method, of class FuncionesComprobacion.
     */
    @Test
    public void testAproximacio() {
        System.out.println("Aproximacio");
        int numero = 12345;
        int premi = 12346;
        boolean expResult = true;
        boolean result = FuncionesComprobacion.Aproximacio(numero, premi);
        assertEquals(expResult, result);
    }

    /**
     * Test of comprovarAproximacions method, of class FuncionesComprobacion.
     */
    @Test
    public void testComprovarAproximacions() {
        System.out.println("comprovarAproximacions");
        int numero = 37846;
        int premi1 = 37847;
        int premi2 = 96423;
        int premi3 = 68511;
        int expResult = 20000;
        int result = FuncionesComprobacion.comprovarAproximacions(numero, premi1, premi2, premi3);
        assertEquals(expResult, result);
        
        numero = 96422;
        expResult = 12500;
        result = FuncionesComprobacion.comprovarAproximacions(numero, premi1, premi2, premi3);
        assertEquals(expResult, result);
        
        numero = 68510;
        expResult = 9600;
        result = FuncionesComprobacion.comprovarAproximacions(numero, premi1, premi2, premi3);
        assertEquals(expResult, result);
    }

    /**
     * Test of eliminarNumero method, of class FuncionesComprobacion.
     */
    @Test
    public void testEliminarNumero() {
        System.out.println("eliminarNumero");
        int numero = 70926;
        int[] premisGrans = {70926, 40729, 47199, 1800, 33747};
        FuncionesComprobacion.eliminarNumero(numero, premisGrans);
        int[] expResult = {-11111, 40729, 47199, 1800, 33747};
        Assert.assertArrayEquals(expResult, premisGrans);
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
        String numero = "98611";
        String premi1 = "98622";
        String premi2 = "83710";
        String premi3 = "23473";
        String premi4 = "76065";
        String premi5 = "15124";
        boolean expResult = true;
        boolean result = FuncionesComprobacion.comprovarCentenes(numero, premi1, premi2, premi3, premi4, premi5);
        assertEquals(expResult, result);
    }

    /**
     * Test of comprovarUltims method, of class FuncionesComprobacion.
     */
    @Test
    public void testComprovarUltims() {
        System.out.println("comprovarUltims");
        String numero = "14711";
        String premi1 = "22611";
        String premi2 = "87998";
        String premi3 = "18223";
        boolean expResult = true;
        boolean result = FuncionesComprobacion.comprovarUltims(numero, premi1, premi2, premi3);
        assertEquals(expResult, result);
    }

    /**
     * Test of reintegrament method, of class FuncionesComprobacion.
     */
    @Test
    public void testReintegrament() {
        System.out.println("reintegrament");
        String numero = "56296";
        String premi1 = "34856";
        boolean expResult = true;
        boolean result = FuncionesComprobacion.reintegrament(numero, premi1);
        assertEquals(expResult, result);
    }

    /**
     * Test of comprovarDigits method, of class FuncionesComprobacion.
     */
    @Test
    public void testComprovarDigits() {
        System.out.println("comprovarDigits");
        String numero = "24167";
        String premi = "84169";
        int inici = 1;
        int finalNumero = 4;
        boolean expResult = true;
        boolean result = FuncionesComprobacion.comprovarDigits(numero, premi, inici, finalNumero);
        assertEquals(expResult, result);
    }
    
}
