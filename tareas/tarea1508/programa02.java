
package ejercicios.programacion;

public class programa02 {
    public static void main(String[] args) {
        int M[][]=new int[3][3];
        rellenado(M);
        mostrar(M);
        MagicCube(M);
    }

    private static void rellenado(int [][]M) {
        int aux;
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                do{
                    aux=(int)(Math.random()*9+1);
                }while(aux==M[0][0]||aux==M[0][1]||aux==M[0][2]||aux==M[1][0]||aux==M[1][1]||aux==M[1][2]||aux==M[2][0]||aux==M[2][1]||aux==M[2][2]);
                M[i][j]=aux;
            }
        }
    }

    private static void mostrar(int[][] M) {
        System.out.println("diagrama de la matriz:");
        for (int i = 0; i < M.length; i++) {
            System.out.println(M[i][0]+"\t"+M[i][1]+"\t"+M[i][2]+"\n");
        }
    }

    private static void MagicCube(int[][] M) {
        int H1,H2,H3,V1,V2,V3,D1,D2;
        H1=M[0][0]+M[0][1]+M[0][2];
        H2=M[1][0]+M[1][1]+M[1][2];
        H3=M[2][0]+M[2][1]+M[2][2];
        V1=M[0][0]+M[1][0]+M[2][0];
        V2=M[0][1]+M[1][1]+M[2][1];
        V3=M[0][2]+M[1][2]+M[2][2];
        D1=M[0][0]+M[1][1]+M[2][2];
        D2=M[0][2]+M[1][1]+M[2][0];
        if (H1==15 && H2==15 && H3==15 && V1==15 && V2==15 && V3==15 && D1==15 && D2==15) {
            System.out.println("FELICIDADES, la matriz es un cuadrado magico!!");
        }else{
            System.out.println("MALA SUERTE, la matriz no es un cuadrado magico");
        }
    }
    
}
