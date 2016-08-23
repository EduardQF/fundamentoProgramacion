package ejercicios.programacion;

import java.util.Scanner;

/**
 *
 * @author Eduardo
 */
public class usoString {

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        int op = 0;
        String palabra = null;
        do {
            System.out.print("1.recibir un String\n"
                    + "2.retornan largo de la cadena\n"
                    + "3.cantidad de vocales\n"
                    + "4.cantidad consonantes\n"
                    + "5.invertir la cadena\n"
                    + "6.letra repetidas\n"
                    + "7.???\n"
                    + "8.crear una cadena a traves del String \n"
                    + "9.salir\n"
                    + "op:");
            op = leerOP();
            switch (op) {
                case 1:
                    System.out.println("ingrese String");
                    palabra = leerString();System.out.print("\n");
                    break;
                case 2:
                    imprimirResultados(palabra, 2);System.out.print("\n");
                    break;
                case 3:
                    imprimirResultados(palabra, 3);System.out.print("\n");
                    break;
                case 4:imprimirResultados(palabra, 4);System.out.print("\n");
                    break;
                case 5:imprimirResultados(palabra, 5);System.out.print("\n");
                    break;
                case 6:imprimirResultados(palabra, 6);System.out.print("\n");
                    break;
                case 7:System.out.println("no entendi a que se refiere !!");
                    break;
                case 8:imprimirResultados(palabra,8);
                    break;
                case 9:System.out.println("ADIOS!!");
                    break;
                default:
                    System.out.println("Opcion Invalida");

            }
        } while (op != 9);

    }

    private static int leerOP() {
        Scanner intro = new Scanner(System.in);
        int num;
        String leer;
        do {
            leer = intro.nextLine();
            if (!leer.matches("[0-9]+")) {
                System.out.println("WARNING ingrese numeros ");
            }
        } while (!leer.matches("[0-9]+"));
        num = Integer.parseInt(leer);
        return num;
    }

    private static String leerString() {
        Scanner intro = new Scanner(System.in);
        String leer;
        leer = intro.nextLine();
        return leer;
    }

    private static int largoCadena(String palabras) {
        int largo=palabras.length();
        return largo;
    }

    private static boolean ESVocales(String palabra, int lugar) {
        String letra=palabra.substring(lugar,lugar+1);
        if (letra.matches("[aAeEiIoOuU]{0,1}")) {
            return true;
        }
        return false;
    }

    private static int Vocales(String palabra) {
        int cont=0;
        for (int i = 0; i < palabra.length(); i++) {
            if(ESVocales(palabra,i)){
                cont++;
            }
        }
        return cont;
    }

    private static int Consonantes(String palabra) {
        int cont=0;
        for (int i = 0; i < palabra.length(); i++) {
            if (!ESVocales(palabra,i)) {
                String letra=palabra.substring(i,i+1);
                if(palabra.matches("[a-zAz]{0,1}")){
                    cont++;
                }
            }
        }
        return cont;
    }

    private static String invertir(String palabra) {
        String invertida="";
        for (int i = palabra.length()-1; i > -1; i--) {
            invertida=invertida+palabra.charAt(i);
        }
        return invertida;
    }

    private static boolean existeChar(String palabra, char letra) {
        for (int i = 0; i < palabra.length(); i++) {
            if(letra==palabra.charAt(i)){
                return true;
            }
        }
        return false;
    }

    private static char[] crearArrayChar(String palabra) {
        char Array[]=new char[palabra.length()];
        for (int i = 0; i < palabra.length(); i++) {
            Array[i]=palabra.charAt(i);
        }
        return Array;
    }

    private static void imprimirResultados(String palabra, int op) {
        switch (op) {
            case 2:
                System.out.println("l largo de la cadena es: "+largoCadena(palabra)+" caracteres.");
                break;
            case 3:
                System.out.println("el String tiene "+Vocales(palabra)+" vocales");
                break;
            case 4:
                System.out.println("la palabra tiene "+Consonantes(palabra)+" consonantes");
                break;
            case 5:
                System.out.println("la palabra invertida es:\n"+invertir(palabra));
                break;
            case 6:
                System.out.println("ingrese la letra a buscar");
                char lee=leerString().charAt(0);
                if(existeChar(palabra, lee)){
                    System.out.println("El caracter se encuentra en el String");
                }else
                    System.out.println("EL caracter no se encuentra en el String");
                break;
            case 7:
                
                break;
            case 8:
                System.out.println("el nuevo Array es:");
                char Array[]= crearArrayChar(palabra);
                for (int i = 0; i < Array.length; i++) {
                    System.out.print(Array[i]);
                }
                break;
            default:
                throw new AssertionError();
        }
    }
}
