import java.util.Scanner;

public class Q1010 {
    public static int[][] combi = new int[30][30];

    public static int combination(int m,int n){
        if(combi[m][n]>0){
            return combi[m][n];
        }
        else if(n==m || n==0){
            return combi[m][n] = 1;
        }
        else{
            return combi[m][n] = combination(m-1,n-1) + combination(m-1,n);
        }
    }

    public static void main(String[] args) {

        int T;
        int N;
        int M;

        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        for(int i=0; i<T; i++){
            N = sc.nextInt();
            M = sc.nextInt();
            System.out.println(combination(M,N));
        }
    }
   
}
