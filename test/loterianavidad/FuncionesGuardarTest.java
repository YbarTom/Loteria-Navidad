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
public class FuncionesGuardarTest {
    
    public FuncionesGuardarTest() {
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
     * Test of leerSorteo method, of class FuncionesGuardar.
     */
    @Test
    public void testLeerSorteo() {
        System.out.println("leerSorteo");
        String nomFitxer = "";
        LoteriaNavidad.NumPremiat[] vector = null;
        int[] premisGrans = null;
        FuncionesGuardar.leerSorteo(nomFitxer, vector, premisGrans);
        
    }

    /**
     * Test of guardarGrans method, of class FuncionesGuardar.
     */
    @Test
    public void testGuardarGrans() {
        System.out.println("guardarGrans");
        int numero = 0;
        int premi = 0;
        int[] premisGrans = null;
        FuncionesGuardar.guardarGrans(numero, premi, premisGrans);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of escribirSorteo method, of class FuncionesGuardar.
     */
    @Test
    public void testEscribirSorteo() {
        System.out.println("escribirSorteo");
        LoteriaNavidad.NumPremiat[] vector = null;
        String nomFitxer = "";
        FuncionesGuardar.escribirSorteo(vector, nomFitxer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
