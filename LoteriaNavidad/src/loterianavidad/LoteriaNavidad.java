/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package loterianavidad;

import java.util.Scanner;

public class LoteriaNavidad {

    public static Scanner scan = new Scanner(System.in);

    static final int TOTNUMS = 99999;
    static final int TOTPREMS = 1807;

    public static class NumPremiat {

        int numero;
        int premi;
    }

    public static void GeneradorNumeros(NumPremiat[] vector) {
        int contador = 0;
        int numeroAleatorio = (int) (Math.random() * (TOTNUMS+1) );

        while (contador < TOTPREMS) {
            if (!RepetidosNumeros(numeroAleatorio, contador, vector)) {
                vector[contador] = new NumPremiat();
                vector[contador].numero = numeroAleatorio;
                ++contador;
            }
            numeroAleatorio = (int) (Math.random() * (TOTNUMS+1) );
        }

    }

    public static void GeneradorPremis(NumPremiat[] vector, int[] premis) {
        int contador = 0;
        int PremioAleatorio = (int) (Math.random() * (TOTPREMS+1) );

        while (contador < TOTPREMS) {
            if (!RepetidosPremis(PremioAleatorio, contador, vector)) {
                vector[contador].premi = PremioAleatorio;
                ++contador;
            }
            PremioAleatorio = (int) (Math.random() * (TOTPREMS+1) );
        }
        AssignarPremis(vector, premis);
    }

    public static boolean RepetidosNumeros(int n, int contador, NumPremiat[] vector) {
        boolean comprovacio = false;

        for (int i = 0; i <= contador && !comprovacio; i++) {
            if (vector[i] != null && n == vector[i].numero) {
                comprovacio = true;
            }
        }

        return comprovacio;

    }

    public static boolean RepetidosPremis(int n, int contador, NumPremiat[] vector) {
        boolean comprovacio = false;

        for (int i = 0; i < contador && !comprovacio; i++) {
            if (n == vector[i].premi) {
                comprovacio = true;
            }
        }

        return comprovacio;
    }

    public static void AssignarPremis(NumPremiat[] vector, int[] premisGrans) {

        for (int i = 0; i < TOTPREMS; i++) {
            if (vector[i].premi == 0) {
                premisGrans[0] = vector[i].numero;
                vector[i].premi = 4000000;
            } else if (vector[i].premi == 1) {
                premisGrans[1] = vector[i].numero;
                vector[i].premi = 1250000;
            } else if (vector[i].premi == 2) {
                premisGrans[2] = vector[i].numero;
                vector[i].premi = 500000;
            } else if (vector[i].premi == 3 || vector[i].premi == 4) {
                if (vector[i].premi == 3) {
                    premisGrans[3] = vector[i].numero;
                } else {
                    premisGrans[4] = vector[i].numero;
                }
                vector[i].premi = 200000;
            } else if (vector[i].premi >= 5 && vector[i].premi <= 12) {
                vector[i].premi = 60000;
            } else if (vector[i].premi >= 13 && vector[i].premi <= 1804) {
                vector[i].premi = 60000;
            }
        }
    }

    public static void main(String[] args) {

        NumPremiat VectorPremi[] = new NumPremiat[1807];
        int[] prueba = new int[5];

        GeneradorNumeros(VectorPremi);
        GeneradorPremis(VectorPremi, prueba);

        for (int i = 0; i < TOTPREMS; i++) {
            if (VectorPremi[i].premi == 4000000 || VectorPremi[i].premi == 1250000
                    || VectorPremi[i].premi == 500000 || VectorPremi[i].premi == 200000) {
                System.out.print(VectorPremi[i].numero + " ");
                System.out.println(VectorPremi[i].premi);
            }

        }

        /*FuncionesUtilidades.CountingSort(VectorPremi);
        for(int i=0;i<13;i++){
            System.out.print(VectorPremi[i].numero+" ");
            System.out.println(VectorPremi[i].premi);
        }*/
        System.out.print("Numero de tu boleto: ");
        String Boleto = scan.nextLine();

    }

}
