/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package loterianavidad;

import java.util.Scanner;

public class LoteriaNavidad {

    public static Scanner scan = new Scanner(System.in);

    static final int TotNums = 99999;
    static final int TotPrems = 1807;

    class NumPremiat {

        int numero;
        int premi;
    }

    public static void GeneradorNumeros(NumPremiat[] vector) {
        int contador = 0;
        int numeroAleatorio = (int) (Math.random() * TotNums + 1);

        while (contador < TotPrems) {
            if (!RepetidosNumeros(numeroAleatorio, contador, vector)) {
                vector[contador].numero = numeroAleatorio;
                ++contador;
            }
            numeroAleatorio = (int) (Math.random() * TotNums + 1);
        }

    }

    public static void GeneradorPremis(NumPremiat[] vector) {
        int contador = 0;
        int PremioAleatorio = (int) (Math.random() * TotPrems + 1);

        while (contador < TotPrems) {
            if (!RepetidosNumeros(PremioAleatorio, contador, vector)) {
                vector[contador].premi = PremioAleatorio;
                ++contador;
            }
            PremioAleatorio = (int) (Math.random() * TotPrems + 1);
        }
    }

    public static boolean RepetidosNumeros(int n, int contador, NumPremiat[] vector) {
        boolean comprovacio = false;

        for (int i = 0; i <= contador && !comprovacio; i++) {
            if (n == vector[i].numero) {
                comprovacio = true;
            }
        }

        return comprovacio;

    }

    public static boolean RepetidosPremis(int n, int contador, NumPremiat[] vector) {
        boolean comprovacio = false;

        for (int i = 0; i <= contador && !comprovacio; i++) {
            if (n == vector[i].premi) {
                comprovacio = true;
            }
        }

        return comprovacio;
    }

    public static void main(String[] args) {

        NumPremiat VectorPremi[] = new NumPremiat[1807];

        //prueba para ver si va  gfdgdfgf ewrferferw
    }

}
