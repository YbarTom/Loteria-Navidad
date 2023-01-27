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
        
        numero= 0;
        premi=02;
        expResult= false;
        result = FuncionesComprobacion.Aproximacio(numero, premi);
        assertEquals(expResult, result);
    }

    /**
     * Test of comprovarAproximacions method, of class FuncionesComprobacion.
     * 
     * Comprobem si les aproximacions son correctes i sus premios correspondientes
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
        
        premi1=99999;
        numero= 0;
        expResult =20000;
        result = FuncionesComprobacion.comprovarAproximacions(numero, premi1, premi2, premi3);
        assertEquals(expResult, result);
        
        premi1=0;
        numero= 99999;
        expResult =20000;
        result = FuncionesComprobacion.comprovarAproximacions(numero, premi1, premi2, premi3);
        assertEquals(expResult, result);
        
        premi1=0;
        numero= 02;
        expResult =0;
        result = FuncionesComprobacion.comprovarAproximacions(numero, premi1, premi2, premi3);
        assertEquals(expResult, result);
    }

    /**
     * Test of eliminarNumero method, of class FuncionesComprobacion.
     * 
     * Comprobem si una vegada surt el numero s'elimina i comprovem si no surt 
     * que no s'elimini.
     */
    @Test
    public void testEliminarNumero() {
        System.out.println("eliminarNumero caso de numero = premisGrans");
        int numero = 70926;
        int[] premisGrans = {70926, 40729, 47199, 1800, 33747};
        FuncionesComprobacion.eliminarNumero(numero, premisGrans);
        int[] expResult = {-11111, 40729, 47199, 1800, 33747};
        Assert.assertArrayEquals(expResult, premisGrans);
        
        System.out.println("eliminarNumero caso en que numero != premisGrans ");
        numero = 54897;
        premisGrans[0]= 70926;
        expResult[0]= 70926;
        FuncionesComprobacion.eliminarNumero(numero, premisGrans);
        Assert.assertArrayEquals(expResult, premisGrans);
    }

    /**
     * Test of contarDigits method, of class FuncionesComprobacion.
     * 
     * Comprobem si conta correctament la quantitat de digits dels numeros.
     */
    @Test
    public void testContarDigits() {
        System.out.println("contarDigits");
        
        System.out.println("contarDigits en el cas de 5 digits");
        int numero = 12345;
        int expResult = 5;
        int result = FuncionesComprobacion.contarDigits(numero);
        assertEquals("5 digits", expResult, result);
        
        
        System.out.println("contarDigits en el cas de 4 digits");
        numero=1234;
        expResult = 4;
        result = FuncionesComprobacion.contarDigits(numero);
        assertEquals("4 digits", expResult, result);
        
        System.out.println("contarDigits en el cas de 3 digits");
        numero = 123;
        expResult = 3;
        result = FuncionesComprobacion.contarDigits(numero);
        assertEquals("3 digits", expResult, result);
        
        System.out.println("contarDigits en el cas de 2 digits");
        numero=12;
        expResult = 2;
        result = FuncionesComprobacion.contarDigits(numero);
        assertEquals("2 digits", expResult, result);
        
        System.out.println("contarDigits en el cas de 1 digit");
        numero = 0;
        expResult = 1;
        result = FuncionesComprobacion.contarDigits(numero);
        assertEquals("1 digit", expResult, result);
    }

    /**
     * Test of passarAString method, of class FuncionesComprobacion.
     * 
     * Comprobem si llegeix el numero i el torna a String amb els 0 necesaris
     */
    @Test
    public void testPassarAString() {
        System.out.println("passarAString");
        
        System.out.println("passarAString con 1 numero");
        int numero = 0;
        String expResult = "00000";
        String result = FuncionesComprobacion.passarAString(numero);
        assertEquals(expResult, result);
        
        System.out.println("passarAString con 2 numeros");
        numero = 23;
        expResult = "00023";
        result = FuncionesComprobacion.passarAString(numero);
        assertEquals(expResult, result);
        
        System.out.println("passarAString con 3 numeros");
        numero = 243;
        expResult = "00243";
        result = FuncionesComprobacion.passarAString(numero);
        assertEquals(expResult, result);
        
        System.out.println("passarAString con 4 numeros");
        numero = 2345;
        expResult = "02345";
        result = FuncionesComprobacion.passarAString(numero);
        assertEquals(expResult, result);
        
        
        

    }

    /**
     * Test of comprovarCentenes method, of class FuncionesComprobacion.
     * 
     * Comprobem si el numero esta dintre de les centenes
     */
    @Test
    public void testComprovarCentenes() {
        System.out.println("comprovarCentenes");
        
        System.out.println("comprovarCentenes en el Prmier Premi");
        String numero = "98611";
        String premi1 = "98622";
        String premi2 = "83710";
        String premi3 = "23473";
        String premi4 = "76065";
        String premi5 = "15124";
        boolean expResult = true;
        boolean result = FuncionesComprobacion.comprovarCentenes(numero, premi1, premi2, premi3, premi4, premi5);
        assertEquals(expResult, result);
        
        System.out.println("comprovarCentenes en el Segon Premi");
        numero = "83711";
        premi2 = "83710";
        expResult = true;
        result = FuncionesComprobacion.comprovarCentenes(numero, premi1, premi2, premi3, premi4, premi5);
        assertEquals(expResult, result);
        
        System.out.println("comprovarCentenes en el Tercer Premi");
        numero = "23411";
        premi3 = "23473";
        expResult = true;
        result = FuncionesComprobacion.comprovarCentenes(numero, premi1, premi2, premi3, premi4, premi5);
        assertEquals(expResult, result);
        
        System.out.println("comprovarCentenes en el Quart Premi");
        numero = "76011";
        premi4 = "76065";
        expResult = true;
        result = FuncionesComprobacion.comprovarCentenes(numero, premi1, premi2, premi3, premi4, premi5);
        assertEquals(expResult, result);
        
        System.out.println("comprovarCentenes en el Cinque Premi");
        numero = "15165";
        premi5 = "15124";
        expResult = true;
        result = FuncionesComprobacion.comprovarCentenes(numero, premi1, premi2, premi3, premi4, premi5);
        assertEquals(expResult, result);
        
        System.out.println("comprovarCentenes cas false en el Primer Premi");
        numero = "15265";
        premi1 = "15124";
        expResult = false;
        result = FuncionesComprobacion.comprovarCentenes(numero, premi1, premi2, premi3, premi4, premi5);
        assertEquals(expResult, result);
    }

    /**
     * Test of comprovarDosUltims method, of class FuncionesComprobacion.
     * 
     * Comprobem si els 2 ultim numeros del premi coincideixan amb els 2 ultims
     * numeros del numero.
     */
    @Test
    public void testComprovarDosUltims() {
        System.out.println("comprovarDosUltims");
        System.out.println("comprovarDosUltims en el primer premi");
        String numero = "14711";
        String premi1 = "22611";
        String premi2 = "87998";
        String premi3 = "18223";
        boolean expResult = true;
        boolean result = FuncionesComprobacion.comprovarDosUltims(numero, premi1, premi2, premi3);
        assertEquals(expResult, result);
        
        System.out.println("comprovarDosUltims amb el segon  premi");
        numero = "55898";
        expResult = true;
        result = FuncionesComprobacion.comprovarDosUltims(numero, premi1, premi2, premi3);
        assertEquals(expResult, result);
        
        System.out.println("comprovarDosUltims amb el tercer premi");
        numero = "55823";
        expResult = true;
        result = FuncionesComprobacion.comprovarDosUltims(numero, premi1, premi2, premi3);
        assertEquals(expResult, result);
        
        System.out.println("comprovarDosUltims amb un cas amb final 0");
        numero = "00000";
        premi1= "23400";
        expResult = true;
        result = FuncionesComprobacion.comprovarDosUltims(numero, premi1, premi2, premi3);
        assertEquals(expResult, result);
        
        System.out.println("comprovarDosUltims amb un cas de false");
        numero = "55822";
        expResult = false;
        result = FuncionesComprobacion.comprovarDosUltims(numero, premi1, premi2, premi3);
        assertEquals(expResult, result);
    }

    /**
     * Test of reintegrament method, of class FuncionesComprobacion.
     * 
     * Comprobem si t'ha tocat el reintegrament
     */
    @Test
    public void testReintegrament() {
        System.out.println("reintegrament");
        String numero = "56296";
        String premi1 = "34856";
        boolean expResult = true;
        boolean result = FuncionesComprobacion.reintegrament(numero, premi1);
        assertEquals(expResult, result);
        
        System.out.println("reintegrament amb el cas del numero 00000");
        numero="00000";
        premi1="54670";
        expResult= true;
        result= FuncionesComprobacion.reintegrament(numero, premi1);
        assertEquals(expResult, result);
        
        System.out.println("reintegrament amb un cas false");
        numero="00000";
        premi1="54671";
        expResult= false;
        result= FuncionesComprobacion.reintegrament(numero, premi1);
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
