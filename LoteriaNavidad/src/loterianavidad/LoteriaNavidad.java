/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package loterianavidad;

import java.util.Scanner;
import static loterianavidad.FuncionesSorteo.GeneradorNumeros;
import static loterianavidad.FuncionesSorteo.GeneradorPremis;

public class LoteriaNavidad {

    public static Scanner scan = new Scanner(System.in);

    static final int TOTNUMS = 99999;
    static final int TOTPREMS = 1807;

    //constantes dinero premio
    static final int PRIMERPREMI = 4000000;
    static final int SEGONPREMI = 1250000;
    static final int TERCERPREMI = 500000;
    static final int QUARTPREMI = 200000;
    static final int CINQUEPREMI = 60000;
    static final int SISEPREMI = 1000;

    public static class NumPremiat {

        int numero;
        int premi;
    }

    
    public static void main(String[] args) {

        NumPremiat VectorPremi[] = new NumPremiat[1807];
        int[] premis = new int[5];

        GeneradorNumeros(VectorPremi);
        GeneradorPremis(VectorPremi, premis);

        for (int i = 0; i < TOTPREMS; i++) {
            if (VectorPremi[i].premi == PRIMERPREMI || VectorPremi[i].premi == SEGONPREMI
                    || VectorPremi[i].premi == TERCERPREMI || VectorPremi[i].premi == QUARTPREMI
                    || VectorPremi[i].premi == CINQUEPREMI) {
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
        int boleto = scan.nextInt();

        int premi = FuncionesComprobacion.comprovacioGeneral(boleto, premis, VectorPremi);
        
        System.out.println("Premi: " + premi);
    }

}
