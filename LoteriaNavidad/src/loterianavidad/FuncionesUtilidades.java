package loterianavidad;

import static loterianavidad.LoteriaNavidad.scan;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import static loterianavidad.LoteriaNavidad.TotPrems;

public class FuncionesUtilidades {

    /**
     * Funcion Comprobar si el numero es un entero
     *
     * @param numero
     */
    public static void Entero(int numero) {

        boolean correcte = false;

        do {
            if (scan.hasNextInt()) {
                numero = scan.nextInt();
                correcte = true;
            } else {
                scan.next();
                System.out.println("El caracter introduit no es un numero,si us plau introduiu un numero: ");

            }
        } while (correcte == false);
    }

    public static void CountingSort(LoteriaNavidad.NumPremiat[] vector) {

        LoteriaNavidad.NumPremiat[] output = new LoteriaNavidad.NumPremiat[TotPrems + 1];

        int max = vector[0].premi;
        
        for (int i = 1; i < TotPrems; i++) {
            if (vector[i].premi > max) {
                max = vector[i].premi;
            }
        }
        
        int[] count=new int [max+1];
        
        for(int i=0;i<max;++i){
            count[i]=0;
        }
        
        for(int i=0;i<TotPrems;i++){
            count[vector[i].premi]++;
        }
        
        for(int i=1;i<=max;i++){
            count[i] += count[i-1];
        }
        
        for(int i=TotPrems-1;i>=0;i--){
            output[i]=new LoteriaNavidad.NumPremiat();
            output[count[vector[i].premi]-1].premi=vector[i].premi;
            count[vector[i].premi]--;
        }
        
        for(int i=0;i<TotPrems;i++){
            vector[i].premi = output[i].premi;
        }

    }
}
