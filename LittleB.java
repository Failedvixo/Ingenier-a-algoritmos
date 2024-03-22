import java.util.Scanner;

class LittleB {

    static int result=0;

    public static boolean isSafe(int col, int row, int[][] tablero, int n){

        int i,j;

        

        for(i = row, j = col; i < n && j < n; i++, j++){ // diagonal abajo derecha
            if(tablero[i][j]==1){
             //   System.out.println("hola");
                return false;
            }
        }

        for(i = row, j = col; i >= 0 && j >= 0; i--, j--){ // diagonal arriba izquierda
            if(tablero[i][j]==1){
             //   System.out.println("hola1");
                return false;
            }
        }

        for(i = row, j = col; i < n && j >= 0 ; i++, j--){ // diagonal abajo izquierda
            if(tablero[i][j]==1){
               // System.out.println("hola2");
                return false;
            }
        }

        for(i = row, j = col; i >= 0 && j < n ; i--, j++){ // diagonal arriba derecha
            if(tablero[i][j]==1){
              //  System.out.println("hola3");
                return false;
            }
        }

        return true;
    }

    public static boolean backtrack(int[][] tablero, int n, int k, int curr_x , int curr_y){
        
        if(k==0){
            result++;
            return true;
        }

        for(int i=curr_x; i<n; i++){
            for(int j = (i == curr_x) ? curr_y : 0; j < n; j++){
                if (isSafe(j, i, tablero, n)){
                    tablero[i][j]=1;

                    backtrack(tablero, n, k-1, i, j);

                    tablero[i][j]=0;
                }
            }
        }
        tablero[curr_x][curr_y]=0;

        return false;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int n, k;

        while (true) {
            n = in.nextInt();
            k = in.nextInt();

            if (n == 0 && k == 0) {
                break;
            }

            int[][] tablero = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    tablero[i][j] = 0;
                }
            }

            backtrack(tablero, n, k, 0, 0);
            System.out.println(result);
            result = 0; // Reiniciar el resultado para el siguiente caso
        }

        in.close();
    }
}