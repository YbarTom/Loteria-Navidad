package loterianavidad;

import java.util.Scanner;

public class FuncionesComprobacion {

    public static Scanner scan = new Scanner(System.in);

    /**
     * Realitza totes les comprovacions i suma els premis corresponents. Crida a
     * totes les altres funcions de comprovació i suma els premis.
     *
     * @param numero El nostre número que volem comprovar
     * @param premisGrans Un array que conté els numeros premiats del primer
     * premi als dos quarts
     * @param llistaPremis Un array amb tots els números amb el seu premi
     * assignat.
     * @return La quantita de diners que s'han guanyat amb el número donat.
     */
    public static int comprovacioGeneral(int numero, int[] premisGrans, LoteriaNavidad.NumPremiat[] llistaPremis) {
        int premi = 0;
        final int PREMI_CENTENES = 1000;
        final int PREMI_DOSULTIMS = 1000;
        final int REINTEGRAMENT = 200;

        premi += comprovarGrossos(numero, llistaPremis);
        int aproximacions = comprovarAproximacions(numero, premisGrans[0], premisGrans[1], premisGrans[2]);
        if (aproximacions != 0) {
            premi += aproximacions;
        }
        eliminarNumero(numero, premisGrans);

        String numeroString = passarAString(numero);

        String[] premisStrings = new String[premisGrans.length];

        for (int i = 0; i < premisGrans.length; ++i) {
            premisStrings[i] = passarAString(premisGrans[i]);
        }
        if (comprovarCentenes(numeroString, premisStrings[0], premisStrings[1], premisStrings[2], premisStrings[3], premisStrings[4])) {
            premi += PREMI_CENTENES;
        }
        if (comprovarDosUltims(numeroString, premisStrings[0], premisStrings[1], premisStrings[2])) {
            premi += PREMI_DOSULTIMS;
        }
        if (reintegrament(numeroString, premisStrings[0])) {
            premi += REINTEGRAMENT;
        }
        restaurarNumero(numero, premisGrans);

        return premi;
    }
    
    /**
     * Restaurar un número no vàlid del array de premis grans per un número donat.
     * @param numero El número que volem restaurar al array.
     * @param premisGrans L'array amb els números.
     */
    public static void restaurarNumero(int numero, int[] premisGrans){
        boolean trobat = false;
        for(int i = 0; i < premisGrans.length && !trobat; ++i){
            if(premisGrans[i] == -11111){
                premisGrans[i] = numero;
                trobat = true;
            }
        }
    }

    /**
     * Demanem si volem comprovar un dècim o un número. Seguirem preguntant fins
     * que ens donin una resposta vàlida.
     *
     * @return false si volem comprovar un dècim i true si volem comprovar un
     * número
     */
    public static boolean demanarNumero() {
        boolean numero = false;
        boolean valid = false;

        int entrada = FuncionesUtilidades.Entero(FuncionsIdiomes.LlegirLineas(LoteriaNavidad.buf, 6));
        while (!valid) {
            switch (entrada) {
                case 0:
                    numero = false;
                    valid = true;
                    break;
                case 1:
                    numero = true;
                    valid = true;
                    break;
                default:
                    entrada = FuncionesUtilidades.Entero(FuncionsIdiomes.LlegirLineas(LoteriaNavidad.buf, 7));
                    break;
            }
        }

        return numero;
    }

    /**
     * Calcula el premi final segons si tenim un número o un dècim.
     *
     * @param premi El premi sense canvis
     * @param esNumero True si és un número false si és un dècim
     * @return El premi segons si és número o dècim
     */
    public static int premiFinal(int premi, boolean esNumero) {
        final int QUANTITAT_DECIMS = 10;
        if (!esNumero) {
            premi = premi / QUANTITAT_DECIMS;
        }
        return premi;
    }

    /**
     * Comprovar premis exactes. Funció per comprovar si s'ha acertat de manera
     * exacta un premi.
     *
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
     * Comprovar si un número donat és una aproximació d'un altre. Comprovem si
     * el número donat és anterior o posterior al premi. Es considera que
     * l'anterior a 0 és 99999 i el posterior a 99999 és 0.
     *
     * @param numero El nostre número.
     * @param premi El número premiat.
     * @return true si és una aproximació i false si no ho és
     */
    public static boolean Aproximacio(int numero, int premi) {
        boolean acertat = false;
        final int PRIMER_NUMERO = 0;
        final int ULTIM_NUMERO = 99999;

        //Comprovem si el número anterior i posterior coincideixen amb el nostre
        if (numero == premi + 1 || numero == premi - 1) {
            acertat = true;
        } //Si el número és 00000 es considera 99999 el seu anterior
        //Si el número és 99999 el 00000 es considera el posterior
        else if ((numero == PRIMER_NUMERO && premi == ULTIM_NUMERO)
                || (numero == ULTIM_NUMERO && premi == PRIMER_NUMERO)) {
            acertat = true;
        }

        return acertat;
    }

