package Sort.Bubble;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q23970 {
    static int[] A, B;
    static int N;
    static int result = 0;

    static void bubble_sort(){
        if(Arrays.equals(A, B)){
            result = 1;
            return;
        }

        for(int last=N; last>=2; last--){
            for(int i=0; i<last-1; i++){
                if(A[i]>A[i+1]){
                    int tmp = A[i];
                    A[i] = A[i+1];
                    A[i+1] = tmp;

                    if(A[i]==B[i] && A[i+1]==B[i+1] && Arrays.equals(A, B)){
                        result = 1;
                        return;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        A = new int[N];
        B = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) B[i] = Integer.parseInt(st.nextToken());

        bubble_sort();

        System.out.println(result);
    }
}
