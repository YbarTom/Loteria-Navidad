package loterianavidad;

import java.util.Scanner;

public class FuncionesComprobacion {

    public static Scanner scan = new Scanner(System.in);

    public static int comprovacioGeneral(int numero, int[] premisGrans, LoteriaNavidad.NumPremiat[] llistaPremis) {
        int premi = 0;

        premi += comprovarGrossos(numero, llistaPremis);

        if (comprovarAproximacions(numero, premisGrans[0], premisGrans[1], premisGrans[2]) != 0) {
            premi += comprovarAproximacions(numero, premisGrans[1], premisGrans[2], premisGrans[3]);
        } else {
            eliminarNumero(numero, premisGrans);

            String numeroString = passarAString(numero);

            String[] premisStrings = new String[premisGrans.length];

            for (int i = 0; i < premisGrans.length; ++i) {
                premisStrings[i] = passarAString(premisGrans[i]);
            }
            if (comprovarCentenes(numeroString, premisStrings[0], premisStrings[1], premisStrings[2], premisStrings[3], premisStrings[4])) {
                premi += 1000;
            } else if (comprovarUltims(numeroString, premisStrings[0], premisStrings[1], premisStrings[2])) {
                premi += 1000;
            } else if (reintegrament(numeroString, premisStrings[0])) {
                premi += 200;
            }
        }

        return premi;
    }

    /**
     * Comprovar premis exactes.
     * Funció per comprovar si s'ha acertat de manera exacta un premi.
     * @param numero El nostre número que volem comprovar
     * @param llistaPremis La llista amb tots els números que han sigut premiats
     * amb els seus respectius premis.
     * @return La quantitat de diners guanyats.
     */
    public static int comprovarGrossos(int numero, LoteriaNavidad.NumPremiat[] llistaPremis) {
        int premi = 0;
        boolean trobat = false;

        for (int i = 0; i < llistaPremis.length && !trobat; ++i) {
            if (numero == llistaPremis[i].numero) {
                premi += llistaPremis[i].premi;
                trobat = true;
            }
        }
        return premi;
    }

    /**
     * Comprovar si un número donat és una aproximació d'un altre.
     * Comprovem si el número donat és anterior o posterior al premi.
     * Es considera que l'anterior a 0 és 99999 i el posterior a 99999 és 0.
     * @param numero El nostre número.
     * @param premi El número premiat.
     * @return true si és una aproximació i false si no ho és
     */
    public static boolean Aproximacio(int numero, int premi) {
        boolean acertat = false;

        //Comprovem si el número anterior i posterior coincideixen amb el nostre
        if (numero == premi + 1 || numero == premi - 1) {
            acertat = true;
        } //Si el número és 00000 es considera 99999 el seu anterior
        //Si el número és 99999 el 00000 es considera el posterior
        else if ((numero == 0 && premi == 99999) || (numero == 99999 && premi == 0)) {
            acertat = true;
        }

        return acertat;
    }

    /**
     * Comprovar si un número donat és una aproximació d'un dels premis donats.
     * Comprovem si el número donat és anterior o posterior a algun dels premis.
     * Les aproximacions són només pel primer, segon i tercer premis.
     * @param numero El nostre número que volem comprovar.
     * @param premi1 El número que ha resultat com a primer premi.
     * @param premi2 El número que ha resultat com a segon premi.
     * @param premi3 El número que ha resultat com a tercer premi.
     * @return La quantitat de diners guanyats.
     */
    public static int comprovarAproximacions(int numero, int premi1, int premi2, int premi3) {
        int premi = 0;

        //Quantitats de premi per cada aproximació
        final int PREMI_APROX1 = 20000;
        final int PREMI_APROX2 = 12500;
        final int PREMI_APROX3 = 9600;

        //Comprovem les aproximacions de cada premi individualment
        //si coincideixen sumem el premi
        if (Aproximacio(numero, premi1)) {
            premi += PREMI_APROX1;
        }
        if (Aproximacio(numero, premi2)) {
            premi += PREMI_APROX2;
        }
        if (Aproximacio(numero, premi3)) {
            premi += PREMI_APROX3;
        }

        return premi;
    }

    /**
     * Eliminar un número específic del vector de premis grans.
     * Substituir el número donat per -11111 per no afectar les comprovacions posteriors.
     * Una vegada ens ha tocat un premi gros hem de comprovar si tenim un dels premis menors,
     * però aquests premis menors obviament no poden ser del nostre propi número ja premiat.
     * @param numero El nostre número que volem comprovar.
     * @param premisGrans El vector que conté tots els números que han sigut premiats amb
     * premis d'interès (el primer, el segon, el tercer i els dos quarts).
     */
    public static void eliminarNumero(int numero, int[] premisGrans) {
        for (int i = 0; i < premisGrans.length; ++i) {
            if (premisGrans[i] == numero) {
                //Nombre invàlid perquè no afecti
                premisGrans[i] = -11111;
            }
        }
    }

    /**
     * Contar quants digits té un número.
     * 
     * @param numero El numero del qual volem saber els dígits.
     * @return La quantitat de dígits que té el número.
     */
    public static int contarDigits(int numero) {
        int resultat = 0;
           
        while(numero > 10){
            numero = numero/10;
            ++resultat;
        }
        ++resultat;
        
        return resultat;
    }

    /**
     * Passar un número enter a String afegint els zeros inicials en cas que es necessitin.
     * 
     * @param numero El nostre número que volem passar a String.
     * @return El número donat en format String amb els zeros anteriors que es necessitin.
     */
    public static String passarAString(int numero) {
        int nZerosAfegir = 5 - contarDigits(numero);

        String numeroString = Integer.toString(numero);

        String resultat = numeroString;
        
        for (int i = 0; i < nZerosAfegir; ++i) {
            resultat = "0" + resultat;
        }
        return resultat;
    }

    /**
     * 
     * @param numero
     * @param premi1
     * @param premi2
     * @param premi3
     * @param premi4
     * @param premi5
     * @return 
     */
    public static boolean comprovarCentenes(String numero, String premi1, String premi2, String premi3, String premi4, String premi5) {
        boolean premi = false;

        if (comprovarDigits(numero, premi1, 0, 3)
                || comprovarDigits(numero, premi2, 0, 3)
                || comprovarDigits(numero, premi3, 0, 3)
                || comprovarDigits(numero, premi4, 0, 3)
                || comprovarDigits(numero, premi5, 0, 3)) {
            premi = true;
        }

        return premi;
    }

    public static boolean comprovarUltims(String numero, String premi1, String premi2, String premi3) {
        boolean premi = false;

        if (comprovarDigits(numero, premi1, 3, 5)
                || comprovarDigits(numero, premi2, 3, 5)
                || comprovarDigits(numero, premi3, 3, 5)) {
            premi = true;
        }

        return premi;
    }

    public static boolean reintegrament(String numero, String premi1) {
        boolean premi = false;

        if (numero.charAt(4) == premi1.charAt(4)) {
            premi = true;
        }

        return premi;
    }

    public static boolean comprovarDigits(String numero, String premi, int inici, int finalNumero) {
        boolean acertat = false;

        if (numero.substring(inici, finalNumero).equals(premi.substring(inici, finalNumero))) {
            acertat = true;
        }

        return acertat;
    }

}
