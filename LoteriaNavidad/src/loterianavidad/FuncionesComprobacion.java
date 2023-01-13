/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loterianavidad;

import static loterianavidad.LoteriaNavidad.scan;

/**
 *
 * @author ausias
 */
public class FuncionesComprobacion {
    /**
     * Funcion Comprobar si el numero es un entero
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
}
