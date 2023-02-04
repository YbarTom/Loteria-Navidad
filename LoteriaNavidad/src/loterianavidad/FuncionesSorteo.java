/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loterianavidad;

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

public class FuncionesSorteo {
    
    static final int POSICIOPRIMERPREMI=0;
    static final int POSICIOSEGONPREMI=1;
    static final int POSICIOTERCERPREMI=2;
    static final int INICIQUARTPREMI=3;
    static final int FINALQUARTPREMI=4;
    static final int INICICINQUEPREMI=5;
    static final int FINALCINQUEPREMI=12;
    static final int INICISISEPREMI=13;
    
    
    /**
     * Funcio que genera els numeros Guanyadors aleatoriament del concurs (del 0 al nombre de numeros), 
     * i els insereix dintre del vector(NumPremiat) a la secció de numeros.
     * 
     * @param vector vector(s'utilitza el .numero) on estan els numeros premiats
     */

    public static void GeneradorNumeros(LoteriaNavidad.NumPremiat[] vector) {
        int contador = 0;
        int numeroAleatorio = (int) (Math.random() * (TOTNUMS + 1));

        while (contador < TOTPREMS) {

            if (!RepetidosNumeros(numeroAleatorio, contador, vector)) {
                vector[contador] = new LoteriaNavidad.NumPremiat();
                vector[contador].numero = numeroAleatorio;
                ++contador;
            }
            numeroAleatorio = (int) (Math.random() * (TOTNUMS + 1));
        }

    }
    
    /**
     * Genera un numero aleatori entre 0 i (Numero de premis), el 0 es el premi amb el valor mes gran,
     * l'1 amb el segon més gran i aixi respectivament.
     * @param vector vector(s'utilitza el .premi) on estan els premis
     * cada premi va asignat a un numero, s'assignen per ordre de sortida
     * @param premis (vector amb els premis per sobre o igual a 200000 euros)
     */

    public static void GeneradorPremis(LoteriaNavidad.NumPremiat[] vector, int[] premis) {
        int contador = 0;
        int PremioAleatorio = (int) (Math.random() * (TOTPREMS + 1));

        while (contador < TOTPREMS) {

            if (!RepetidosPremis(PremioAleatorio, contador, vector)) {
                vector[contador].premi = PremioAleatorio;
                ++contador;
            }
            PremioAleatorio = (int) (Math.random() * (TOTPREMS + 1));
        }
        AssignarPremis(vector, premis);
    }
    /**
     * Comprova l'ultim numero generat amb els que estan situats a .numero(dintre del vector de 
     * NumPremiat) per veure si aquest numero ja existeix
     * @param n numero a comprovar
     * @param contador numero de comprovacions
     * @param vector vector(s'utilitza el .numero) on estan els numeros premiats
     * @return true si esta el numero repetit, false si no ho està.
     */
    public static boolean RepetidosNumeros(int n, int contador, LoteriaNavidad.NumPremiat[] vector) {
        boolean comprovacio = false;

        for (int i = 0; i <= contador && !comprovacio; i++) {
            if (vector[i] != null && n == vector[i].numero) {
                comprovacio = true;
            }
        }

        return comprovacio;

    }
    /**
     * Comprova l'ultim premi generat amb els que estan situats a .premi(dintre del vector de 
     * NumPremiat) per veure si aquest premi ja existeix.
     * Aquests premis es comproven seguint la idea que el premi 0 és el primer premi,
     * l'1 és el segon premi, etc.
     * @param n premi a mirar
     * @param contador numero de comprovacions
     * @param vector vector(s'utilitza el .premi) on estan els premis
     * @return true si esta el numero repetit, false si no ho està.
     */
    public static boolean RepetidosPremis(int n, int contador, LoteriaNavidad.NumPremiat[] vector) {
        boolean comprovacio = false;

        for (int i = 0; i < contador && !comprovacio; i++) {
            if (n == vector[i].premi) {
                comprovacio = true;
            }
        }

        return comprovacio;
    }
    /**
     * Assigna el valor monetari als premis respectivament, el 0 va amb el mes gran, 
     * l'1 el segon més gran i aixi successivament
     * @param vector vector on estan els premis i els numeros, cadascun d'ells al seu lloc respectiu de
     * la clase
     * @param premisGrans vector que conte els premis per sobre o igual al valor 200000
     */
    public static void AssignarPremis(LoteriaNavidad.NumPremiat[] vector, int[] premisGrans) {

        for (int i = 0; i < TOTPREMS; i++) {
            if (vector[i].premi == POSICIOPRIMERPREMI) {
                premisGrans[POSICIOPRIMERPREMI] = vector[i].numero;
                vector[i].premi = PRIMERPREMI;
            } else if (vector[i].premi == POSICIOSEGONPREMI) {
                premisGrans[POSICIOSEGONPREMI] = vector[i].numero;
                vector[i].premi = SEGONPREMI;
            } else if (vector[i].premi == POSICIOTERCERPREMI) {
                premisGrans[POSICIOTERCERPREMI] = vector[i].numero;
                vector[i].premi = TERCERPREMI;
            } else if (vector[i].premi == INICIQUARTPREMI || vector[i].premi == FINALQUARTPREMI) {
                if (vector[i].premi == INICIQUARTPREMI) {
                    premisGrans[INICIQUARTPREMI] = vector[i].numero;
                } else {
                    premisGrans[FINALQUARTPREMI] = vector[i].numero;
                }
                vector[i].premi = QUARTPREMI;
            } else if (vector[i].premi >= INICICINQUEPREMI && vector[i].premi <= FINALCINQUEPREMI) {
                vector[i].premi = CINQUEPREMI;
            } else if (vector[i].premi >= INICISISEPREMI && vector[i].premi <= (TOTPREMS - 3)) {
                vector[i].premi = SISEPREMI;
            }
            else{
                vector[i].premi=0;
            }
        }
    }
    /**
     * Imprimeix els premis superiors o iguals a 6000 euros ja que son els "importants"
     * @param VectorPremi vector on estan els premis (vector de clase NumPremi al .premi)
     */
    public static void mostrarPremisGrans(LoteriaNavidad.NumPremiat[] VectorPremi){
        for (int i = 0; i < TOTPREMS; i++) {
            if (VectorPremi[i].premi == PRIMERPREMI || VectorPremi[i].premi == SEGONPREMI
                    || VectorPremi[i].premi == TERCERPREMI || VectorPremi[i].premi == QUARTPREMI
                    || VectorPremi[i].premi == CINQUEPREMI) {
                System.out.print(VectorPremi[i].numero + " ");
                System.out.println(VectorPremi[i].premi);
            }

        }
    }
}
