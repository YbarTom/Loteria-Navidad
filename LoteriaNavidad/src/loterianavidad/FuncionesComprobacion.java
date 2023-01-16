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
    }
    
    public static int comprovarAproximacions(int numero, int premi1, int premi2, int premi3){
        int premi = 0;
        final int PREMI_APROX1 = 40000;
        final int PREMI_APROX2 = 25000;
        final int PREMI_APROX3 = 19200;
        
        if(AproximacioPrimer(numero, premi1)){
            premi += PREMI_APROX1;
        }
        else if(AproximacioSegon(numero, premi2)){
            premi += PREMI_APROX2;
        }
        else if(AproximacioTercer(numero, premi3)){
            premi += PREMI_APROX3;
        }
        
        return premi;
    }
    
    public static boolean AproximacioPrimer(int numero, int premi1){
        boolean acertat = false;
        
        if(numero == premi1+1 || numero == premi1-1){
            acertat = true;
        }
        else if(numero == 00000 && premi1 == 99999){
            acertat = true;
        }
        
        return acertat;
    }
    
    public static boolean AproximacioSegon(int numero, int premi2){
        boolean acertat = false;
        
        if(numero == premi2+1 || numero == premi2-1){
            acertat = true;
        }
        else if(numero == 00000 && premi2 == 99999){
            acertat = true;
        }
        
        return acertat;
    }
    
    public static boolean AproximacioTercer(int numero, int premi3){
        boolean acertat = false;
        
        if(numero == premi3+1 || numero == premi3-1){
            acertat = true;
        }
        else if(numero == 00000 && premi3 == 99999){
            acertat = true;
        }
        
        return acertat;
    }
    
    public static comprovarCentena(int numero){
        
    }
    
    public static boolean CentenaPrimer(int numero){
        
    }
    

}
