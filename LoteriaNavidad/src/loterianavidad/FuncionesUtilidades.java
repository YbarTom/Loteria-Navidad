package loterianavidad;

import static loterianavidad.LoteriaNavidad.scan;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class FuncionesUtilidades {

    /**
     * Demana entrades per consola fins que se li dona un número enter.
     * @return El número enter en qüestió
     */
    public static int Entero() {
        int numero = 0;
        
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
        return numero;
    }

}
