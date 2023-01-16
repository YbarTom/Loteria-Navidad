/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package loterianavidad;

import java.util.Scanner;
public class LoteriaNavidad {
    public static Scanner scan = new Scanner(System.in);
   
    static final int TotNums=99999;
    static final int TotPrems=1807;
   
    class NumPremiat{
        int numero;
        int premi;
    }
   
    public static int GeneradorNumeros(){
        int NumeroAleatorio = (int) (Math.random()*TotNums+1);
       
        return NumeroAleatorio;
    }
   
    public static int GeneradorPremis(){
        int PremioAleatorio = (int) (Math.random()*TotPrems+1);
       
        return PremioAleatorio;
    }
   
    public static boolean ComprobarRepetidos(int n){
        int contador=1;
        boolean comprovacio=true;
       
        int[] comprovar = new int[TotPrems];
       
       
        for(int i=0;i<TotPrems;i++){
             
        }
        return comprovacio;
       
    }

    public static void main(String[] args) {
       
        NumPremiat VectorPremi[] = new NumPremiat[1807];
       
       
        //prueba para ver si va  gfdgdfgf ewrferferw
    }

}