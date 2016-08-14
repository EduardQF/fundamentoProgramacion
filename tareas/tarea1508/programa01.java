
package ejercicios.programacion;

import java.util.Scanner;

public class programa01 {

    public static void main(String[] args) {
        char matriz[][]=new char[2][500];
        rellenoM(matriz);
        menu(matriz);
    }

    private static int leerNum() {
        Scanner intro=new Scanner(System.in);
        int num;String leer;
        do{
            leer=intro.nextLine();
            if(!leer.matches("[0-9]+")){System.out.println("WARNING ingrese numeros ");}
        }while(!leer.matches("[0-9]+"));
        num=Integer.parseInt(leer);
        return num;
    }

    private static void encuesta(char[][] matriz,int i) {
        char sexo,aprovacion;
        System.out.println("codigos:\nSexo:m=masculino\n     f=femenino\naprovacion:a=aprueba\n           n=desaprueba\n          x=no sabe o no opina");
            System.out.print("---------------   \n"
                             + "encuestado"+(i+1)
                             + "\nSexo:");
            do{
                sexo=leerchar();
                if (!(sexo=='m'||sexo=='f')){System.out.println("ingrese m=Masculino o f=Femenino");           }
            }while(!(sexo=='m' || sexo=='f'));
            
            System.out.print("Aprobacion:");
            do {
                aprovacion=leerchar();
                if (!(aprovacion=='s' || aprovacion=='n' || aprovacion=='x')) { 
                    System.out.println("ingrese s=aprueva, n=desaprueba,x= no sabe o no responde");
                }
            } while (!(aprovacion=='s' || aprovacion=='n' || aprovacion=='x'));
            matriz[0][i]=sexo;
            matriz[1][i]=aprovacion;
        
        
    }

    private static char leerchar() {
         Scanner intro=new Scanner(System.in);
        String leer;char letra;
        do{
            leer=intro.nextLine();
            if(!leer.matches("[a-z]+")){System.out.println("WARNING ingrese letras");}
        }while(!leer.matches("[a-z]+"));
        letra=leer.charAt(0);
        return letra;
    }

    private static void estadisticas(char[][] matriz) {
        int MasculinoA,FemeninoD,TotalAprobado,total;
        MasculinoA=comparador('m','s',matriz);
        FemeninoD=comparador('f','n',matriz);
        TotalAprobado=comparador('m','s',matriz)+comparador('f','s',matriz);
        total=totall(matriz);
        System.out.println("-----------------------------------------------------------\n"
                           +MasculinoA+" Hombres aprueban la gestion del gobierno.\n"
                           +FemeninoD+" Mujeres desaprueban la gestion del gobierno.\n"
                           +TotalAprobado+" personas aprueban la gestion del gobierno.\n"
                           +total+" personas participaron en la encuesta.\n"
                           +"----------------------------------------------------------");
    }

    private static int comparador(char sexo, char opinion,char[][] matriz) {
        int cont=0;
        for (int i = 0; i < matriz[0].length; i++) {
            if(matriz[0][i]==sexo && matriz[1][i]==opinion){
                cont++;
            }
        }
        return cont;
    }

    private static void menu(char[][] matriz) {
        int op,i=0;
        do{
            System.out.print("\n");
            System.out.print("1.rellenar encuesta\n2.ver estadisticas\n3.salir\nopcion:");
            op=leerNum();
            System.out.print("\n");
            switch (op) {
                case 1: encuesta(matriz,i);i++; break;
                case 2: estadisticas(matriz); break;
                case 3:System.out.println("ADIOS!!");break;
                default:System.out.println("ingrese una opcion valida.");
            }
        }while(op!=3);
    }

    private static int totall(char[][] matriz) {
        int cont=0;
        for (int i = 0; i < matriz[0].length; i++) {
            if(matriz[0][i]!='a'){
                cont++;
            }
        }
        return cont;
    }

    private static void rellenoM(char[][] matriz) {
        for (int i = 0; i < matriz[0].length; i++) {
            matriz[0][i]='a';
        }
    }

}