    /**
     * Comprovar si un número donat és una aproximació d'un dels premis donats.
     * Comprovem si el número donat és anterior o posterior a algun dels premis.
     * Les aproximacions són només pel primer, segon i tercer premis.
     *
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
     * Eliminar un número específic del vector de premis grans. Substituir el
     * número donat per -11111 per no afectar les comprovacions posteriors. Una
     * vegada ens ha tocat un premi gros hem de comprovar si tenim un dels
     * premis menors, però aquests premis menors obviament no poden ser del
     * nostre propi número ja premiat.
     *
     * @param numero El nostre número que volem comprovar.
     * @param premisGrans El vector que conté tots els números que han sigut
     * premiats amb premis d'interès (el primer, el segon, el tercer i els dos
     * quarts).
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
     * Passar un número enter a String afegint els zeros inicials en cas que es
     * necessitin.
     *
     * @param numero El nostre número que volem passar a String.
     * @return El número donat en format String amb els zeros anteriors que es
     * necessitin.
     */
    public static String passarAString(int numero) {
        String resultat = String.format("%05d", numero);

        return resultat;
    }

    /**
     * Comprovar si un número donat és una centena d'un dels premis. Les
     * centenes són la coincidencia dels 3 primers dígits del primer, segon i
     * tercer premi.
     *
     * @param numero El nostre número que volem comprovar.
     * @param premi1 El número que ha resultat com a primer premi.
     * @param premi2 El número que ha resultat com a segon premi.
     * @param premi3 El número que ha resultat com a tercer premi.
     * @param premi4 El primer número del quart premi.
     * @param premi5 El segon número del quart premi.
     * @return true si coincideix una de les centenes i false si no coincideix
     * cap
     */
    public static boolean comprovarCentenes(String numero, String premi1, String premi2, String premi3, String premi4, String premi5) {
        boolean premi = false;
        final int INICI = 0;
        final int FINAL = 3;

        if (comprovarDigits(numero, premi1, INICI, FINAL)
                || comprovarDigits(numero, premi2, INICI, FINAL)
                || comprovarDigits(numero, premi3, INICI, FINAL)
                || comprovarDigits(numero, premi4, INICI, FINAL)
                || comprovarDigits(numero, premi5, INICI, FINAL)) {
            premi = true;
        }

        return premi;
    }

    /**
     * Comprovar si els dos últims dígits del nostre número coincideixen amb els
     * d'algun premi.
     *
     * @param numero El nostre número que volem comprovar.
     * @param premi1 El número que ha resultat com a primer premi.
     * @param premi2 El número que ha resultat com a segon premi.
     * @param premi3 El número que ha resultat com a tercer premi.
     * @return true si es troba una coincidencia dels dos últims dígits i false
     * si no es troba
     */
    public static boolean comprovarDosUltims(String numero, String premi1, String premi2, String premi3) {
        boolean premi = false;
        final int INICI = 3;
        final int FINAL = 5;

        if (comprovarDigits(numero, premi1, INICI, FINAL)
                || comprovarDigits(numero, premi2, INICI, FINAL)
                || comprovarDigits(numero, premi3, INICI, FINAL)) {
            premi = true;
        }

        return premi;
    }

    /**
     * Comprovar el reintegrament. El reintegrament és la coincidencia de
     * l'últim dígit amb el primer premi.
     *
     * @param numero El nostre número que volem comprovar.
     * @param premi1 El número que ha resultat com a primer premi.
     * @return true si l'últim dígit coincideix i false si no coincideix.
     */
    public static boolean reintegrament(String numero, String premi1) {
        boolean premi = false;

        if (numero.charAt(numero.length() - 1) == premi1.charAt(numero.length() - 1)) {
            premi = true;
        }

        return premi;
    }

    /**
     * Comprovar si els dígits, en un interval determinat, de dos números,
     * coincideixen.
     *
     * @param numero El nostre número que volem comprovar.
     * @param premi El número amb el que volem comprovar les coincidencies que
     * és un número premiat.
     * @param inici L'indicador d'inici de l'interval (inclusiu).
     * @param finalNumero L'indicador del final de l'interval (exclusiu).
     * @return true si el mateix interval de dos strings coincideixen fals si no
     * coincideixen
     */
    public static boolean comprovarDigits(String numero, String premi, int inici, int finalNumero) {
        boolean acertat = false;

        if (numero.substring(inici, finalNumero).equals(premi.substring(inici, finalNumero))) {
            acertat = true;
        }

        return acertat;
    }

}
