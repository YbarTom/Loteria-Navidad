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
public class FuncionesSorteoTest {
    
    public FuncionesSorteoTest() {
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
     * Test of GeneradorNumeros method, of class LoteriaNavidad.
     */
    @Test
    public void testGeneradorNumeros() {
        System.out.println("GeneradorNumeros");
        LoteriaNavidad.NumPremiat[] vector = null;
        FuncionesSorteo.GeneradorNumeros(vector);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GeneradorPremis method, of class LoteriaNavidad.
     */
    @Test
    public void testGeneradorPremis() {
        System.out.println("GeneradorPremis");
        LoteriaNavidad.NumPremiat[] vector = null;
        int[] premis = null;
        FuncionesSorteo.GeneradorPremis(vector, premis);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of RepetidosNumeros method, of class LoteriaNavidad.
     */
    @Test
    public void testRepetidosNumeros() {
        System.out.println("RepetidosNumeros");
        int n = 0;
        int contador = 0;
        LoteriaNavidad.NumPremiat[] vector = null;
        boolean expResult = false;
        boolean result = FuncionesSorteo.RepetidosNumeros(n, contador, vector);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of RepetidosPremis method, of class LoteriaNavidad.
     */
    @Test
    public void testRepetidosPremis() {
        System.out.println("RepetidosPremis");
        int n = 0;
        int contador = 0;
        LoteriaNavidad.NumPremiat[] vector = null;
        boolean expResult = false;
        boolean result = FuncionesSorteo.RepetidosPremis(n, contador, vector);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AssignarPremis method, of class LoteriaNavidad.
     */
    @Test
    public void testAssignarPremis() {
        System.out.println("AssignarPremis");
        LoteriaNavidad.NumPremiat[] vector = null;
        int[] premisGrans = null;
        FuncionesSorteo.AssignarPremis(vector, premisGrans);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class LoteriaNavidad.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        LoteriaNavidad.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
