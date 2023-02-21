package loterianavidad;

import static loterianavidad.LoteriaNavidad.scan;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
public class FuncionesUtilidades {

    /**
     * Demana entrades per consola fins que se li dona un número enter que estigui dins del nostre interval.
     *
     * @param missatge Un missatge per demanar el número
     * @return El número enter en qüestió
     */
    public static int Entero(String missatge) {
        int numero = 0;
        final int NUMERO_MAX = 99999;
        final int NUMERO_MIN = -1;

        boolean correcte = false;
        System.out.println(missatge);

        do {
            if (scan.hasNextInt()) {
                numero = scan.nextInt();
                if(numero > NUMERO_MAX || NUMERO_MIN < -1){
                    System.out.println(FuncionsIdiomes.LlegirLineas(LoteriaNavidad.buf, 4));
                    
                }
                else{
                    correcte = true;
                }
            } else {
                scan.next();
                System.out.println("El caracter introduit no es un numero,si us plau introduiu un numero: ");
            }
        } while (correcte == false);
        return numero;
    }

}
