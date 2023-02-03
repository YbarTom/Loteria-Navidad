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
    //Considerem importants els que utilitzem per aproximacions i altres càlculs
    static final int PREMISIMPORTANTS = 5;

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

        NumPremiat VectorPremi[] = new NumPremiat[TOTPREMS];
        int[] premis = new int[PREMISIMPORTANTS];

        GeneradorNumeros(VectorPremi);
        GeneradorPremis(VectorPremi, premis);

        FuncionesSorteo.mostrarPremisGrans(VectorPremi);

        int boleto = FuncionesUtilidades.Entero("Numero de tu boleto (introdueix -1 per sortir): ");
        while (boleto != -1) {
            int premi = FuncionesComprobacion.comprovacioGeneral(boleto, premis, VectorPremi);

            boolean esNum = FuncionesComprobacion.demanarNumero();

            System.out.println("Premi: " + FuncionesComprobacion.premiFinal(premi, esNum));

            boleto = FuncionesUtilidades.Entero("Introduce el seiguiente boleto (introdueix -1 per sortir): ");
        }
        
    }

}
