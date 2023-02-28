/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package loterianavidad;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class FuncionsIdiomesTest {

    public FuncionsIdiomesTest() {
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
     * Test of MenuIdiomes method, of class FuncionsIdiomes. Aquesta funció no
     * es pot comprobar ja que requereix que l'usuari introdueixi els valors per
     * teclat
     */
    /*@Test
    public void testMenuIdiomes() {
        System.out.println("MenuIdiomes");
        String expResult = "";
        String result = FuncionsIdiomes.MenuIdiomes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    /**
     * Test of ObrirArxiu method, of class FuncionsIdiomes. Aquesta funcio
     * serveix per a comprobar que es crea el BufferReader, per aixo el que fem
     * es cridar a llegir linia i mirar si els dos BufferReader llegeixen la
     * mateixa linea
     */
    @Test
    public void testObrirArxiu() {
        try {

            System.out.println("ObrirArxiu");
            FuncionsIdiomes.idioma = "./idiomes/catala.txt";

            String idioma = "./idiomes/catala.txt";
            //BufferReader creat per nosaltres
            File arxiu = new File(idioma);
            FileReader reader = new FileReader(arxiu);
            BufferedReader buf1 = new BufferedReader(reader);
            String expResult = FuncionsIdiomes.LlegirLineas(buf1, 3);
            //BufferReader creat per la funció
            BufferedReader buf2 = FuncionsIdiomes.ObrirArxiu(idioma);
            String result = FuncionsIdiomes.LlegirLineas(buf2, 3);
            assertEquals(expResult, result);
            // TODO review the generated test code and remove the default call to fail.

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FuncionsIdiomesTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Test of LlegirLineas method, of class FuncionsIdiomes.
     */
    @Test
    public void testLlegirLineas() {
        System.out.println("LlegirLineas");
        FuncionsIdiomes.idioma = "./idiomes/catala.txt";
        String idioma = "./idiomes/catala.txt";
        BufferedReader buf = FuncionsIdiomes.ObrirArxiu(idioma);
        int linea = 3;
        String expResult = "Premi:";
        String result = FuncionsIdiomes.LlegirLineas(buf, linea);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of TancarObrirBuf method, of class FuncionsIdiomes.
     */
    @Test
    public void testTancarObrirBuf() {
        System.out.println("TancarObrirBuf");
        FuncionsIdiomes.idioma = "./idiomes/catala.txt";
        String idioma = "./idiomes/catala.txt";
        BufferedReader buf1 = FuncionsIdiomes.ObrirArxiu(idioma);
        String expResult = FuncionsIdiomes.LlegirLineas(buf1, 3);
        
        BufferedReader buf2 = FuncionsIdiomes.ObrirArxiu(idioma);
        FuncionsIdiomes.TancarObrirBuf(buf2);
        String result = FuncionsIdiomes.LlegirLineas(buf2, 3);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

}
