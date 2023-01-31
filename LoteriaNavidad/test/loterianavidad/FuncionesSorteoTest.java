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
     * Test of GeneradorNumeros method, of class FuncionesSorteo.
     */
    @Test
    public void testGeneradorNumeros() {
        System.out.println("GeneradorNumeros");
        LoteriaNavidad.NumPremiat[] vector = new LoteriaNavidad.NumPremiat[1807];

        FuncionesSorteo.GeneradorNumeros(vector);
        int contador = 0;

        for (int i = 0; i < vector.length; i++) {
            if (vector[i].numero >= 0 && vector[i].numero <= 100000) {
                contador++;
            }
        }
        int expResult = 1807;
        int result = contador;
        assertEquals(expResult, result);
    }

    /**
     * Test of GeneradorPremis method, of class FuncionesSorteo.
     */
    @Test
    public void testGeneradorPremis() {
        System.out.println("GeneradorPremis");
        LoteriaNavidad.NumPremiat[] vector = new LoteriaNavidad.NumPremiat[1807];
        int[] premis = new int[5];
        FuncionesSorteo.GeneradorNumeros(vector);
        FuncionesSorteo.GeneradorPremis(vector, premis);
        int contador = 0;

        for (int i = 0; i < vector.length; i++) {
            if (vector[i].premi >= 0 && vector[i].premi <= 4000000) {
                contador++;
            }
        }
        int expResult = 1807;
        int result = contador;
        assertEquals(expResult, result);
    }

    /**
     * Test of RepetidosNumeros method, of class FuncionesSorteo.
     */
    @Test
    public void testRepetidosNumeros() {
        System.out.println("RepetidosNumeros");
        //caso donde hay repetido
        int n = 0;
        int contador = 1;
        LoteriaNavidad.NumPremiat[] vector = new LoteriaNavidad.NumPremiat[2];
        //creem qwedewfdwe
        vector[0] = new LoteriaNavidad.NumPremiat();
        vector[1] = new LoteriaNavidad.NumPremiat();
        vector[0].numero=0;
        vector[1].numero=1;
        boolean expResult = true;
        boolean result = FuncionesSorteo.RepetidosNumeros(n, contador, vector);
        assertEquals(expResult, result);
        //caso donde no hay repetido
       
        n = 2;
        contador = 1;
        vector[0].numero=0;
        vector[1].numero=1;
        expResult = false;
        result = FuncionesSorteo.RepetidosNumeros(n, contador, vector);
        assertEquals(expResult, result);
    }

    /**
     * Test of RepetidosPremis method, of class FuncionesSorteo.
     */
    @Test
    public void testRepetidosPremis() {
        System.out.println("RepetidosPremis");
        //caso donde hay repetido
        int n = 0;
        int contador = 1;
        LoteriaNavidad.NumPremiat[] vector = new LoteriaNavidad.NumPremiat[2];
        //creem qwedewfdwe
        vector[0] = new LoteriaNavidad.NumPremiat();
        vector[1] = new LoteriaNavidad.NumPremiat();
        vector[0].premi=0;
        vector[1].premi=1;
        boolean expResult = true;
        boolean result = FuncionesSorteo.RepetidosPremis(n, contador, vector);
        assertEquals(expResult, result);
        //caso donde no hay repetido
        n=2;
        contador=1;
        vector[0].numero=0;
        vector[1].numero=1;
        expResult = false;
        result = FuncionesSorteo.RepetidosNumeros(n, contador, vector);
        assertEquals(expResult, result);
        

    }

    /**
     * Test of AssignarPremis method, of class FuncionesSorteo.
     */
    @Test
    public void testAssignarPremis() {
        System.out.println("AssignarPremis");
        LoteriaNavidad.NumPremiat[] vector = null;
        int[] premisGrans = null;
        FuncionesSorteo.AssignarPremis(vector, premisGrans);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    
    

}
