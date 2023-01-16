/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loterianavidad;

/**
 *
 * @author ausias
 */
public class FuncionesComprobacion {

    public static int comprovarPremi(int numero, Class[] vector) {
        int posicio = -1;

        for (int i = 0; i < vector.length; ++i) {
            if (vector[i].numero == numero) {
                posicio = i;
            }
        }

        return posicio;
    }

    /**
     *
     * @param numero
     * @param premi1
     * @param premi2
     * @param premi3
     * @return
     */
    public static int comprovarAproximacions(int numero, int premi1, int premi2, int premi3) {
        int premi = 0;

        //Quantitats de premi per cada aproximació
        final int PREMI_APROX1 = 20000;
        final int PREMI_APROX2 = 12500;
        final int PREMI_APROX3 = 9600;

        //Comprovem les aproximacions de cada premi individualment
        //si coincideixen sumem el premi
        if (Aproximacio(numero, premi1)) {
            premi += PREMI_APROX1;
        }
        if (Aproximacio(numero, premi2)) {
            premi += PREMI_APROX2;
        }
        if (Aproximacio(numero, premi3)) {
            premi += PREMI_APROX3;
        }

        return premi;
    }

    /**
     *
     * @param numero
     * @param premi
     * @return
     */
    public static boolean Aproximacio(int numero, int premi) {
        boolean acertat = false;

        //Comprovem si el número anterior i posterior coincideixen amb el nostre
        if (numero == premi + 1 || numero == premi - 1) {
            acertat = true;
        } //Si el número és 00000 es considera 99999 el seu anterior
        //Si el número és 99999 el 00000 es considera el posterior
        else if ((numero == 00000 && premi == 99999) || (numero == 99999 && premi == 00000)) {
            acertat = true;
        }

        return acertat;
    }

}
