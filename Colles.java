package loterianavidad;

public class Colles {
    public static class Colla{
        String nom;
        int nMembres;
        float importTotal;
        int anySorteig;
        float premiTotal;
    }
    
    public static class Membre{
        String nom;
        int numero;
        float diners;
        float premi;
    }
    
    public static void menuColles(){
        System.out.println("0. Sortir del menu colles");
        System.out.println("1. Afegir colla");
        System.out.println("2. Eliminar colla");
        System.out.println("3. Consultar premis");
    }
    
    public static void gestionarOpcions(){
        int opcio = FuncionesUtilidades.Entero("Selecciona una opció: ");
        while(opcio != 0){
            if(opcio == 1){
                
            }
            else if(opcio == 2){
                
            }
            else{
                System.out.println("ERROR! Opció no vàlida");
            }
        }
    }
}
