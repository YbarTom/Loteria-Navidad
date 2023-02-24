/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package loterianavidad;

import java.io.BufferedReader;
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

    static BufferedReader buf;
    
    public static void main(String[] args) {
        
        String opcio;
        //llamada de funciones idioma
        opcio=FuncionsIdiomes.MenuIdiomes();
        buf = FuncionsIdiomes.ObrirArxiu(opcio);
       
        NumPremiat VectorPremi[] = new NumPremiat[TOTPREMS];
        int[] premis = new int[PREMISIMPORTANTS];

        GeneradorNumeros(VectorPremi);
        GeneradorPremis(VectorPremi, premis);

        FuncionesSorteo.mostrarPremisGrans(VectorPremi);
        //para los mensajes, usar una funcion que lea lineas, i donde tiene que imprimir un mensaje llamar
        //a la funcion con el indice de la linea donde esta localizado el mensaje
        String missatge=FuncionsIdiomes.LlegirLineas(buf, 1);
        int boleto = FuncionesUtilidades.Entero(missatge);
        
        while (boleto != -1) {
            int premi = FuncionesComprobacion.comprovacioGeneral(boleto, premis, VectorPremi);

            boolean esNum = FuncionesComprobacion.demanarNumero();

            System.out.println(FuncionsIdiomes.LlegirLineas(buf, 3) + FuncionesComprobacion.premiFinal(premi, esNum));

            boleto = FuncionesUtilidades.Entero(FuncionsIdiomes.LlegirLineas(buf, 2));
        }
        
    }

}
