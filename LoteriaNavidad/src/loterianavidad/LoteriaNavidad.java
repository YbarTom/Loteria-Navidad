/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package loterianavidad;

import java.util.Scanner;
import static loterianavidad.FuncionesComprobacion.scan;

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
        AssignarPremis(vector);
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

    public static void AssignarPremis(NumPremiat[] vector, int[] premisGrans) {
        
        for (int i = 0; i < TotPrems; i++) {
            if (vector[i].premi == 0) {
                premisGrans[0]= vector[i].numero;
                vector[i].premi = 4000000;
            } else if (vector[i].premi == 1) {
                premisGrans[1]= vector[i].numero;
                vector[i].premi = 1250000;
            } else if (vector[i].premi == 2) {
                premisGrans[2]= vector[i].numero;
                vector[i].premi = 500000;
            } else if (vector[i].premi == 3 || vector[i].premi == 4) {
                if(vector[i].premi==3){
                    premisGrans[3]= vector[i].numero;
                }else{
                    premisGrans[4]= vector[i].numero;
                }
                vector[i].premi = 200000;
            } else if (vector[i].premi >= 5 || vector[i].premi <= 12) {
                vector[i].premi = 60000;
            } else if (vector[i].premi >= 13 || vector[i].premi <= 1804) {
                vector[i].premi = 60000;
            }
        }
    }

    public static void main(String[] args) {

        NumPremiat VectorPremi[] = new NumPremiat[1807];

        //prueba para ver si va  gfdgdfgf ewrferferw
        
        System.out.print("Numero de tu boleto: ");
        String Boleto= scan.nextLine();
       
    }

}
