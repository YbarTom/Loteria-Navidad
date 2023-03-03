package loterianavidad;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static loterianavidad.FuncionesGuardar.guardarGrans;
import static loterianavidad.LoteriaNavidad.PREMISIMPORTANTS;
import static loterianavidad.LoteriaNavidad.PRIMERPREMI;
import static loterianavidad.LoteriaNavidad.TOTPREMS;
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
        String nomFitxer = "./sorteos/2000.bin";
        LoteriaNavidad.NumPremiat[] vector1 = new LoteriaNavidad.NumPremiat[TOTPREMS], vector2 = new LoteriaNavidad.NumPremiat[TOTPREMS];
        int[] premisGrans = new int[LoteriaNavidad.PREMISIMPORTANTS];

        DataInputStream distest = FuncionesUtilidades.AbrirFicheroLecturaBinario(nomFitxer, true);

        for (int i = 0; i < LoteriaNavidad.TOTPREMS; ++i) {
            try {
                vector2[i] = new LoteriaNavidad.NumPremiat();
                vector2[i].numero = distest.readInt();
                vector2[i].premi = distest.readInt();
            } catch (IOException ex) {
                Logger.getLogger(FuncionesGuardarTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            distest.close();
        } catch (IOException ex) {
            Logger.getLogger(FuncionesGuardarTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        FuncionesGuardar.leerSorteo(nomFitxer, vector1, premisGrans);
        for (int i = 0; i < LoteriaNavidad.TOTPREMS; i++) {
            assertEquals(vector2[i].numero, vector1[i].numero);
            assertEquals(vector2[i].premi, vector1[i].premi);
        }

    }

    /**
     * Test of guardarGrans method, of class FuncionesGuardar.
     */
    @Test
    public void testGuardarGrans() {
        int numero = 1;
        int premi = PRIMERPREMI;
        int[] premisGrans = new int[LoteriaNavidad.PREMISIMPORTANTS];
       
        guardarGrans(numero, premi, premisGrans);
       
        assertEquals(numero, premisGrans[0]);
       
    }

    /**
     * Test of escribirSorteo method, of class FuncionesGuardar.
     * Aquest procediment no es pot comprobar ja que es d'escriure i requereix que l'usuari
     * introdueixi dades per teclat
     */
    /*@Test
    public void testEscribirSorteo() {
        System.out.println("escribirSorteo");
        LoteriaNavidad.NumPremiat[] vector = null;
        String nomFitxer = "";
        FuncionesGuardar.escribirSorteo(vector, nomFitxer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

}