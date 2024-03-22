import java.util.Scanner;
import java.util.Stack;

public class HamilCycle {

    public static boolean isSafe(int[][] graph, int actual, Stack<Integer> path, int destino){

        if(graph[actual][destino]==0){
            return false;
        }
        Stack<Integer> aux=path;
        for(int i=0; i<aux.size(); i++){
            int node= aux.pop();
            if(node==destino){
                return false;
            }
        }
        return true;
    }

    public static boolean backtrack(int[][] graph, int k, int begin, int actual, Stack<Integer> path){
        
        if(begin==actual && k==0){
            return true;
        }

        for(int i=0; i<k; i++){
            if(isSafe(graph, actual, path, i)){
                path.push(actual);
                backtrack(graph, k, begin, i, path);
                path.pop();
            }
        }
        return false;
    }
    public static void main(String args[]){
        
        Scanner in = new Scanner(System.in);
        int countVer= in.nextInt();
        int [][] graph = new int[countVer][countVer];
        int [] solution= new int[countVer];
        Stack<Integer> path = new Stack<Integer>();

        for(int i=0; i<countVer; i++){
            for(int j=0; j<countVer; j++){
                graph[i][j]= in.nextInt();
            }
        }

        if(backtrack(graph, countVer, 0, 0, path)){
            for(int i=0; i<countVer; i++){
                System.out.print(solution[i] + "");
            }
        }
        else{
            System.out.print("Solution does not exist");
        }

        in.close();
    }
}
