import java.util.Scanner;

public class Q2563 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int total[][] = new int[100][100];
        int sum = 0;

        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                total[i][j] = 0;
            }
        }

        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            int hor = sc.nextInt();
            int ver = sc.nextInt();

            for(int v=ver; v<ver+10; v++){
                for(int h=hor; h<hor+10; h++){
                    total[v][h] = 1;
                }
            }
        }

        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                if(total[i][j] == 1) { sum += total[i][j];}
            }
        }

        System.out.println(sum);
    }    
}
