import java.util.Scanner;
import java.util.*;

public class Q1016 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int [] A = new int[N];
        Integer [] B = new Integer[N];
        int sum=0;

        for(int i = 0; i<N; i++){
            A[i] = sc.nextInt();
        }
        for(int j = 0; j<N; j++){
            B[j] = sc.nextInt();
        }

        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        for(int i = 0; i<N; i++){
            sum += A[i]*B[i];
        }

        System.out.println(sum);
    }
}
