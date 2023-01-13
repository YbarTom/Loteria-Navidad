/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package loterianavidad;

import java.util.Scanner;
public class LoteriaNavidad {
    public static Scanner scan = new Scanner(Sysrtem.in);

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

    public static void main(String[] args) {
        // TODO code application logic here

        //prueba para ver si va  gfdgdfgf
    }

}
