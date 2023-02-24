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
import static loterianavidad.LoteriaNavidad.PRIMERPREMI;
import static loterianavidad.LoteriaNavidad.SEGONPREMI;
import static loterianavidad.LoteriaNavidad.TERCERPREMI;
import static loterianavidad.LoteriaNavidad.QUARTPREMI;
import static loterianavidad.LoteriaNavidad.CINQUEPREMI;
import static loterianavidad.LoteriaNavidad.SISEPREMI;
import static loterianavidad.LoteriaNavidad.TOTNUMS;
import static loterianavidad.LoteriaNavidad.TOTPREMS;

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
     * Mirem si la funcio GeneradorNumeros omple el vector de clase NumPremi al .numero amb 1807 numeros
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
     * Mirem si la funcio GeneradorNumeros omple el vector de clase NumPremi al .premi amb 1807 premis
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
     * Comprovem que la funció RepetidosNumeros, el primer cas hi ha un repetit, llavors la funcio haura de tornar true
     * (de que si està repetit) i el segon cas no hi ha cap numero repetit, llavors ha de retornar false.
     */
    @Test
    public void testRepetidosNumeros() {
        System.out.println("RepetidosNumeros");
        //caso donde hay repetido
        int n = 0;
        int contador = 1;
        LoteriaNavidad.NumPremiat[] vector = new LoteriaNavidad.NumPremiat[2];
        vector[0] = new LoteriaNavidad.NumPremiat();
        vector[1] = new LoteriaNavidad.NumPremiat();
        vector[0].numero = 0;
        vector[1].numero = 1;
        boolean expResult = true;
        boolean result = FuncionesSorteo.RepetidosNumeros(n, contador, vector);
        assertEquals(expResult, result);
        //caso donde no hay repetido

        n = 2;
        contador = 1;
        vector[0].numero = 0;
        vector[1].numero = 1;
        expResult = false;
        result = FuncionesSorteo.RepetidosNumeros(n, contador, vector);
        assertEquals(expResult, result);
    }

    /**
     * Test of RepetidosPremis method, of class FuncionesSorteo.
     * Comprovem que la funció RepetidosPremis, el primer cas hi ha un repetit, llavors la funcio haura de tornar true
     * (de que si està repetit) i el segon cas no hi ha cap numero repetit, llavors ha de retornar false.
     */
    @Test
    public void testRepetidosPremis() {
        System.out.println("RepetidosPremis");
        //caso donde hay repetido
        int n = 0;
        int contador = 1;
        LoteriaNavidad.NumPremiat[] vector = new LoteriaNavidad.NumPremiat[2];
        vector[0] = new LoteriaNavidad.NumPremiat();
        vector[1] = new LoteriaNavidad.NumPremiat();
        vector[0].premi = 0;
        vector[1].premi = 1;
        boolean expResult = true;
        boolean result = FuncionesSorteo.RepetidosPremis(n, contador, vector);
        assertEquals(expResult, result);
        //caso donde no hay repetido
        n = 2;
        contador = 1;
        vector[0].numero = 0;
        vector[1].numero = 1;
        expResult = false;
        result = FuncionesSorteo.RepetidosNumeros(n, contador, vector);
        assertEquals(expResult, result);

    }

    /**
     * Test of AssignarPremis method, of class FuncionesSorteo.
     * Li donem un vector de 5 posicions per mirar si assigna els valors monetaris corresponets als premis
     */
    @Test
    public void testAssignarPremis() {
        System.out.println("AssignarPremis");
        LoteriaNavidad.NumPremiat[] vector = new LoteriaNavidad.NumPremiat[TOTPREMS];
        int[] premisGrans = new int[5];

        for (int i = 0; i < TOTPREMS; i++) {
            vector[i] = new LoteriaNavidad.NumPremiat();
        }
        int contador = 0;
        vector[0].premi = 0;
        vector[1].premi = 1;
        vector[2].premi = 2;
        vector[3].premi = 3;
        vector[4].premi = 5;
        vector[5].premi = 12;
        vector[6].premi = 13;
        vector[7].premi = 1700;
        FuncionesSorteo.AssignarPremis(vector, premisGrans);
        if (vector[0].premi == PRIMERPREMI) {
            contador++;
        }
        if (vector[1].premi == SEGONPREMI) {
            contador++;
        }
        if (vector[2].premi == TERCERPREMI) {
            contador++;
        }
        if (vector[3].premi == QUARTPREMI) {
            contador++;
        }
        if (vector[4].premi == CINQUEPREMI) {
            contador++;
        }
        if (vector[5].premi == CINQUEPREMI) {
            contador++;
        }
        if (vector[6].premi == SISEPREMI) {
            contador++;
        }
        if (vector[7].premi == SISEPREMI) {
            contador++;
        }

        int expResult = 8;
        assertEquals(expResult, contador);
        
        
        
        
        // TODO review the generated test code and remove the default call to fail.

    }

}
