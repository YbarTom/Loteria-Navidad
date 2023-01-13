/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loterianavidad;

/**
 *
 * @author ausias
 */
public class FuncionesComprobacion {
    
    /**
     * 
     * @param numero
     * @param vector
     * @return tornarà a quina posició del vector de premis es troba el numero, -1 si no hi és
     */
    public static int comprovarPremi(int numero, Class[] vector){
        int posicio = -1;
        
        for(int i = 0; i < vector.length; ++i){
            if(vector[i].numero == numero){
                posicio = i;
            }
        }
        
        return posicio;
        int hola;
    }

}
