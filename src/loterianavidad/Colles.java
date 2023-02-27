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
        System.out.println(FuncionsIdiomes.LlegirLineas(LoteriaNavidad.buf, 17));
        System.out.println(FuncionsIdiomes.LlegirLineas(LoteriaNavidad.buf, 18));
        System.out.println(FuncionsIdiomes.LlegirLineas(LoteriaNavidad.buf, 19));
        System.out.println(FuncionsIdiomes.LlegirLineas(LoteriaNavidad.buf, 20));
    }
    
    public static void gestionarOpcions(){
        int opcio = FuncionesUtilidades.Entero(FuncionsIdiomes.LlegirLineas(LoteriaNavidad.buf, 16));
        while(opcio != 0){
            if(opcio == 1){
                
            }
            else if(opcio == 2){
                
            }
            else{
                System.out.println(FuncionsIdiomes.LlegirLineas(LoteriaNavidad.buf, 13));
            }
        }
    }
}
