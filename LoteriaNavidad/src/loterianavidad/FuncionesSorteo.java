/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loterianavidad;

import static loterianavidad.LoteriaNavidad.PRIMERPREMI;
import static loterianavidad.LoteriaNavidad.QUARTPREMI;
import static loterianavidad.LoteriaNavidad.SEGONPREMI;
import static loterianavidad.LoteriaNavidad.TERCERPREMI;
import static loterianavidad.LoteriaNavidad.TOTNUMS;
import static loterianavidad.LoteriaNavidad.TOTPREMS;

/**
 *
 * @author ausias
 */
public class FuncionesSorteo {
    
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

    public static boolean RepetidosNumeros(int n, int contador, LoteriaNavidad.NumPremiat[] vector) {
        boolean comprovacio = false;

        for (int i = 0; i <= contador && !comprovacio; i++) {
            if (vector[i] != null && n == vector[i].numero) {
                comprovacio = true;
            }
        }

        return comprovacio;

    }

    public static boolean RepetidosPremis(int n, int contador, LoteriaNavidad.NumPremiat[] vector) {
        boolean comprovacio = false;

        for (int i = 0; i < contador && !comprovacio; i++) {
            if (n == vector[i].premi) {
                comprovacio = true;
            }
        }

        return comprovacio;
    }

    public static void AssignarPremis(LoteriaNavidad.NumPremiat[] vector, int[] premisGrans) {

        for (int i = 0; i < TOTPREMS; i++) {
            if (vector[i].premi == 0) {
                premisGrans[0] = vector[i].numero;
                vector[i].premi = PRIMERPREMI;
            } else if (vector[i].premi == 1) {
                premisGrans[1] = vector[i].numero;
                vector[i].premi = SEGONPREMI;
            } else if (vector[i].premi == 2) {
                premisGrans[2] = vector[i].numero;
                vector[i].premi = TERCERPREMI;
            } else if (vector[i].premi == 3 || vector[i].premi == 4) {
                if (vector[i].premi == 3) {
                    premisGrans[3] = vector[i].numero;
                } else {
                    premisGrans[4] = vector[i].numero;
                }
                vector[i].premi = QUARTPREMI;
            } else if (vector[i].premi >= 5 && vector[i].premi <= 12) {
                vector[i].premi = 60000;
            } else if (vector[i].premi >= 13 && vector[i].premi <= (TOTPREMS-3)) {
                vector[i].premi = 1000;
            }
        }
    }
}
