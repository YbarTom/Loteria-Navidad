package loterianavidad;

import java.util.Scanner;

public class FuncionesComprobacion {

    public static Scanner scan = new Scanner(System.in);

    public static int comprovacioGeneral(int numero, int[] premisGrans, NumPremiat[] llistaPremis) {
        int premi = 0;

        premi += comprovarGrossos(numero, llistaPremis);

        if (comprovarAproximacions(numero, premisGrans[1], premisGrans[2], premisGrans[3]) != 0) {
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

    public static int comprovarGrossos(int numero, NumPremiat[] llistaPremis) {
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

    public static void eliminarNumero(int numero, int[] premisGrans) {
        for (int i = 0; i < premisGrans.length; ++i) {
            if (premisGrans[i] == numero) {
                premisGrans[i] = -11111;
            }
        }
    }

    public static int contarDigits(int numero) {
        int resultat;

        if (numero < 10) {
            resultat = 1;
        } else if (numero < 100) {
            resultat = 2;
        } else if (numero < 1000) {
            resultat = 3;
        } else if (numero < 10000) {
            resultat = 4;
        } else {
            resultat = 5;
        }

        return resultat;
    }

    public static String passarAString(int numero) {
        String resultat = "";
        int nZerosAfegir = 5 - contarDigits(numero);

        //00010 10
        String numeroString = Integer.toString(numero);

        for (int i = 0; i < nZerosAfegir; ++i) {
            resultat = "0" + numeroString;
        }
        return resultat;
    }

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
            premi = false;
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
